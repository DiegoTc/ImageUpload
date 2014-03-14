package com.jscape.util.j.a;

import com.jscape.util.bc;
import com.jscape.util.g.hb;
import com.jscape.util.u;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class q<M>
  implements m<M>, z<M>, Runnable
{
  private final fb a;
  private hb<M> b;
  private final ExecutorService c;
  private final OutputStream d;
  private final InputStream e;
  private n<M> f;
  
  public q(fb paramfb, hb<M> paramhb, ExecutorService paramExecutorService)
  {
    bc.a(paramfb);
    this.a = paramfb;
    bc.a(paramhb);
    this.b = paramhb;
    bc.a(paramExecutorService);
    this.c = paramExecutorService;
    this.e = new BufferedInputStream(new a(this.a));
    this.d = new BufferedOutputStream(new i(this.a));
    if (bool) {
      u.a = !u.a;
    }
  }
  
  public long creationTime()
  {
    return this.a.creationTime();
  }
  
  public com.jscape.util.j.n localAddress()
  {
    return this.a.localAddress();
  }
  
  public com.jscape.util.j.n remoteAddress()
  {
    return this.a.remoteAddress();
  }
  
  public Map<Object, Object> attributes()
  {
    return this.a.attributes();
  }
  
  public boolean closed()
  {
    return this.a.closed();
  }
  
  public void close()
  {
    this.a.close();
    if ((b.a) || (this.f != null)) {
      this.f.b(this);
    }
  }
  
  public void a(n<M> paramn)
    throws b
  {
    bc.a(paramn);
    this.f = paramn;
    this.c.submit(this);
  }
  
  public void a(M paramM)
    throws b
  {
    try
    {
      this.b.write(paramM, this.d);
      this.d.flush();
    }
    catch (Exception localException)
    {
      throw new e(localException);
    }
  }
  
  public void run()
  {
    boolean bool = b.a;
    try
    {
      do
      {
        if (closed()) {
          break;
        }
        f();
        if (bool) {
          break;
        }
      } while (!bool);
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  public fb e()
  {
    return this.a;
  }
  
  public hb<M> b()
  {
    return this.b;
  }
  
  public void a(hb<M> paramhb)
  {
    bc.a(paramhb);
    this.b = paramhb;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  private void f()
    throws Exception
  {
    try
    {
      Object localObject = this.b.read(this.e);
      this.f.a(this, localObject);
    }
    catch (EOFException localEOFException)
    {
      this.f.a(this);
    }
    catch (InterruptedIOException localInterruptedIOException)
    {
      this.f.c(this);
    }
    catch (d locald)
    {
      this.f.c(this);
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    if ((b.a) || (!closed())) {
      this.f.a(this, paramThrowable);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.q
 * JD-Core Version:    0.7.0.1
 */