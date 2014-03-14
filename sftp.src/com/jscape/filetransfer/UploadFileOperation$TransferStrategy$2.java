package com.jscape.filetransfer;

 enum UploadFileOperation$TransferStrategy$2
{
  UploadFileOperation$TransferStrategy$2()
  {
    super(str, i, null);
  }
  
  public void apply(UploadFileOperation paramUploadFileOperation)
    throws Exception
  {
    try
    {
      long l = UploadFileOperation.c(paramUploadFileOperation).getFilesize(UploadFileOperation.b(paramUploadFileOperation));
      UploadFileOperation.c(paramUploadFileOperation).resumeUpload(UploadFileOperation.a(paramUploadFileOperation), l);
    }
    catch (Exception localException)
    {
      FROM_SCRATCH.apply(paramUploadFileOperation);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.UploadFileOperation.TransferStrategy.2
 * JD-Core Version:    0.7.0.1
 */