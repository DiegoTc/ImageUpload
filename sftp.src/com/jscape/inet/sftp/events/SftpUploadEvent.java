package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpUploadEvent
  extends SftpTransferCompleteEvent
{
  public SftpUploadEvent(Sftp paramSftp, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    super(paramSftp, paramString1, paramString2, paramString3, paramLong1, paramLong2);
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.upload(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpUploadEvent
 * JD-Core Version:    0.7.0.1
 */