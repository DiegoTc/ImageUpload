package com.jscape.filetransfer;

import java.util.EventObject;

public abstract class FileTransferEvent
  extends EventObject
{
  public static int a;
  
  protected FileTransferEvent(Object paramObject)
  {
    super(paramObject);
  }
  
  public abstract void accept(FileTransferListener paramFileTransferListener);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferEvent
 * JD-Core Version:    0.7.0.1
 */