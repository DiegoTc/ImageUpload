package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpErrorEvent
  extends SftpEvent
{
  private final String c;
  private final String d;
  private final String e;
  private final int f;
  
  public SftpErrorEvent(Sftp paramSftp, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramSftp);
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramInt;
  }
  
  public String getFilename()
  {
    return this.c;
  }
  
  public String getPath()
  {
    return this.d;
  }
  
  public String getLocalPath()
  {
    return this.e;
  }
  
  public int getMode()
  {
    return this.f;
  }
  
  public void acceptListener(SftpListener paramSftpListener) {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpErrorEvent
 * JD-Core Version:    0.7.0.1
 */