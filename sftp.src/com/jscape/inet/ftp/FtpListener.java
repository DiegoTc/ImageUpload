package com.jscape.inet.ftp;

import java.util.EventListener;

public abstract interface FtpListener
  extends EventListener
{
  public abstract void connected(FtpConnectedEvent paramFtpConnectedEvent);
  
  public abstract void disconnected(FtpDisconnectedEvent paramFtpDisconnectedEvent);
  
  public abstract void deleteDir(FtpDeleteDirEvent paramFtpDeleteDirEvent);
  
  public abstract void deleteFile(FtpDeleteFileEvent paramFtpDeleteFileEvent);
  
  public abstract void renameFile(FtpRenameFileEvent paramFtpRenameFileEvent);
  
  public abstract void createDir(FtpCreateDirEvent paramFtpCreateDirEvent);
  
  public abstract void changeDir(FtpChangeDirEvent paramFtpChangeDirEvent);
  
  public abstract void upload(FtpUploadEvent paramFtpUploadEvent);
  
  public abstract void download(FtpDownloadEvent paramFtpDownloadEvent);
  
  public abstract void progress(FtpProgressEvent paramFtpProgressEvent);
  
  public abstract void listing(FtpListingEvent paramFtpListingEvent);
  
  public abstract void commandSent(FtpCommandEvent paramFtpCommandEvent);
  
  public abstract void responseReceived(FtpResponseEvent paramFtpResponseEvent);
  
  public abstract void connectionLost(FtpConnectionLostEvent paramFtpConnectionLostEvent);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpListener
 * JD-Core Version:    0.7.0.1
 */