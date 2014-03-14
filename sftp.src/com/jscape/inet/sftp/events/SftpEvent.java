package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;
import com.jscape.util.u;

public abstract class SftpEvent
{
  private final Sftp a;
  public static int b;
  
  protected SftpEvent(Sftp paramSftp)
  {
    u.a(paramSftp);
    this.a = paramSftp;
  }
  
  public Sftp getSource()
  {
    return this.a;
  }
  
  public abstract void acceptListener(SftpListener paramSftpListener);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpEvent
 * JD-Core Version:    0.7.0.1
 */