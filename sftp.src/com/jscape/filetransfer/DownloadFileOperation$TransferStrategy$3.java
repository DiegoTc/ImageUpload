package com.jscape.filetransfer;

 enum DownloadFileOperation$TransferStrategy$3
{
  DownloadFileOperation$TransferStrategy$3()
  {
    super(str, i, null);
  }
  
  public void apply(DownloadFileOperation paramDownloadFileOperation)
    throws Exception
  {
    if (DownloadFileOperation.d(paramDownloadFileOperation) > 0)
    {
      ALWAYS_RESUME.apply(paramDownloadFileOperation);
      if (FileTransferEvent.a == 0) {}
    }
    else
    {
      FROM_SCRATCH.apply(paramDownloadFileOperation);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.DownloadFileOperation.TransferStrategy.3
 * JD-Core Version:    0.7.0.1
 */