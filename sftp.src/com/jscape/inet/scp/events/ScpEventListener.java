package com.jscape.inet.scp.events;

public abstract interface ScpEventListener
{
  public abstract void connected(ScpConnectedEvent paramScpConnectedEvent);
  
  public abstract void disconnected(ScpDisconnectedEvent paramScpDisconnectedEvent);
  
  public abstract void download(ScpFileDownloadedEvent paramScpFileDownloadedEvent);
  
  public abstract void upload(ScpFileUploadedEvent paramScpFileUploadedEvent);
  
  public abstract void progress(ScpTransferProgressEvent paramScpTransferProgressEvent);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.events.ScpEventListener
 * JD-Core Version:    0.7.0.1
 */