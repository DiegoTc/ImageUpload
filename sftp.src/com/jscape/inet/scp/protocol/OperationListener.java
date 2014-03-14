package com.jscape.inet.scp.protocol;

import java.io.File;

public abstract interface OperationListener
{
  public abstract void onTransferStarted(File paramFile);
  
  public abstract void onTransferProgress(File paramFile, long paramLong1, long paramLong2);
  
  public abstract void onTransferCompleted(File paramFile, long paramLong);
  
  public abstract void onDirectoryCreated(File paramFile);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.OperationListener
 * JD-Core Version:    0.7.0.1
 */