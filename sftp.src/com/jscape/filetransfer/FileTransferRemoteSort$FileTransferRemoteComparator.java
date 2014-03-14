package com.jscape.filetransfer;

import java.util.Comparator;

public abstract class FileTransferRemoteSort$FileTransferRemoteComparator
  implements Comparator
{
  protected boolean isAscendent = true;
  
  public void setAscendent(boolean paramBoolean)
  {
    this.isAscendent = paramBoolean;
  }
  
  public boolean getAscendent()
  {
    return this.isAscendent;
  }
  
  public abstract int compare(Object paramObject1, Object paramObject2);
  
  public boolean equals(Object paramObject)
  {
    int i = FileTransferEvent.a;
    if (i == 0) {
      if (this == paramObject) {
        return true;
      }
    }
    if (paramObject != null)
    {
      if (i != 0) {
        break label37;
      }
      if (getClass() == paramObject.getClass()) {}
    }
    else
    {
      return false;
    }
    label37:
    FileTransferRemoteComparator localFileTransferRemoteComparator = (FileTransferRemoteComparator)paramObject;
    if (i == 0) {}
    return this.isAscendent == localFileTransferRemoteComparator.isAscendent;
  }
  
  public int hashCode()
  {
    if (FileTransferEvent.a == 0) {}
    return this.isAscendent ? 1 : 0;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferRemoteSort.FileTransferRemoteComparator
 * JD-Core Version:    0.7.0.1
 */