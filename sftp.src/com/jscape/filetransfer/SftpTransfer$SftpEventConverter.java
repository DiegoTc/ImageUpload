package com.jscape.filetransfer;

import com.jscape.inet.sftp.events.SftpChangeDirEvent;
import com.jscape.inet.sftp.events.SftpConnectedEvent;
import com.jscape.inet.sftp.events.SftpCreateDirEvent;
import com.jscape.inet.sftp.events.SftpDeleteDirEvent;
import com.jscape.inet.sftp.events.SftpDeleteFileEvent;
import com.jscape.inet.sftp.events.SftpDisconnectedEvent;
import com.jscape.inet.sftp.events.SftpDownloadEvent;
import com.jscape.inet.sftp.events.SftpErrorEvent;
import com.jscape.inet.sftp.events.SftpErrorListener;
import com.jscape.inet.sftp.events.SftpListingEvent;
import com.jscape.inet.sftp.events.SftpProgressEvent;
import com.jscape.inet.sftp.events.SftpRenameFileEvent;
import com.jscape.inet.sftp.events.SftpUploadEvent;

public class SftpTransfer$SftpEventConverter
  implements SftpErrorListener
{
  final SftpTransfer a;
  
  protected SftpTransfer$SftpEventConverter(SftpTransfer paramSftpTransfer) {}
  
  public void changeDir(SftpChangeDirEvent paramSftpChangeDirEvent)
  {
    this.a.raiseEvent(new FileTransferChangeDirEvent(this.a, paramSftpChangeDirEvent.getDirectory()));
  }
  
  public void connected(SftpConnectedEvent paramSftpConnectedEvent)
  {
    this.a.raiseEvent(new FileTransferConnectedEvent(this.a, paramSftpConnectedEvent.getHostname()));
  }
  
  public void createDir(SftpCreateDirEvent paramSftpCreateDirEvent)
  {
    this.a.raiseEvent(new FileTransferCreateDirEvent(this.a, paramSftpCreateDirEvent.getDirectory(), paramSftpCreateDirEvent.getPath()));
  }
  
  public void deleteDir(SftpDeleteDirEvent paramSftpDeleteDirEvent)
  {
    this.a.raiseEvent(new FileTransferDeleteDirEvent(this.a, paramSftpDeleteDirEvent.getDirectory(), paramSftpDeleteDirEvent.getPath()));
  }
  
  public void deleteFile(SftpDeleteFileEvent paramSftpDeleteFileEvent)
  {
    this.a.raiseEvent(new FileTransferDeleteFileEvent(this.a, paramSftpDeleteFileEvent.getFile(), paramSftpDeleteFileEvent.getPath()));
  }
  
  public void dirListing(SftpListingEvent paramSftpListingEvent) {}
  
  public void disconnected(SftpDisconnectedEvent paramSftpDisconnectedEvent)
  {
    this.a.raiseEvent(new FileTransferDisconnectedEvent(this.a, paramSftpDisconnectedEvent.getHostname()));
  }
  
  public void download(SftpDownloadEvent paramSftpDownloadEvent)
  {
    this.a.raiseEvent(new FileTransferDownloadEvent(this.a, paramSftpDownloadEvent.getFilename(), paramSftpDownloadEvent.getPath(), paramSftpDownloadEvent.getLocalPath(), paramSftpDownloadEvent.getFilesize(), paramSftpDownloadEvent.getTime(), false));
  }
  
  public void progress(SftpProgressEvent paramSftpProgressEvent)
  {
    this.a.raiseEvent(new FileTransferProgressEvent(this.a, paramSftpProgressEvent.getFilename(), paramSftpProgressEvent.getPath(), paramSftpProgressEvent.getLocalFilePath(), paramSftpProgressEvent.getMode(), paramSftpProgressEvent.getBytes(), paramSftpProgressEvent.getReadBytes(), paramSftpProgressEvent.getTotalBytes()));
  }
  
  public void renameFile(SftpRenameFileEvent paramSftpRenameFileEvent)
  {
    this.a.raiseEvent(new FileTransferRenameFileEvent(this.a, paramSftpRenameFileEvent.getOldFile(), paramSftpRenameFileEvent.getNewFile(), paramSftpRenameFileEvent.getPath()));
  }
  
  public void upload(SftpUploadEvent paramSftpUploadEvent)
  {
    this.a.raiseEvent(new FileTransferUploadEvent(this.a, paramSftpUploadEvent.getFilename(), paramSftpUploadEvent.getPath(), paramSftpUploadEvent.getLocalPath(), paramSftpUploadEvent.getFilesize(), paramSftpUploadEvent.getTime()));
  }
  
  public void error(SftpErrorEvent paramSftpErrorEvent)
  {
    this.a.raiseErrorEvent(new FileTransferErrorEvent(this.a, paramSftpErrorEvent.getFilename(), paramSftpErrorEvent.getPath(), paramSftpErrorEvent.getLocalPath(), paramSftpErrorEvent.getMode()));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.SftpTransfer.SftpEventConverter
 * JD-Core Version:    0.7.0.1
 */