package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpCreateDirEvent
  extends SftpEvent
{
  private String c;
  private String d;
  
  public SftpCreateDirEvent(Sftp paramSftp, String paramString1, String paramString2)
  {
    super(paramSftp);
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public String getDirectory()
  {
    return this.c;
  }
  
  public String getPath()
  {
    return this.d;
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.createDir(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpCreateDirEvent
 * JD-Core Version:    0.7.0.1
 */