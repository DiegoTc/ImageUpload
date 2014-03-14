package com.jscape.util.j.c;

import com.jscape.util.bc;
import com.jscape.util.fc;
import com.jscape.util.g.jb;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;

@fc
public class KeystoreSSLContextFactory
  implements SSLContextFactory
{
  private final String protocol;
  private final jb<KeyStore> file;
  private final String keyPassword;
  private final jb<q> parametersFile;
  private final boolean trustAllMode;
  
  public KeystoreSSLContextFactory(String paramString1, jb<KeyStore> paramjb, String paramString2, jb<q> paramjb1, boolean paramBoolean)
  {
    bc.a(paramString1);
    this.protocol = paramString1;
    bc.a(paramjb);
    this.file = paramjb;
    bc.a(paramString2);
    this.keyPassword = paramString2;
    bc.a(paramjb1);
    this.parametersFile = paramjb1;
    this.trustAllMode = paramBoolean;
  }
  
  public SSLContext create()
    throws f
  {
    try
    {
      KeyStore localKeyStore = (KeyStore)this.file.read();
      q localq = (q)this.parametersFile.read();
      return i.a(this.protocol, localKeyStore, this.keyPassword, localq, this.trustAllMode);
    }
    catch (Exception localException)
    {
      throw new f(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.KeystoreSSLContextFactory
 * JD-Core Version:    0.7.0.1
 */