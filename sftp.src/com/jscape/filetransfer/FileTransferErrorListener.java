package com.jscape.filetransfer;

public abstract interface FileTransferErrorListener
  extends FileTransferListener
{
  public abstract void error(FileTransferErrorEvent paramFileTransferErrorEvent);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferErrorListener
 * JD-Core Version:    0.7.0.1
 */