package com.jscape.util.j.c;

import com.jscape.util.bc;
import com.jscape.util.fc;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.SocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

@fc
public class NullTrustSocketFactory
  extends SocketFactory
{
  private final SSLSocketFactory base;
  private static final String z = -1;
  
  public static SocketFactory getDefault()
  {
    try
    {
      SSLSocketFactory localSSLSocketFactory = createContext().getSocketFactory();
      return new NullTrustSocketFactory(localSSLSocketFactory);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  private static SSLContext createContext()
    throws NoSuchAlgorithmException, KeyManagementException
  {
    SSLContext localSSLContext = SSLContext.getInstance(z);
    localSSLContext.init(new KeyManager[0], new TrustManager[] { new h() }, new SecureRandom());
    return localSSLContext;
  }
  
  public NullTrustSocketFactory()
    throws NoSuchAlgorithmException, KeyManagementException
  {
    this(createContext().getSocketFactory());
  }
  
  public NullTrustSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    bc.a(paramSSLSocketFactory);
    this.base = paramSSLSocketFactory;
  }
  
  public Socket createSocket()
    throws IOException
  {
    return this.base.createSocket();
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    return this.base.createSocket(paramString, paramInt);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return this.base.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return this.base.createSocket(paramInetAddress, paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return this.base.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.NullTrustSocketFactory
 * JD-Core Version:    0.7.0.1
 */