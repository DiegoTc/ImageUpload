package com.jscape.inet.ftp;

public class FtpAdapter
  implements FtpListener
{
  public void connected(FtpConnectedEvent paramFtpConnectedEvent) {}
  
  public void disconnected(FtpDisconnectedEvent paramFtpDisconnectedEvent) {}
  
  public void upload(FtpUploadEvent paramFtpUploadEvent) {}
  
  public void download(FtpDownloadEvent paramFtpDownloadEvent) {}
  
  public void progress(FtpProgressEvent paramFtpProgressEvent) {}
  
  public void listing(FtpListingEvent paramFtpListingEvent) {}
  
  public void commandSent(FtpCommandEvent paramFtpCommandEvent) {}
  
  public void responseReceived(FtpResponseEvent paramFtpResponseEvent) {}
  
  public void connectionLost(FtpConnectionLostEvent paramFtpConnectionLostEvent) {}
  
  public void deleteDir(FtpDeleteDirEvent paramFtpDeleteDirEvent) {}
  
  public void deleteFile(FtpDeleteFileEvent paramFtpDeleteFileEvent) {}
  
  public void renameFile(FtpRenameFileEvent paramFtpRenameFileEvent) {}
  
  public void createDir(FtpCreateDirEvent paramFtpCreateDirEvent) {}
  
  public void changeDir(FtpChangeDirEvent paramFtpChangeDirEvent) {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpAdapter
 * JD-Core Version:    0.7.0.1
 */