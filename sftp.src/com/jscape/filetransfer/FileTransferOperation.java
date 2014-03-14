package com.jscape.filetransfer;

public abstract interface FileTransferOperation
{
  public static final FileTransferOperation NULL = new FileTransferOperation.1();
  
  public abstract void applyTo(FileTransfer paramFileTransfer)
    throws FileTransferException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferOperation
 * JD-Core Version:    0.7.0.1
 */