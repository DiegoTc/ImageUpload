package com.jscape.filetransfer;

final class FileTransferRemoteFile$1
  implements FileTransferRemoteFile.Filter
{
  public boolean accept(FileTransferRemoteFile paramFileTransferRemoteFile)
  {
    if (FileTransferEvent.a == 0) {}
    return !paramFileTransferRemoteFile.isDirectory();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferRemoteFile.1
 * JD-Core Version:    0.7.0.1
 */