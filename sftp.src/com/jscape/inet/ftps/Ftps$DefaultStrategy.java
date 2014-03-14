package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.inet.util.ConnectionParameters;
import com.jscape.util.Logger;
import javax.net.ssl.SSLContext;

class Ftps$DefaultStrategy
  implements Ftps.ConnectionStrategy
{
  private Ftps$DefaultStrategy() {}
  
  public void authenticate(FtpsClient paramFtpsClient, String paramString1, String paramString2, String paramString3)
    throws FtpException
  {
    int i = paramFtpsClient.userName(paramString1).getCode();
    if (i > 300) {
      paramFtpsClient.password(paramString2);
    }
    if (paramString3 != null) {
      paramFtpsClient.account(paramString3);
    }
  }
  
  public FtpsClient createClient(Ftps paramFtps, ConnectionParameters paramConnectionParameters, SSLContext paramSSLContext, String[] paramArrayOfString, Logger paramLogger)
    throws FtpException
  {
    return FtpsClient.openPlain(paramFtps, paramConnectionParameters, paramSSLContext, paramArrayOfString, paramLogger);
  }
  
  Ftps$DefaultStrategy(Ftps.1 param1)
  {
    this();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.DefaultStrategy
 * JD-Core Version:    0.7.0.1
 */