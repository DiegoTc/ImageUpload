package com.jscape.filetransfer;

 enum AftpSecurityMode$1
{
  AftpSecurityMode$1(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void applyTo(FileTransfer paramFileTransfer)
  {
    ((AftpFileTransfer)paramFileTransfer).setSecurityMode(AftpFileTransfer.SecurityMode.NO_PROTECTION);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpSecurityMode.1
 * JD-Core Version:    0.7.0.1
 */