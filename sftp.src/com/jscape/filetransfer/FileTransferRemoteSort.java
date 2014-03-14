package com.jscape.filetransfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class FileTransferRemoteSort
{
  private Enumeration a;
  private boolean b = true;
  private FileTransferRemoteSort.FileTransferRemoteComparator c;
  
  public FileTransferRemoteSort(Enumeration paramEnumeration, FileTransferRemoteSort.FileTransferRemoteComparator paramFileTransferRemoteComparator)
  {
    this.a = paramEnumeration;
    this.c = paramFileTransferRemoteComparator;
  }
  
  public FileTransferRemoteSort.FileTransferRemoteComparator getComparator()
  {
    return this.c;
  }
  
  public void setComparator(FileTransferRemoteSort.FileTransferRemoteComparator paramFileTransferRemoteComparator)
  {
    this.c = paramFileTransferRemoteComparator;
  }
  
  public void setAscendent(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c.setAscendent(paramBoolean);
  }
  
  public boolean isAscendent()
  {
    return this.b;
  }
  
  public void setData(Enumeration paramEnumeration)
  {
    this.a = paramEnumeration;
  }
  
  public Enumeration getData()
  {
    return this.a;
  }
  
  public Enumeration sort()
  {
    int i = FileTransferEvent.a;
    Object localObject = a(this.a);
    List localList1 = a((List)localObject, true, false);
    List localList2 = a((List)localObject, false, true);
    List localList3 = a((List)localObject, false, false);
    Collections.sort(localList1, this.c);
    Collections.sort(localList2, this.c);
    Collections.sort(localList3, this.c);
    localObject = new ArrayList();
    if (i == 0)
    {
      if (this.b)
      {
        ((List)localObject).addAll(localList1);
        ((List)localObject).addAll(localList2);
        ((List)localObject).addAll(localList3);
        if (i == 0) {}
      }
      else
      {
        ((List)localObject).addAll(localList3);
        ((List)localObject).addAll(localList2);
      }
    }
    else {
      ((List)localObject).addAll(localList1);
    }
    this.a = Collections.enumeration((Collection)localObject);
    return this.a;
  }
  
  private List a(Enumeration paramEnumeration)
  {
    int i = FileTransferEvent.a;
    ArrayList localArrayList = new ArrayList();
    do
    {
      if (!paramEnumeration.hasMoreElements()) {
        break;
      }
      if (i != 0) {
        break label43;
      }
      localArrayList.add(paramEnumeration.nextElement());
    } while (i == 0);
    label43:
    return localArrayList;
  }
  
  private List a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = FileTransferEvent.a;
    Iterator localIterator = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    label86:
    label123:
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      FileTransferRemoteFile localFileTransferRemoteFile = (FileTransferRemoteFile)localIterator.next();
      if (i == 0) {
        if (localFileTransferRemoteFile.isDirectory())
        {
          if (i != 0) {
            break label86;
          }
          if (paramBoolean1)
          {
            localArrayList.add(localFileTransferRemoteFile);
            if (i == 0) {
              continue;
            }
          }
        }
      }
      if (i == 0) {
        if (localFileTransferRemoteFile.isLink())
        {
          if (i != 0) {
            break label123;
          }
          if (paramBoolean2)
          {
            localArrayList.add(localFileTransferRemoteFile);
            if (i == 0) {
              continue;
            }
          }
        }
      }
      if (((i != 0) || (!localFileTransferRemoteFile.isDirectory())) && ((i != 0) || (!localFileTransferRemoteFile.isLink())) && ((i != 0) || (!paramBoolean1)) && ((i != 0) || (!paramBoolean2))) {
        localArrayList.add(localFileTransferRemoteFile);
      }
    } while (i == 0);
    return localArrayList;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferRemoteSort
 * JD-Core Version:    0.7.0.1
 */