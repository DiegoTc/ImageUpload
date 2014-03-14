package com.jscape.inet.a.a.c;

import com.jscape.inet.a.a.c.a.hb;
import com.jscape.inet.a.a.c.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public abstract interface g
{
  public abstract int b();
  
  public abstract void a(InetSocketAddress paramInetSocketAddress)
    throws IOException;
  
  public abstract void c();
  
  public abstract InetSocketAddress d();
  
  public abstract hb a(InputStream paramInputStream, InetSocketAddress paramInetSocketAddress, j paramj);
  
  public abstract hb a(OutputStream paramOutputStream, InetSocketAddress paramInetSocketAddress);
  
  public abstract hb a(int paramInt, InputStream paramInputStream, InetSocketAddress paramInetSocketAddress, j paramj);
  
  public abstract hb a(int paramInt, OutputStream paramOutputStream, InetSocketAddress paramInetSocketAddress);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.g
 * JD-Core Version:    0.7.0.1
 */