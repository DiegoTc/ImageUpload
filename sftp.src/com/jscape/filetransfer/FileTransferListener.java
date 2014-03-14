package com.jscape.filetransfer;

import java.util.EventListener;

public abstract interface FileTransferListener
  extends EventListener
{
  public abstract void connected(FileTransferConnectedEvent paramFileTransferConnectedEvent);
  
  public abstract void disconnected(FileTransferDisconnectedEvent paramFileTransferDisconnectedEvent);
  
  public abstract void upload(FileTransferUploadEvent paramFileTransferUploadEvent);
  
  public abstract void download(FileTransferDownloadEvent paramFileTransferDownloadEvent);
  
  public abstract void progress(FileTransferProgressEvent paramFileTransferProgressEvent);
  
  public abstract void commandSent(FileTransferCommandEvent paramFileTransferCommandEvent);
  
  public abstract void responseReceived(FileTransferResponseEvent paramFileTransferResponseEvent);
  
  public abstract void deleteDir(FileTransferDeleteDirEvent paramFileTransferDeleteDirEvent);
  
  public abstract void deleteFile(FileTransferDeleteFileEvent paramFileTransferDeleteFileEvent);
  
  public abstract void renameFile(FileTransferRenameFileEvent paramFileTransferRenameFileEvent);
  
  public abstract void createDir(FileTransferCreateDirEvent paramFileTransferCreateDirEvent);
  
  public abstract void changeDir(FileTransferChangeDirEvent paramFileTransferChangeDirEvent);
  
  public abstract void sslHandshakeCompleted(FileTransferSslHandshakeEvent paramFileTransferSslHandshakeEvent);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferListener
 * JD-Core Version:    0.7.0.1
 */