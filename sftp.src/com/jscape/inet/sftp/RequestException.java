package com.jscape.inet.sftp;

import com.jscape.util.u;

public class RequestException
  extends SftpException
{
  private final SftpPacket a;
  private final SftpPacket b;
  private static final String z = -1;
  
  public RequestException(SftpPacket paramSftpPacket1, SftpPacket paramSftpPacket2)
  {
    super(z);
    u.a(paramSftpPacket1);
    u.a(paramSftpPacket2);
    this.a = paramSftpPacket1;
    this.b = paramSftpPacket2;
  }
  
  public RequestException(String paramString, SftpPacket paramSftpPacket1, SftpPacket paramSftpPacket2)
  {
    super(paramString);
    u.a(paramSftpPacket1);
    u.a(paramSftpPacket2);
    this.a = paramSftpPacket1;
    this.b = paramSftpPacket2;
  }
  
  public SftpPacket getRequest()
  {
    return this.a;
  }
  
  public SftpPacket getResponse()
  {
    return this.b;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.RequestException
 * JD-Core Version:    0.7.0.1
 */