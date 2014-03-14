package com.jscape.inet.a.a.c.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.util.bc;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class s
  implements p
{
  private final z a;
  private final Map<Integer, q> b;
  private volatile boolean c;
  private r d;
  private static final String z = -1;
  
  public s(z paramz)
  {
    bc.a(paramz);
    this.a = paramz;
    this.b = new ConcurrentHashMap();
  }
  
  public void a(r paramr)
  {
    bc.a(paramr);
    this.d = paramr;
    this.c = false;
    c();
  }
  
  public void b()
  {
    this.c = true;
  }
  
  public void a(int paramInt, q paramq)
  {
    bc.a(paramq);
    this.b.put(Integer.valueOf(paramInt), paramq);
  }
  
  public void a(int paramInt)
  {
    this.b.remove(Integer.valueOf(paramInt));
  }
  
  public void a(j paramj)
    throws IOException
  {
    this.a.a(paramj);
  }
  
  private void c()
  {
    t localt = new t(this);
    Thread localThread = new Thread(localt, String.format(z, new Object[] { this.a.b() }));
    localThread.setDaemon(true);
    localThread.start();
  }
  
  private void d()
  {
    boolean bool = u.r;
    do
    {
      if (this.c) {
        break;
      }
      e();
    } while (!bool);
  }
  
  private void e()
  {
    boolean bool = u.r;
    try
    {
      j localj = this.a.c();
      q localq = (q)this.b.get(Integer.valueOf(localj.a));
      if ((bool) || (localq != null))
      {
        localq.a(localj);
        if (!bool) {}
      }
      else
      {
        this.d.a(localj);
      }
    }
    catch (InterruptedIOException localInterruptedIOException) {}catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    if ((u.r) || (!this.c)) {
      this.d.a(paramThrowable);
    }
  }
  
  static void a(s params)
  {
    params.d();
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.s
 * JD-Core Version:    0.7.0.1
 */