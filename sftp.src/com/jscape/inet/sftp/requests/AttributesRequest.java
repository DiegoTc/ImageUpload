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
import com.jscape.inet.sftp.packets.SftpFileAttributes.AttributePresenceFlags;
import com.jscape.inet.sftp.packets.SshFxpAttrs;
import com.jscape.inet.sftp.packets.SshFxpLstat;
import com.jscape.inet.sftp.packets.SshFxpStat;
import com.jscape.inet.sftp.packets.SshFxpStatus;
import com.jscape.util.u;
import java.util.Date;

public class AttributesRequest
  implements Request
{
  protected String path;
  protected boolean followLink;
  protected Long size;
  protected Integer permissions;
  protected Date modificationDate;
  protected Boolean isDirectory;
  public static boolean a;
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
  
  public boolean getFollowLink()
  {
    return this.followLink;
  }
  
  public void setFollowLink(boolean paramBoolean)
  {
    this.followLink = paramBoolean;
  }
  
  public Long getSize()
  {
    return this.size;
  }
  
  public Integer getPermissions()
  {
    return this.permissions;
  }
  
  public Date getModificationDate()
  {
    return this.modificationDate;
  }
  
  public Boolean isDirectory()
  {
    return this.isDirectory;
  }
  
  public boolean isValid()
  {
    return this.path != null;
  }
  
  public void execute(SftpClient paramSftpClient)
    throws SftpException
  {
    u.c(isValid(), z);
    initResults();
    SftpPacket localSftpPacket1 = getRequestPacket();
    SftpPacket localSftpPacket2 = paramSftpClient.sendRequest(localSftpPacket1);
    if (!a) {
      if (!isValidResponse(localSftpPacket2)) {
        throw getException(localSftpPacket1, localSftpPacket2);
      }
    }
    processResponse(localSftpPacket2);
  }
  
  protected void initResults()
  {
    this.size = null;
    this.permissions = null;
    this.modificationDate = null;
    this.isDirectory = null;
  }
  
  protected SftpPacket getRequestPacket()
  {
    return this.followLink ? new SshFxpLstat(this.path) : new SshFxpStat(this.path);
  }
  
  protected boolean isValidResponse(SftpPacket paramSftpPacket)
  {
    return paramSftpPacket.getClass().equals(SshFxpAttrs.class);
  }
  
  protected void processResponse(SftpPacket paramSftpPacket)
  {
    boolean bool = a;
    SftpFileAttributes localSftpFileAttributes = ((SshFxpAttrs)paramSftpPacket).getAttrs();
    if (!bool) {
      if (localSftpFileAttributes.getFlags().isSizePresent()) {
        this.size = new Long(localSftpFileAttributes.getSize());
      }
    }
    if (!bool) {
      if (localSftpFileAttributes.getFlags().isPermissionsPresent())
      {
        int i = localSftpFileAttributes.getPermissions().getOwnerPermission().intValue();
        int j = localSftpFileAttributes.getPermissions().getGroupPermission().intValue();
        int k = localSftpFileAttributes.getPermissions().getOtherPermission().intValue();
        this.permissions = new Integer(i * 100 + j * 10 + k);
        this.isDirectory = new Boolean(localSftpFileAttributes.getPermissions().getType() == JFileType.DIRECTORY);
      }
    }
    if (localSftpFileAttributes.getFlags().isAcModTimePresent()) {
      this.modificationDate = new Date(localSftpFileAttributes.getMtime() * 1000L);
    }
  }
  
  protected SftpException getException(SftpPacket paramSftpPacket1, SftpPacket paramSftpPacket2)
  {
    if ((a) || (paramSftpPacket2.getClass().equals(SshFxpStatus.class))) {
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
 * Qualified Name:     com.jscape.inet.sftp.requests.AttributesRequest
 * JD-Core Version:    0.7.0.1
 */