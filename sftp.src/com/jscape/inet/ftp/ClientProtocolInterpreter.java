package com.jscape.inet.ftp;

public abstract interface ClientProtocolInterpreter
{
  public abstract void sendCommand(String paramString)
    throws FtpException;
  
  public abstract String receiveReply()
    throws FtpException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.ClientProtocolInterpreter
 * JD-Core Version:    0.7.0.1
 */