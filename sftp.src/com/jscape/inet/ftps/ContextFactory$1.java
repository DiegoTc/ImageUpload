package com.jscape.inet.ftps;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class ContextFactory$1
  implements X509TrustManager
{
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
  
  public boolean isClientTrusted(X509Certificate[] paramArrayOfX509Certificate)
  {
    return true;
  }
  
  public boolean isServerTrusted(X509Certificate[] paramArrayOfX509Certificate)
  {
    return true;
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.ContextFactory.1
 * JD-Core Version:    0.7.0.1
 */