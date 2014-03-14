package com.jscape.util.j.b;

import com.jscape.util.g.hb;
import com.jscape.util.j.a.eb;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class b<M>
  extends eb<M>
  implements f
{
  public b(i parami, hb<M> paramhb)
  {
    super(parami, paramhb);
  }
  
  public Socket c()
  {
    return ((i)e()).c();
  }
  
  public SSLSocket a(SSLSocketFactory paramSSLSocketFactory, boolean paramBoolean)
    throws IOException
  {
    return ((i)e()).a(paramSSLSocketFactory, paramBoolean);
  }
  
  public void d()
    throws IOException
  {
    ((i)e()).d();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.b.b
 * JD-Core Version:    0.7.0.1
 */