package com.jscape.filetransfer;

import java.io.File;

 enum DownloadFileOperation$TransferStrategy$2
{
  DownloadFileOperation$TransferStrategy$2()
  {
    super(str, i, null);
  }
  
  public void apply(DownloadFileOperation paramDownloadFileOperation)
    throws Exception
  {
    try
    {
      long l = DownloadFileOperation.a(paramDownloadFileOperation).length();
      DownloadFileOperation.c(paramDownloadFileOperation).resumeDownload(DownloadFileOperation.b(paramDownloadFileOperation), l);
    }
    catch (Exception localException)
    {
      FROM_SCRATCH.apply(paramDownloadFileOperation);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.DownloadFileOperation.TransferStrategy.2
 * JD-Core Version:    0.7.0.1
 */