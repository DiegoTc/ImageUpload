package com.jscape.inet.ssh.util;

import java.net.InetAddress;

public class VerifyHostKeyEvent
{
  private InetAddress a;
  private String b;
  private byte[] c;
  private boolean d = true;
  
  public VerifyHostKeyEvent(InetAddress paramInetAddress, String paramString)
  {
    this.a = paramInetAddress;
    this.b = paramString;
  }
  
  public VerifyHostKeyEvent(InetAddress paramInetAddress, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramInetAddress;
    this.b = paramString;
    this.c = paramArrayOfByte;
  }
  
  public InetAddress getHost()
  {
    return this.a;
  }
  
  public String getFingerprint()
  {
    return this.b;
  }
  
  public byte[] getServerHostKey()
  {
    return this.c;
  }
  
  public void setVerify(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean getVerify()
  {
    return this.d;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.VerifyHostKeyEvent
 * JD-Core Version:    0.7.0.1
 */