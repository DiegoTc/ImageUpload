package com.jscape.filetransfer;

public class FtpsFileTransferFactory
  implements FileTransferFactory
{
  public FileTransfer transferFor(FileTransferParameters paramFileTransferParameters)
    throws FileTransferFactory.OperationException
  {
    try
    {
      FtpsTransfer localFtpsTransfer = new FtpsTransfer(paramFileTransferParameters.getHostname(), paramFileTransferParameters.getUsername(), paramFileTransferParameters.getPassword());
      paramFileTransferParameters.applyTo(localFtpsTransfer);
      return localFtpsTransfer;
    }
    catch (Exception localException)
    {
      throw new FileTransferFactory.OperationException(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FtpsFileTransferFactory
 * JD-Core Version:    0.7.0.1
 */