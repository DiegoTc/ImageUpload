package com.jscape.filetransfer;

import java.io.IOException;
import java.io.InputStream;

class AftpFileTransfer$ProgressInputStream
  extends InputStream
{
  private final InputStream a;
  private final String b;
  private final String c;
  private final String d;
  private final long e;
  private final long f;
  private final long g;
  private long h;
  private long i;
  final AftpFileTransfer j;
  
  private AftpFileTransfer$ProgressInputStream(AftpFileTransfer paramAftpFileTransfer, InputStream paramInputStream, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramInputStream;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramLong3;
  }
  
  public int read()
    throws IOException
  {
    int k = this.a.read();
    if (FileTransferEvent.a == 0) {
      if (k != -1)
      {
        this.h += 1L;
        b();
      }
    }
    return k;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int k = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    if (FileTransferEvent.a == 0) {
      if (k != -1)
      {
        this.h += k;
        b();
      }
    }
    return k;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l = this.a.skip(paramLong);
    if (FileTransferEvent.a == 0) {
      if (l != -1L)
      {
        this.h += l;
        b();
      }
    }
    return l;
  }
  
  public int available()
    throws IOException
  {
    return this.a.available();
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public void reset()
    throws IOException
  {
    this.a.reset();
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  private void b()
  {
    if ((FileTransferEvent.a != 0) || (c())) {
      d();
    }
  }
  
  private boolean c()
  {
    if (FileTransferEvent.a == 0) {}
    return this.h - this.i > this.g;
  }
  
  private void d()
  {
    this.i = this.h;
    AftpFileTransfer.access$300(this.j, new FileTransferProgressEvent(this.j, this.b, this.c, this.d, 0, this.e + this.h, 0L, this.f));
  }
  
  AftpFileTransfer$ProgressInputStream(AftpFileTransfer paramAftpFileTransfer, InputStream paramInputStream, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, AftpFileTransfer.1 param1)
  {
    this(paramAftpFileTransfer, paramInputStream, paramString1, paramString2, paramString3, paramLong1, paramLong2, paramLong3);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpFileTransfer.ProgressInputStream
 * JD-Core Version:    0.7.0.1
 */