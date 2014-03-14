package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpDeleteDirEvent
  extends SftpEvent
{
  private String c;
  private String d;
  
  public SftpDeleteDirEvent(Sftp paramSftp, String paramString1, String paramString2)
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
    paramSftpListener.deleteDir(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpDeleteDirEvent
 * JD-Core Version:    0.7.0.1
 */