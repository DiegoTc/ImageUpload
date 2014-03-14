package com.jscape.inet.sftp.events;

public class SftpAdapter
  implements SftpListener
{
  public void connected(SftpConnectedEvent paramSftpConnectedEvent) {}
  
  public void disconnected(SftpDisconnectedEvent paramSftpDisconnectedEvent) {}
  
  public void download(SftpDownloadEvent paramSftpDownloadEvent) {}
  
  public void upload(SftpUploadEvent paramSftpUploadEvent) {}
  
  public void progress(SftpProgressEvent paramSftpProgressEvent) {}
  
  public void dirListing(SftpListingEvent paramSftpListingEvent) {}
  
  public void deleteDir(SftpDeleteDirEvent paramSftpDeleteDirEvent) {}
  
  public void deleteFile(SftpDeleteFileEvent paramSftpDeleteFileEvent) {}
  
  public void renameFile(SftpRenameFileEvent paramSftpRenameFileEvent) {}
  
  public void createDir(SftpCreateDirEvent paramSftpCreateDirEvent) {}
  
  public void changeDir(SftpChangeDirEvent paramSftpChangeDirEvent) {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpAdapter
 * JD-Core Version:    0.7.0.1
 */