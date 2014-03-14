package com.jscape.filetransfer;

import java.io.File;

 enum DownloadFileOperation$TransferStrategy$1
{
  DownloadFileOperation$TransferStrategy$1()
  {
    super(str, i, null);
  }
  
  public void apply(DownloadFileOperation paramDownloadFileOperation)
    throws Exception
  {
    DownloadFileOperation.c(paramDownloadFileOperation).download(DownloadFileOperation.a(paramDownloadFileOperation).getName(), DownloadFileOperation.b(paramDownloadFileOperation));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.DownloadFileOperation.TransferStrategy.1
 * JD-Core Version:    0.7.0.1
 */