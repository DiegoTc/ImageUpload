package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;
import com.jscape.util.u;

public abstract class SftpTransferCompleteEvent
  extends SftpEvent
{
  private final String c;
  private final String d;
  private final String e;
  private final long f;
  private final long g;
  
  protected SftpTransferCompleteEvent(Sftp paramSftp, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    super(paramSftp);
    u.a(paramString1);
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramLong1;
    this.g = paramLong2;
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
  
  public long getFilesize()
  {
    return this.f;
  }
  
  public long getTime()
  {
    return this.g;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpTransferCompleteEvent
 * JD-Core Version:    0.7.0.1
 */