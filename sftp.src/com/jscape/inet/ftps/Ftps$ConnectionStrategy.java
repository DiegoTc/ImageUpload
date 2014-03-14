package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.inet.util.ConnectionParameters;
import com.jscape.util.Logger;
import javax.net.ssl.SSLContext;

public abstract interface Ftps$ConnectionStrategy
{
  public abstract void authenticate(FtpsClient paramFtpsClient, String paramString1, String paramString2, String paramString3)
    throws FtpException;
  
  public abstract FtpsClient createClient(Ftps paramFtps, ConnectionParameters paramConnectionParameters, SSLContext paramSSLContext, String[] paramArrayOfString, Logger paramLogger)
    throws FtpException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.ConnectionStrategy
 * JD-Core Version:    0.7.0.1
 */