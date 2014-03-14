package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpConnectedEvent
  extends SftpEvent
{
  private final String c;
  
  public SftpConnectedEvent(Sftp paramSftp, String paramString)
  {
    super(paramSftp);
    this.c = paramString;
  }
  
  public String getHostname()
  {
    return this.c;
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.connected(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpConnectedEvent
 * JD-Core Version:    0.7.0.1
 */