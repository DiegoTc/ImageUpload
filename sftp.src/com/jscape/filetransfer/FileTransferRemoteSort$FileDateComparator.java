package com.jscape.filetransfer;

import java.util.Date;

public class FileTransferRemoteSort$FileDateComparator
  extends FileTransferRemoteSort.FileTransferRemoteComparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    int j = FileTransferEvent.a;
    int i = 0;
    FileTransferRemoteFile localFileTransferRemoteFile1 = (FileTransferRemoteFile)paramObject1;
    FileTransferRemoteFile localFileTransferRemoteFile2 = (FileTransferRemoteFile)paramObject2;
    Date localDate1 = localFileTransferRemoteFile1.getFileDate();
    Date localDate2 = localFileTransferRemoteFile2.getFileDate();
    if ((j != 0) || (localDate1 != null)) {
      if (j != 0) {
        break label59;
      }
    }
    label59:
    i = localDate2 == null ? 0 : localDate1.compareTo(localDate2);
    if (j == 0) {
      if (!this.isAscendent) {
        i = -i;
      }
    }
    return i;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferRemoteSort.FileDateComparator
 * JD-Core Version:    0.7.0.1
 */