package com.jscape.filetransfer;

public class AftpFileTransferFactory
  implements FileTransferFactory
{
  public FileTransfer transferFor(FileTransferParameters paramFileTransferParameters)
    throws FileTransferFactory.OperationException
  {
    try
    {
      AftpFileTransfer localAftpFileTransfer = new AftpFileTransfer(paramFileTransferParameters.getHostname(), paramFileTransferParameters.getPort() != null ? paramFileTransferParameters.getPort().intValue() : 3000, paramFileTransferParameters.getUsername(), paramFileTransferParameters.getPassword());
      paramFileTransferParameters.applyTo(localAftpFileTransfer);
      return localAftpFileTransfer;
    }
    catch (Exception localException)
    {
      throw new FileTransferFactory.OperationException(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpFileTransferFactory
 * JD-Core Version:    0.7.0.1
 */