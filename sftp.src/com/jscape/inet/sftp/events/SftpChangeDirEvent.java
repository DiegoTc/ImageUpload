package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpChangeDirEvent
  extends SftpEvent
{
  private String c;
  
  public SftpChangeDirEvent(Sftp paramSftp, String paramString)
  {
    super(paramSftp);
    this.c = paramString;
  }
  
  public String getDirectory()
  {
    return this.c;
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.changeDir(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpChangeDirEvent
 * JD-Core Version:    0.7.0.1
 */