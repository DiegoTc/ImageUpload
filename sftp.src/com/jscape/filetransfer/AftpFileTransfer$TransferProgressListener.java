package com.jscape.filetransfer;

import com.jscape.inet.a.o;

class AftpFileTransfer$TransferProgressListener
  implements o
{
  private final String b;
  private final String c;
  private final String d;
  private final int e;
  private final long f;
  private final long g;
  final AftpFileTransfer h;
  
  public AftpFileTransfer$TransferProgressListener(AftpFileTransfer paramAftpFileTransfer, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramInt;
    this.f = paramLong1;
    this.g = paramLong2;
  }
  
  public void onTransferFileProgress(long paramLong)
  {
    AftpFileTransfer.access$300(this.h, new FileTransferProgressEvent(this.h, this.b, this.c, this.d, this.e, this.f + paramLong, 0L, this.g));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpFileTransfer.TransferProgressListener
 * JD-Core Version:    0.7.0.1
 */