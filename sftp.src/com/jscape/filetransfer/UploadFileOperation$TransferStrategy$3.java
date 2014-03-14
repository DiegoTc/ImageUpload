package com.jscape.filetransfer;

 enum UploadFileOperation$TransferStrategy$3
{
  UploadFileOperation$TransferStrategy$3()
  {
    super(str, i, null);
  }
  
  public void apply(UploadFileOperation paramUploadFileOperation)
    throws Exception
  {
    if (UploadFileOperation.d(paramUploadFileOperation) > 0)
    {
      ALWAYS_RESUME.apply(paramUploadFileOperation);
      if (FileTransferEvent.a == 0) {}
    }
    else
    {
      FROM_SCRATCH.apply(paramUploadFileOperation);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.UploadFileOperation.TransferStrategy.3
 * JD-Core Version:    0.7.0.1
 */