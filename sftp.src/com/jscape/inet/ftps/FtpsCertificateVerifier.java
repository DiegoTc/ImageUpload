package com.jscape.inet.ftps;

import javax.net.ssl.SSLSession;

public abstract interface FtpsCertificateVerifier
{
  public abstract boolean authorized();
  
  public abstract void verify(SSLSession paramSSLSession);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FtpsCertificateVerifier
 * JD-Core Version:    0.7.0.1
 */