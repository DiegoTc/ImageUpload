package com.jscape.util.j.b;

import com.jscape.util.bc;
import com.jscape.util.j.a.b;
import com.jscape.util.j.a.d;
import com.jscape.util.j.a.e;
import com.jscape.util.j.n;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class i
  implements com.jscape.util.j.a.fb, f
{
  private final Socket a;
  private SSLSocket b;
  private boolean c;
  private OutputStream d;
  private InputStream e;
  private final long f;
  private final n g;
  private final n h;
  private final Map<Object, Object> i;
  public static int j;
  private static final String z = -1;
  
  public i(Socket paramSocket)
    throws IOException
  {
    bc.a(paramSocket);
    this.a = paramSocket;
    this.f = com.jscape.util.fb.c();
    this.g = new n(paramSocket.getLocalAddress(), paramSocket.getLocalPort());
    this.h = new n(paramSocket.getInetAddress(), paramSocket.getPort());
    this.i = new ConcurrentHashMap();
    a(this.a);
  }
  
  public long creationTime()
  {
    return this.f;
  }
  
  public n localAddress()
  {
    return this.g;
  }
  
  public n remoteAddress()
  {
    return this.h;
  }
  
  public Map<Object, Object> attributes()
  {
    return this.i;
  }
  
  public boolean closed()
  {
    return this.a.isClosed();
  }
  
  public void close()
  {
    b();
    qb.a(this.a);
  }
  
  public int read()
    throws b
  {
    try
    {
      return this.e.read();
    }
    catch (InterruptedIOException localInterruptedIOException)
    {
      throw new d(localInterruptedIOException);
    }
    catch (Exception localException)
    {
      throw new b(localException);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws b
  {
    try
    {
      return this.e.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    catch (InterruptedIOException localInterruptedIOException)
    {
      throw new d(localInterruptedIOException);
    }
    catch (Exception localException)
    {
      throw new b(localException);
    }
  }
  
  public void write(byte paramByte)
    throws b
  {
    try
    {
      this.d.write(paramByte);
    }
    catch (Exception localException)
    {
      throw new e(localException);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws b
  {
    try
    {
      this.d.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    catch (Exception localException)
    {
      throw new e(localException);
    }
  }
  
  public void flush()
    throws b
  {
    try
    {
      this.d.flush();
    }
    catch (Exception localException)
    {
      throw new e(localException);
    }
  }
  
  public Socket c()
  {
    return this.a;
  }
  
  public SSLSocket a(SSLSocketFactory paramSSLSocketFactory, boolean paramBoolean)
    throws IOException
  {
    this.b = ((SSLSocket)paramSSLSocketFactory.createSocket(this.a, this.h.b(), this.h.c(), false));
    this.c = paramBoolean;
    a(this.b);
    return this.b;
  }
  
  public void d()
    throws IOException
  {
    b();
    a(this.a);
  }
  
  public String toString()
  {
    return String.format(z, new Object[] { this.g, this.h });
  }
  
  private void a(Socket paramSocket)
    throws IOException
  {
    this.d = paramSocket.getOutputStream();
    this.e = paramSocket.getInputStream();
  }
  
  private void b()
  {
    int k = j;
    if ((k != 0) || (this.b != null)) {
      if (k == 0)
      {
        if (this.c) {
          qb.a(this.b);
        }
      }
      else {
        this.b = null;
      }
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.b.i
 * JD-Core Version:    0.7.0.1
 */