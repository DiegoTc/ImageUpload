package com.jscape.filetransfer;

import com.jscape.util.fc;

@fc
public class RemoteDirectory$PathDirectory
  implements RemoteDirectory
{
  private final String path;
  private static final String z = -1;
  
  public RemoteDirectory$PathDirectory(String paramString)
  {
    this.path = paramString;
  }
  
  public void applyTo(FileTransfer paramFileTransfer)
    throws FileTransferException
  {
    paramFileTransfer.setDir(this.path);
  }
  
  public String toString()
  {
    return z + this.path + '\'' + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.RemoteDirectory.PathDirectory
 * JD-Core Version:    0.7.0.1
 */