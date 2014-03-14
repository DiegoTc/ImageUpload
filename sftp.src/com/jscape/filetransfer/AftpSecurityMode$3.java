package com.jscape.filetransfer;

 enum AftpSecurityMode$3
{
  AftpSecurityMode$3(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void applyTo(FileTransfer paramFileTransfer)
  {
    ((AftpFileTransfer)paramFileTransfer).setSecurityMode(AftpFileTransfer.SecurityMode.AUTHENTICATION_PROTECTED);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpSecurityMode.3
 * JD-Core Version:    0.7.0.1
 */