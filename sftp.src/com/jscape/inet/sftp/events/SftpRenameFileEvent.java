package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpRenameFileEvent
  extends SftpEvent
{
  private String c;
  private String d;
  private String e;
  
  public SftpRenameFileEvent(Sftp paramSftp, String paramString1, String paramString2, String paramString3)
  {
    super(paramSftp);
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
  }
  
  public String getOldFile()
  {
    return this.c;
  }
  
  public String getNewFile()
  {
    return this.d;
  }
  
  public String getPath()
  {
    return this.e;
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.renameFile(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpRenameFileEvent
 * JD-Core Version:    0.7.0.1
 */