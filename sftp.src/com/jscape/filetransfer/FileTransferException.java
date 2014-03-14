package com.jscape.filetransfer;

public class FileTransferException
  extends Exception
{
  public static FileTransferException wrap(Throwable paramThrowable)
  {
    if (FileTransferEvent.a == 0) {}
    return paramThrowable.getMessage() != null ? new FileTransferException(paramThrowable.getMessage(), paramThrowable) : (paramThrowable instanceof FileTransferException) ? (FileTransferException)paramThrowable : new FileTransferException(paramThrowable);
  }
  
  public FileTransferException() {}
  
  public FileTransferException(String paramString)
  {
    super(paramString);
  }
  
  public FileTransferException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public FileTransferException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public Throwable getException()
  {
    return getCause();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferException
 * JD-Core Version:    0.7.0.1
 */