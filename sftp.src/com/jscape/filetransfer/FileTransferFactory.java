package com.jscape.filetransfer;

public abstract interface FileTransferFactory
{
  public abstract FileTransfer transferFor(FileTransferParameters paramFileTransferParameters)
    throws FileTransferFactory.OperationException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferFactory
 * JD-Core Version:    0.7.0.1
 */