package com.jscape.inet.ftp;

public class FtpProgressEvent
  extends FtpEvent
{
  public static final int UPLOAD = 0;
  public static final int DOWNLOAD = 1;
  private long b;
  private long c;
  private long d;
  private String e;
  private String f;
  private String g;
  private int h;
  
  public FtpProgressEvent(Object paramObject, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2)
  {
    super(paramObject);
    this.e = paramString1;
    this.f = paramString2;
    this.h = paramInt;
    this.b = paramLong1;
    this.d = 0L;
    this.c = paramLong2;
  }
  
  public FtpProgressEvent(Object paramObject, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramObject);
    this.e = paramString1;
    this.f = paramString2;
    this.h = paramInt;
    this.b = paramLong1;
    this.d = paramLong2;
    this.c = paramLong3;
  }
  
  public FtpProgressEvent(Object paramObject, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramObject);
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramInt;
    this.b = paramLong1;
    this.d = paramLong2;
    this.c = paramLong3;
  }
  
  public String getLocalFilePath()
  {
    return this.g;
  }
  
  public long getReadBytes()
  {
    return this.d;
  }
  
  public int getMode()
  {
    return this.h;
  }
  
  public String getFilename()
  {
    return this.e;
  }
  
  public String getAbsolutePath()
  {
    return this.f;
  }
  
  public long getBytes()
  {
    return this.b;
  }
  
  public long getTotalBytes()
  {
    return this.c;
  }
  
  public void accept(FtpListener paramFtpListener)
  {
    if ((FtpEvent.a) || (paramFtpListener != null)) {
      paramFtpListener.progress(this);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpProgressEvent
 * JD-Core Version:    0.7.0.1
 */