package com.jscape.filetransfer;

import com.jscape.util.bc;
import com.jscape.util.fc;
import java.util.Iterator;
import java.util.List;

@fc
public class RemoteDirectory$PathElementsDirectory
  implements RemoteDirectory
{
  private final List<String> pathElements;
  private static final String z = -1;
  
  public RemoteDirectory$PathElementsDirectory(List<String> paramList)
  {
    bc.a(paramList);
    this.pathElements = paramList;
  }
  
  public void applyTo(FileTransfer paramFileTransfer)
    throws FileTransferException
  {
    int i = FileTransferEvent.a;
    Iterator localIterator = this.pathElements.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      paramFileTransfer.setDir(str);
    } while (i == 0);
  }
  
  public String toString()
  {
    return z + this.pathElements + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.RemoteDirectory.PathElementsDirectory
 * JD-Core Version:    0.7.0.1
 */