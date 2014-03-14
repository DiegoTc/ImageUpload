package com.jscape.util.j.b;

import com.jscape.util.g.hb;
import com.jscape.util.j.a.q;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class a<M>
  extends q<M>
  implements f
{
  public a(i parami, hb<M> paramhb, ExecutorService paramExecutorService)
  {
    super(parami, paramhb, paramExecutorService);
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
 * Qualified Name:     com.jscape.util.j.b.a
 * JD-Core Version:    0.7.0.1
 */