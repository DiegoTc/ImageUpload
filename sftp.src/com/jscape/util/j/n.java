package com.jscape.util.j;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class n
{
  private InetAddress a;
  private String b;
  private int c;
  public static boolean d;
  private static final String z = -1;
  
  public static n a(URL paramURL)
  {
    return new n(paramURL.getHost(), paramURL.getPort());
  }
  
  private n(InetAddress paramInetAddress, String paramString, int paramInt)
  {
    this.a = paramInetAddress;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public n(String paramString, int paramInt)
  {
    this(null, paramString, paramInt);
  }
  
  public n(InetAddress paramInetAddress, int paramInt)
  {
    this(paramInetAddress, paramInetAddress != null ? paramInetAddress.getHostAddress() : null, paramInt);
  }
  
  public n(InetSocketAddress paramInetSocketAddress)
  {
    this(paramInetSocketAddress.getAddress(), paramInetSocketAddress.getHostName(), paramInetSocketAddress.getPort());
  }
  
  public n(n paramn)
  {
    this(paramn.a, paramn.b, paramn.c);
  }
  
  public n() {}
  
  public String b()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public InetAddress d()
    throws UnknownHostException
  {
    if (!d) {}
    return this.a != null ? this.a : InetAddress.getByName(this.b);
  }
  
  public InetSocketAddress e()
  {
    return this.a != null ? new InetSocketAddress(this.a, this.c) : new InetSocketAddress(this.b, this.c);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = d;
    if (!bool) {
      if (this == paramObject) {
        return true;
      }
    }
    if (paramObject != null)
    {
      if (bool) {
        break label37;
      }
      if (getClass() == paramObject.getClass()) {}
    }
    else
    {
      return false;
    }
    label37:
    n localn = (n)paramObject;
    if (!bool) {
      if (this.c != localn.c) {
        return false;
      }
    }
    if (!bool) {
      if (!this.b.equals(localn.b)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.b.hashCode();
    i = 31 * i + this.c;
    return i;
  }
  
  public String toString()
  {
    return String.format(z, new Object[] { this.b, Integer.valueOf(this.c) });
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.n
 * JD-Core Version:    0.7.0.1
 */