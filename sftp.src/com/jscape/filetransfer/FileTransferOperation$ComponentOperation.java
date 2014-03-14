package com.jscape.filetransfer;

import com.jscape.util.bc;
import java.util.Arrays;

public class FileTransferOperation$ComponentOperation
  implements FileTransferOperation
{
  private final FileTransferOperation[] a;
  private static final String z = -1;
  
  public FileTransferOperation$ComponentOperation(FileTransferOperation... paramVarArgs)
  {
    bc.a(paramVarArgs);
    this.a = paramVarArgs;
  }
  
  public void applyTo(FileTransfer paramFileTransfer)
    throws FileTransferException
  {
    int k = FileTransferEvent.a;
    FileTransferOperation[] arrayOfFileTransferOperation = this.a;
    int i = arrayOfFileTransferOperation.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      FileTransferOperation localFileTransferOperation = arrayOfFileTransferOperation[j];
      localFileTransferOperation.applyTo(paramFileTransfer);
      j++;
    } while (k == 0);
  }
  
  public String toString()
  {
    return z + Arrays.toString(this.a) + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransferOperation.ComponentOperation
 * JD-Core Version:    0.7.0.1
 */