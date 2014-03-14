package com.jscape.filetransfer;

public class SftpFileTransferFactory
  implements FileTransferFactory
{
  public FileTransfer transferFor(FileTransferParameters paramFileTransferParameters)
    throws FileTransferFactory.OperationException
  {
    try
    {
      SftpTransfer localSftpTransfer = new SftpTransfer(paramFileTransferParameters.getHostname(), paramFileTransferParameters.getUsername(), paramFileTransferParameters.getPassword());
      paramFileTransferParameters.applyTo(localSftpTransfer);
      return localSftpTransfer;
    }
    catch (Exception localException)
    {
      throw new FileTransferFactory.OperationException(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.SftpFileTransferFactory
 * JD-Core Version:    0.7.0.1
 */