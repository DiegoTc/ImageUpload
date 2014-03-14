package com.jscape.filetransfer;

public class FtpsImplicitFileTransferFactory
  implements FileTransferFactory
{
  public FileTransfer transferFor(FileTransferParameters paramFileTransferParameters)
    throws FileTransferFactory.OperationException
  {
    try
    {
      FtpsImplicitTransfer localFtpsImplicitTransfer = new FtpsImplicitTransfer(paramFileTransferParameters.getHostname(), paramFileTransferParameters.getUsername(), paramFileTransferParameters.getPassword());
      paramFileTransferParameters.applyTo(localFtpsImplicitTransfer);
      return localFtpsImplicitTransfer;
    }
    catch (Exception localException)
    {
      throw new FileTransferFactory.OperationException(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FtpsImplicitFileTransferFactory
 * JD-Core Version:    0.7.0.1
 */