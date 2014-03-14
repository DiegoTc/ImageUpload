package com.jscape.util.j.b;

import com.jscape.util.j.a.v;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public abstract interface f
  extends v
{
  public abstract Socket c();
  
  public abstract SSLSocket a(SSLSocketFactory paramSSLSocketFactory, boolean paramBoolean)
    throws IOException;
  
  public abstract void d()
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.b.f
 * JD-Core Version:    0.7.0.1
 */