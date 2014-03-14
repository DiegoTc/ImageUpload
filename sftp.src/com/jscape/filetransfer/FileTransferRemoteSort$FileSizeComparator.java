package com.jscape.filetransfer;

public class FileTransferRemoteSort$FileSizeComparator
  extends FileTransferRemoteSort.FileTransferRemoteComparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    int j = FileTransferEvent.a;
    int i = 0;
    FileTransferRemoteFile localFileTransferRemoteFile1 = (FileTransferRemoteFile)paramObject1;
    FileTransferRemoteFile localFileTransferRemoteFile2 = (FileTransferRemoteFile)paramObject2;
    Long localLong1 = new Long(localFileTransferRemoteFile1.getFilesize());
    Long localLong2 = new Long(localFileTransferRemoteFile2.getFilesize());
    if ((j != 0) || (localLong1 != null)) {
      if (j != 0) {
        break label73;
      }
    }
    label73:
    i = localLong2 == null ? 0 : localLong1.compareTo(localLong2);
    if (j == 0) {
      if (!this.isAscendent) {
        i = -i;
      }
    }
    return i;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferRemoteSort.FileSizeComparator
 * JD-Core Version:    0.7.0.1
 */