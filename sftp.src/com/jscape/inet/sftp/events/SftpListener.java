package com.jscape.inet.sftp.events;

public abstract interface SftpListener
{
  public abstract void connected(SftpConnectedEvent paramSftpConnectedEvent);
  
  public abstract void disconnected(SftpDisconnectedEvent paramSftpDisconnectedEvent);
  
  public abstract void download(SftpDownloadEvent paramSftpDownloadEvent);
  
  public abstract void upload(SftpUploadEvent paramSftpUploadEvent);
  
  public abstract void progress(SftpProgressEvent paramSftpProgressEvent);
  
  public abstract void dirListing(SftpListingEvent paramSftpListingEvent);
  
  public abstract void deleteDir(SftpDeleteDirEvent paramSftpDeleteDirEvent);
  
  public abstract void deleteFile(SftpDeleteFileEvent paramSftpDeleteFileEvent);
  
  public abstract void renameFile(SftpRenameFileEvent paramSftpRenameFileEvent);
  
  public abstract void createDir(SftpCreateDirEvent paramSftpCreateDirEvent);
  
  public abstract void changeDir(SftpChangeDirEvent paramSftpChangeDirEvent);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpListener
 * JD-Core Version:    0.7.0.1
 */