package com.jscape.filetransfer;

import java.util.HashMap;
import java.util.Map;

public class ComponentFileTransferFactory
  implements FileTransferFactory
{
  private static final ComponentFileTransferFactory.Entry[] a;
  private final Map<Protocol, ComponentFileTransferFactory.Entry> b = new HashMap();
  private static final String z = -1;
  
  public static ComponentFileTransferFactory defaultFactory()
  {
    return new ComponentFileTransferFactory(a);
  }
  
  public ComponentFileTransferFactory(ComponentFileTransferFactory.Entry... paramVarArgs)
  {
    a(paramVarArgs);
  }
  
  public boolean supports(Protocol paramProtocol)
  {
    return this.b.containsKey(paramProtocol);
  }
  
  public FileTransfer transferFor(FileTransferParameters paramFileTransferParameters)
    throws FileTransferFactory.OperationException
  {
    ComponentFileTransferFactory.Entry localEntry = a(paramFileTransferParameters.getProtocol());
    return localEntry.factory.transferFor(paramFileTransferParameters);
  }
  
  private void a(ComponentFileTransferFactory.Entry[] paramArrayOfEntry)
  {
    int k = FileTransferEvent.a;
    ComponentFileTransferFactory.Entry[] arrayOfEntry = paramArrayOfEntry;
    int i = arrayOfEntry.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      ComponentFileTransferFactory.Entry localEntry = arrayOfEntry[j];
      this.b.put(localEntry.protocol, localEntry);
      j++;
    } while (k == 0);
  }
  
  private ComponentFileTransferFactory.Entry a(Protocol paramProtocol)
  {
    ComponentFileTransferFactory.Entry localEntry = (ComponentFileTransferFactory.Entry)this.b.get(paramProtocol);
    if (FileTransferEvent.a == 0) {
      if (localEntry == null) {
        throw new IllegalArgumentException(z + paramProtocol);
      }
    }
    return localEntry;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.ComponentFileTransferFactory
 * JD-Core Version:    0.7.0.1
 */