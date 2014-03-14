package com.jscape.filetransfer;

public class FileTransferDeniedException
  extends FileTransferException
{
  public FileTransferDeniedException(String paramString)
  {
    super(paramString);
  }
  
  public FileTransferDeniedException(String paramString, Exception paramException)
  {
    super(paramString, paramException);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferDeniedException
 * JD-Core Version:    0.7.0.1
 */