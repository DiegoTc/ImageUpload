package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;
import com.jscape.util.u;

public final class SftpProgressEvent
  extends SftpEvent
{
  public static final int UPLOAD = 0;
  public static final int DOWNLOAD = 1;
  private final String c;
  private final long d;
  private final long e;
  private final long f;
  private final String g;
  private final String h;
  private final int i;
  private static final String z = -1;
  
  public SftpProgressEvent(Sftp paramSftp, String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    super(paramSftp);
    u.a(paramString);
    u.a(paramInt, 0L, 1L, z + paramInt);
    this.c = paramString;
    this.e = paramLong1;
    this.d = paramLong2;
    this.f = 0L;
    this.i = paramInt;
    this.g = null;
    this.h = null;
  }
  
  public SftpProgressEvent(Sftp paramSftp, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramSftp);
    u.a(paramString);
    u.a(paramInt, 0L, 1L, z + paramInt);
    this.c = paramString;
    this.e = paramLong1;
    this.d = paramLong3;
    this.f = paramLong2;
    this.i = paramInt;
    this.g = null;
    this.h = null;
  }
  
  public SftpProgressEvent(Sftp paramSftp, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramSftp);
    u.a(paramString1);
    u.a(paramInt, 0L, 1L, z + paramInt);
    this.c = paramString1;
    this.e = paramLong1;
    this.d = paramLong3;
    this.f = paramLong2;
    this.i = paramInt;
    this.g = paramString2;
    this.h = null;
    if (u.a)
    {
      j++;
      SftpEvent.b = j;
    }
  }
  
  public SftpProgressEvent(Sftp paramSftp, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramSftp);
    u.a(paramString1);
    u.a(paramInt, 0L, 1L, z + paramInt);
    this.c = paramString1;
    this.e = paramLong1;
    this.d = paramLong3;
    this.f = paramLong2;
    this.i = paramInt;
    this.g = paramString2;
    this.h = paramString3;
    if (j != 0) {
      u.a = !u.a;
    }
  }
  
  public String getLocalFilePath()
  {
    return this.h;
  }
  
  public String getPath()
  {
    return this.g;
  }
  
  public long getReadBytes()
  {
    return this.f;
  }
  
  public String getFilename()
  {
    return this.c;
  }
  
  public long getBytes()
  {
    return this.e;
  }
  
  public long getTotalBytes()
  {
    return this.d;
  }
  
  public int getMode()
  {
    return this.i;
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.progress(this);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpProgressEvent
 * JD-Core Version:    0.7.0.1
 */