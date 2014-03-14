package com.jscape.inet.sftp.requests;

import com.jscape.inet.file.JFilePermissions;
import com.jscape.inet.file.JFilePermissions.Permission;
import com.jscape.inet.file.JFileType;
import com.jscape.inet.sftp.RequestException;
import com.jscape.inet.sftp.SftpClient;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.SftpExceptionFactory;
import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SftpFileAttributes;
import com.jscape.inet.sftp.packets.SshFxpSetstat;
import com.jscape.inet.sftp.packets.SshFxpStatus;
import com.jscape.util.u;
import java.util.Date;

public class SetAttributesRequest
  implements Request
{
  protected static final int TIME_FACTOR = 1000;
  protected String path;
  protected Integer permissions;
  protected Date modificationTime;
  private static final String z = -1;
  
  public String getPath()
  {
    return this.path;
  }
  
  public void setPath(String paramString)
  {
    u.a(paramString);
    this.path = paramString;
  }
  
  public int getPermissions()
  {
    return this.permissions.intValue();
  }
  
  public void setPermissions(int paramInt)
  {
    this.permissions = new Integer(paramInt);
  }
  
  public Date getModificationTime()
  {
    return this.modificationTime;
  }
  
  public void setModificationTime(Date paramDate)
  {
    this.modificationTime = paramDate;
  }
  
  public boolean isValid()
  {
    boolean bool = AttributesRequest.a;
    return ((bool) || (this.path != null)) && (((!bool) && (this.permissions != null)) || (this.modificationTime != null));
  }
  
  public void execute(SftpClient paramSftpClient)
    throws SftpException
  {
    u.c(isValid(), z);
    SftpPacket localSftpPacket1 = getRequestPacket();
    SftpPacket localSftpPacket2 = paramSftpClient.sendRequest(localSftpPacket1);
    if ((AttributesRequest.a) || (!isValidResponse(localSftpPacket2))) {
      throw getException(localSftpPacket1, localSftpPacket2);
    }
  }
  
  protected SftpPacket getRequestPacket()
  {
    boolean bool = AttributesRequest.a;
    SftpFileAttributes localSftpFileAttributes = new SftpFileAttributes();
    if (!bool) {
      if (this.permissions != null)
      {
        JFilePermissions.Permission localPermission1 = new JFilePermissions.Permission(this.permissions.intValue() / 100);
        JFilePermissions.Permission localPermission2 = new JFilePermissions.Permission(this.permissions.intValue() / 10 % 10);
        JFilePermissions.Permission localPermission3 = new JFilePermissions.Permission(this.permissions.intValue() % 10);
        localSftpFileAttributes.setPermissions(new JFilePermissions(JFileType.UNKNOWN, localPermission1, localPermission2, localPermission3));
      }
    }
    if ((bool) || (this.modificationTime != null))
    {
      long l = this.modificationTime.getTime() / 1000L;
      localSftpFileAttributes.setAtime(l);
      localSftpFileAttributes.setMtime(l);
    }
    return new SshFxpSetstat(this.path, localSftpFileAttributes);
  }
  
  protected boolean isValidResponse(SftpPacket paramSftpPacket)
  {
    boolean bool = AttributesRequest.a;
    if ((bool) || (paramSftpPacket.getClass().equals(SshFxpStatus.class))) {
      if (bool) {}
    }
    return ((SshFxpStatus)paramSftpPacket).getCode() == 0;
  }
  
  protected SftpException getException(SftpPacket paramSftpPacket1, SftpPacket paramSftpPacket2)
  {
    if ((AttributesRequest.a) || (paramSftpPacket2.getClass().equals(SshFxpStatus.class))) {
      return SftpExceptionFactory.getException((SshFxpStatus)paramSftpPacket2, this.path);
    }
    return new RequestException(paramSftpPacket1, paramSftpPacket2);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.SetAttributesRequest
 * JD-Core Version:    0.7.0.1
 */