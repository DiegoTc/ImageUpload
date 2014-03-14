package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.inet.util.ConnectionParameters;
import com.jscape.util.Logger;
import javax.net.ssl.SSLContext;

class Ftps$ImplicitSslStrategy
  extends Ftps.DefaultStrategy
{
  private static final String z = -1;
  
  private Ftps$ImplicitSslStrategy()
  {
    super(null);
  }
  
  public void authenticate(FtpsClient paramFtpsClient, String paramString1, String paramString2, String paramString3)
    throws FtpException
  {
    int j = Ftps.kb;
    int i = 1;
    if ((j != 0) || (paramFtpsClient.getFtpsCertificateVerifier() != null))
    {
      if (j != 0) {
        break label42;
      }
      if (!paramFtpsClient.getFtpsCertificateVerifier().authorized()) {
        i = 0;
      }
    }
    if (i != 0)
    {
      label42:
      super.authenticate(paramFtpsClient, paramString1, paramString2, paramString3);
      try
      {
        paramFtpsClient.bufferSize();
        paramFtpsClient.protectionLevel('P');
      }
      catch (FtpException localFtpException)
      {
        if (j == 0) {
          return;
        }
      }
    }
    else
    {
      throw new FtpException(z);
    }
  }
  
  public FtpsClient createClient(Ftps paramFtps, ConnectionParameters paramConnectionParameters, SSLContext paramSSLContext, String[] paramArrayOfString, Logger paramLogger)
    throws FtpException
  {
    return FtpsClient.openProtected(paramFtps, paramConnectionParameters, paramSSLContext, paramArrayOfString, paramLogger);
  }
  
  Ftps$ImplicitSslStrategy(Ftps.1 param1)
  {
    this();
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.ImplicitSslStrategy
 * JD-Core Version:    0.7.0.1
 */