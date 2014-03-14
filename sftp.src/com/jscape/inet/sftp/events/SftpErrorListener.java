package com.jscape.inet.sftp.events;

public abstract interface SftpErrorListener
  extends SftpListener
{
  public abstract void error(SftpErrorEvent paramSftpErrorEvent);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpErrorListener
 * JD-Core Version:    0.7.0.1
 */