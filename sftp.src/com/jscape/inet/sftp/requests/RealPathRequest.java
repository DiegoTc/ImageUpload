package com.jscape.inet.sftp.requests;

import com.jscape.inet.sftp.RequestException;
import com.jscape.inet.sftp.SftpClient;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.SftpExceptionFactory;
import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SftpName;
import com.jscape.inet.sftp.packets.SshFxpName;
import com.jscape.inet.sftp.packets.SshFxpRealpath;
import com.jscape.inet.sftp.packets.SshFxpStatus;
import com.jscape.util.ec;
import com.jscape.util.u;

public class RealPathRequest
  implements Request
{
  protected String path;
  protected byte[] realPath;
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
  
  public String getRealPath(String paramString)
  {
    return ec.a(this.realPath, paramString);
  }
  
  public boolean isValid()
  {
    return this.path != null;
  }
  
  public void execute(SftpClient paramSftpClient)
    throws SftpException
  {
    boolean bool = AttributesRequest.a;
    u.c(isValid(), z);
    this.realPath = null;
    SftpPacket localSftpPacket1 = getRequestPacket();
    SftpPacket localSftpPacket2 = paramSftpClient.sendRequest(localSftpPacket1);
    if (!bool) {
      if (!isValidResponse(localSftpPacket2)) {
        throw getException(localSftpPacket1, localSftpPacket2);
      }
    }
    processResponse(localSftpPacket2);
    if (u.a) {
      AttributesRequest.a = !bool;
    }
  }
  
  protected SftpPacket getRequestPacket()
  {
    return new SshFxpRealpath(this.path);
  }
  
  protected boolean isValidResponse(SftpPacket paramSftpPacket)
  {
    boolean bool = AttributesRequest.a;
    if ((bool) || (paramSftpPacket.getClass().equals(SshFxpName.class))) {
      if (bool) {}
    }
    return ((SshFxpName)paramSftpPacket).getNames().length > 0;
  }
  
  protected void processResponse(SftpPacket paramSftpPacket)
  {
    this.realPath = ((SshFxpName)paramSftpPacket).getNames()[0].getFileName();
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
 * Qualified Name:     com.jscape.inet.sftp.requests.RealPathRequest
 * JD-Core Version:    0.7.0.1
 */