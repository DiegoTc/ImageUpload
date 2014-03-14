package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;

public final class SftpDownloadEvent
  extends SftpTransferCompleteEvent
{
  public SftpDownloadEvent(Sftp paramSftp, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    super(paramSftp, paramString1, paramString2, paramString3, paramLong1, paramLong2);
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.download(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpDownloadEvent
 * JD-Core Version:    0.7.0.1
 */