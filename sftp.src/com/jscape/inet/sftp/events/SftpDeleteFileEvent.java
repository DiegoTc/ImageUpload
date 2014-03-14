package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpDeleteFileEvent
  extends SftpEvent
{
  private String c;
  private String d;
  
  public SftpDeleteFileEvent(Sftp paramSftp, String paramString1, String paramString2)
  {
    super(paramSftp);
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public String getPath()
  {
    return this.d;
  }
  
  public String getFile()
  {
    return this.c;
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.deleteFile(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpDeleteFileEvent
 * JD-Core Version:    0.7.0.1
 */