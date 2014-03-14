package com.jscape.filetransfer;

public class FtpFileTransferFactory
  implements FileTransferFactory
{
  public FileTransfer transferFor(FileTransferParameters paramFileTransferParameters)
    throws FileTransferFactory.OperationException
  {
    try
    {
      FtpTransfer localFtpTransfer = new FtpTransfer(paramFileTransferParameters.getHostname(), paramFileTransferParameters.getUsername(), paramFileTransferParameters.getPassword());
      paramFileTransferParameters.applyTo(localFtpTransfer);
      return localFtpTransfer;
    }
    catch (Exception localException)
    {
      throw new FileTransferFactory.OperationException(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FtpFileTransferFactory
 * JD-Core Version:    0.7.0.1
 */