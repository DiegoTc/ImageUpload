package com.jscape.filetransfer;

import java.io.IOException;
import java.io.OutputStream;

class AftpFileTransfer$ProgressOutputStream
  extends OutputStream
{
  private final OutputStream a;
  private final String b;
  private final String c;
  private final String d;
  private final long e;
  private final long f;
  private final long g;
  private long h;
  private long i;
  final AftpFileTransfer j;
  
  private AftpFileTransfer$ProgressOutputStream(AftpFileTransfer paramAftpFileTransfer, OutputStream paramOutputStream, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramOutputStream;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramLong3;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
    this.h += 1L;
    b();
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
    this.h += paramInt2;
    b();
  }
  
  public void flush()
    throws IOException
  {
    this.a.flush();
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  private void b()
  {
    if ((FileTransferEvent.a != 0) || (c())) {
      d();
    }
  }
  
  private boolean c()
  {
    int k = FileTransferEvent.a;
    if (k == 0) {
      if (this.h - this.i <= this.g) {
        if (k != 0) {
          break label42;
        }
      }
    }
    label42:
    return this.h == this.f;
  }
  
  private void d()
  {
    this.i = this.h;
    AftpFileTransfer.access$300(this.j, new FileTransferProgressEvent(this.j, this.b, this.c, this.d, 1, this.e + this.h, 0L, this.f));
  }
  
  AftpFileTransfer$ProgressOutputStream(AftpFileTransfer paramAftpFileTransfer, OutputStream paramOutputStream, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, AftpFileTransfer.1 param1)
  {
    this(paramAftpFileTransfer, paramOutputStream, paramString1, paramString2, paramString3, paramLong1, paramLong2, paramLong3);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpFileTransfer.ProgressOutputStream
 * JD-Core Version:    0.7.0.1
 */