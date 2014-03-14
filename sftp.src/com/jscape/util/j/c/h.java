package com.jscape.util.j.c;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class h
  implements X509TrustManager
{
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.h
 * JD-Core Version:    0.7.0.1
 */