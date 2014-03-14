package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import java.net.Socket;

abstract interface FtpsClient$DataConnector
{
  public abstract Socket openConnection(String paramString)
    throws FtpException;
  
  public abstract void close();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FtpsClient.DataConnector
 * JD-Core Version:    0.7.0.1
 */