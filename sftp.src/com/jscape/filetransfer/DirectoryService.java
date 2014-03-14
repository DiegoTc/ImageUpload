package com.jscape.filetransfer;

import com.jscape.util.b.s;
import com.jscape.util.bc;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;

public class DirectoryService
{
  private static final String z = -1;
  
  public static s<DirectoryService.Directory<File>> asTree(File paramFile)
  {
    bc.a(paramFile.isDirectory(), z);
    DirectoryService.DirectoryEntries localDirectoryEntries = a(paramFile);
    s locals = s.a(new DirectoryService.Directory(paramFile, localDirectoryEntries.files));
    a(localDirectoryEntries.directories, locals);
    return locals;
  }
  
  public static s<DirectoryService.Directory<FileTransferRemoteFile>> asTree(String paramString, FileTransfer paramFileTransfer)
    throws FileTransferException
  {
    String str = paramFileTransfer.getDir();
    paramFileTransfer.setDir(paramString);
    DirectoryService.DirectoryEntries localDirectoryEntries = a(paramFileTransfer);
    FileTransferRemoteFile localFileTransferRemoteFile = new FileTransferRemoteFile(paramString, "", true, false, 0L, new Date(), true, true);
    s locals = s.a(new DirectoryService.Directory(localFileTransferRemoteFile, localDirectoryEntries.files));
    a(localDirectoryEntries.directories, locals, paramFileTransfer);
    paramFileTransfer.setDir(str);
    return locals;
  }
  
  private static DirectoryService.DirectoryEntries<File> a(File paramFile)
  {
    int k = FileTransferEvent.a;
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    File[] arrayOfFile = paramFile.listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    label95:
    do
    {
      if (j >= i) {
        break;
      }
      File localFile = arrayOfFile[j];
      if (k == 0) {
        if (localFile.isDirectory())
        {
          localLinkedList1.add(localFile);
          if (k == 0) {
            break label95;
          }
        }
      }
      if ((k != 0) || (localFile.isFile())) {
        localLinkedList2.add(localFile);
      }
      j++;
    } while (k == 0);
    return new DirectoryService.DirectoryEntries(localLinkedList1, localLinkedList2, null);
  }
  
  private static DirectoryService.DirectoryEntries<FileTransferRemoteFile> a(FileTransfer paramFileTransfer)
    throws FileTransferException
  {
    int i = FileTransferEvent.a;
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Enumeration localEnumeration = paramFileTransfer.getDirListing();
    do
    {
      if (!localEnumeration.hasMoreElements()) {
        break;
      }
      FileTransferRemoteFile localFileTransferRemoteFile = (FileTransferRemoteFile)localEnumeration.nextElement();
      if (i == 0) {
        if (localFileTransferRemoteFile.isDirectory())
        {
          localLinkedList1.add(localFileTransferRemoteFile);
          if (i == 0) {
            continue;
          }
        }
      }
      localLinkedList2.add(localFileTransferRemoteFile);
    } while (i == 0);
    return new DirectoryService.DirectoryEntries(localLinkedList1, localLinkedList2, null);
  }
  
  private static void a(Collection<File> paramCollection, s<DirectoryService.Directory<File>> params)
  {
    int i = FileTransferEvent.a;
    Iterator localIterator = paramCollection.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      File localFile = (File)localIterator.next();
      DirectoryService.DirectoryEntries localDirectoryEntries = a(localFile);
      s locals = params.d(new DirectoryService.Directory(localFile, localDirectoryEntries.files));
      a(localDirectoryEntries.directories, locals);
    } while (i == 0);
  }
  
  private static void a(Collection<FileTransferRemoteFile> paramCollection, s<DirectoryService.Directory<FileTransferRemoteFile>> params, FileTransfer paramFileTransfer)
    throws FileTransferException
  {
    int i = FileTransferEvent.a;
    Iterator localIterator = paramCollection.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      FileTransferRemoteFile localFileTransferRemoteFile = (FileTransferRemoteFile)localIterator.next();
      paramFileTransfer.setDir(localFileTransferRemoteFile.getFilename());
      DirectoryService.DirectoryEntries localDirectoryEntries = a(paramFileTransfer);
      s locals = params.d(new DirectoryService.Directory(localFileTransferRemoteFile, localDirectoryEntries.files));
      a(localDirectoryEntries.directories, locals, paramFileTransfer);
      paramFileTransfer.setDirUp();
    } while (i == 0);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.DirectoryService
 * JD-Core Version:    0.7.0.1
 */