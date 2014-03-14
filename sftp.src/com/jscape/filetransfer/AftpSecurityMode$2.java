package com.jscape.filetransfer;

 enum AftpSecurityMode$2
{
  AftpSecurityMode$2(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void applyTo(FileTransfer paramFileTransfer)
  {
    ((AftpFileTransfer)paramFileTransfer).setSecurityMode(AftpFileTransfer.SecurityMode.FULL_TIME_PROTECTED);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpSecurityMode.2
 * JD-Core Version:    0.7.0.1
 */