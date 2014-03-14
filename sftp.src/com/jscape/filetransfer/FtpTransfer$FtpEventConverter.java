package com.jscape.filetransfer;

import com.jscape.inet.ftp.FtpChangeDirEvent;
import com.jscape.inet.ftp.FtpCommandEvent;
import com.jscape.inet.ftp.FtpConnectedEvent;
import com.jscape.inet.ftp.FtpConnectionLostEvent;
import com.jscape.inet.ftp.FtpCreateDirEvent;
import com.jscape.inet.ftp.FtpDeleteDirEvent;
import com.jscape.inet.ftp.FtpDeleteFileEvent;
import com.jscape.inet.ftp.FtpDisconnectedEvent;
import com.jscape.inet.ftp.FtpDownloadEvent;
import com.jscape.inet.ftp.FtpErrorEvent;
import com.jscape.inet.ftp.FtpErrorListener;
import com.jscape.inet.ftp.FtpListingEvent;
import com.jscape.inet.ftp.FtpProgressEvent;
import com.jscape.inet.ftp.FtpRenameFileEvent;
import com.jscape.inet.ftp.FtpResponseEvent;
import com.jscape.inet.ftp.FtpUploadEvent;

public class FtpTransfer$FtpEventConverter
  implements FtpErrorListener
{
  final FtpTransfer a;
  
  protected FtpTransfer$FtpEventConverter(FtpTransfer paramFtpTransfer) {}
  
  public void changeDir(FtpChangeDirEvent paramFtpChangeDirEvent)
  {
    this.a.raiseEvent(new FileTransferChangeDirEvent(this.a, paramFtpChangeDirEvent.getDirectory()));
  }
  
  public void deleteFile(FtpDeleteFileEvent paramFtpDeleteFileEvent)
  {
    this.a.raiseEvent(new FileTransferDeleteFileEvent(this.a, paramFtpDeleteFileEvent.getFile(), paramFtpDeleteFileEvent.getPath()));
  }
  
  public void deleteDir(FtpDeleteDirEvent paramFtpDeleteDirEvent)
  {
    this.a.raiseEvent(new FileTransferDeleteDirEvent(this.a, paramFtpDeleteDirEvent.getDirectory(), paramFtpDeleteDirEvent.getPath()));
  }
  
  public void renameFile(FtpRenameFileEvent paramFtpRenameFileEvent)
  {
    this.a.raiseEvent(new FileTransferRenameFileEvent(this.a, paramFtpRenameFileEvent.getOldName(), paramFtpRenameFileEvent.getNewName(), paramFtpRenameFileEvent.getPath()));
  }
  
  public void createDir(FtpCreateDirEvent paramFtpCreateDirEvent)
  {
    this.a.raiseEvent(new FileTransferCreateDirEvent(this.a, paramFtpCreateDirEvent.getDirectory(), paramFtpCreateDirEvent.getPath()));
  }
  
  public void commandSent(FtpCommandEvent paramFtpCommandEvent)
  {
    this.a.raiseEvent(new FileTransferCommandEvent(this.a, paramFtpCommandEvent.getCommand()));
  }
  
  public void connected(FtpConnectedEvent paramFtpConnectedEvent)
  {
    this.a.raiseEvent(new FileTransferConnectedEvent(this.a, paramFtpConnectedEvent.getHostname()));
  }
  
  public void connectionLost(FtpConnectionLostEvent paramFtpConnectionLostEvent) {}
  
  public void disconnected(FtpDisconnectedEvent paramFtpDisconnectedEvent)
  {
    this.a.raiseEvent(new FileTransferDisconnectedEvent(this.a, paramFtpDisconnectedEvent.getHostname()));
  }
  
  public void download(FtpDownloadEvent paramFtpDownloadEvent)
  {
    this.a.raiseEvent(new FileTransferDownloadEvent(this.a, paramFtpDownloadEvent.getFilename(), paramFtpDownloadEvent.getPath(), paramFtpDownloadEvent.getLocalPath(), paramFtpDownloadEvent.getSize(), paramFtpDownloadEvent.getTime(), false));
  }
  
  public void listing(FtpListingEvent paramFtpListingEvent) {}
  
  public void progress(FtpProgressEvent paramFtpProgressEvent)
  {
    this.a.raiseEvent(new FileTransferProgressEvent(this.a, paramFtpProgressEvent.getFilename(), paramFtpProgressEvent.getAbsolutePath(), paramFtpProgressEvent.getLocalFilePath(), paramFtpProgressEvent.getMode(), paramFtpProgressEvent.getBytes(), paramFtpProgressEvent.getReadBytes(), paramFtpProgressEvent.getTotalBytes()));
  }
  
  public void responseReceived(FtpResponseEvent paramFtpResponseEvent)
  {
    this.a.raiseEvent(new FileTransferResponseEvent(this.a, paramFtpResponseEvent.getResponse()));
  }
  
  public void upload(FtpUploadEvent paramFtpUploadEvent)
  {
    this.a.raiseEvent(new FileTransferUploadEvent(this.a, paramFtpUploadEvent.getFilename(), paramFtpUploadEvent.getPath(), paramFtpUploadEvent.getLocalPath(), paramFtpUploadEvent.getSize(), paramFtpUploadEvent.getTime()));
  }
  
  public void error(FtpErrorEvent paramFtpErrorEvent)
  {
    this.a.raiseErrorEvent(new FileTransferErrorEvent(this.a, paramFtpErrorEvent.getFilename(), paramFtpErrorEvent.getPath(), paramFtpErrorEvent.getLocalPath(), paramFtpErrorEvent.getMode() == 0L ? 0 : 1));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FtpTransfer.FtpEventConverter
 * JD-Core Version:    0.7.0.1
 */