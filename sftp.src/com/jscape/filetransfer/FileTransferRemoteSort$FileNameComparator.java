package com.jscape.filetransfer;

public class FileTransferRemoteSort$FileNameComparator
  extends FileTransferRemoteSort.FileTransferRemoteComparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    int j = FileTransferEvent.a;
    FileTransferRemoteFile localFileTransferRemoteFile1 = (FileTransferRemoteFile)paramObject1;
    FileTransferRemoteFile localFileTransferRemoteFile2 = (FileTransferRemoteFile)paramObject2;
    int i = 0;
    String str1 = localFileTransferRemoteFile1.getFilename();
    String str2 = localFileTransferRemoteFile2.getFilename();
    if ((j != 0) || (str1 != null)) {
      if (j != 0) {
        break label58;
      }
    }
    label58:
    i = str2 == null ? 0 : str1.compareToIgnoreCase(str2);
    if (j == 0) {
      if (!this.isAscendent) {
        i = -i;
      }
    }
    return i;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferRemoteSort.FileNameComparator
 * JD-Core Version:    0.7.0.1
 */