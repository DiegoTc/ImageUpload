package com.jscape.util.j.a;

import com.jscape.util.bc;
import com.jscape.util.j.n;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class u
  implements r, Runnable
{
  private static final int a = -1;
  private final fb b;
  private final ExecutorService c;
  private final byte[] d;
  private s e;
  
  public u(fb paramfb, ExecutorService paramExecutorService, int paramInt)
  {
    bc.a(paramfb);
    this.b = paramfb;
    bc.a(paramExecutorService);
    this.c = paramExecutorService;
    this.d = new byte[paramInt];
  }
  
  public long creationTime()
  {
    return this.b.creationTime();
  }
  
  public n localAddress()
  {
    return this.b.localAddress();
  }
  
  public n remoteAddress()
  {
    return this.b.remoteAddress();
  }
  
  public Map<Object, Object> attributes()
  {
    return this.b.attributes();
  }
  
  public boolean closed()
  {
    return this.b.closed();
  }
  
  public void close()
  {
    this.b.close();
    if ((b.a) || (this.e != null)) {
      this.e.b(this);
    }
  }
  
  public void a(s params)
    throws b
  {
    bc.a(params);
    this.e = params;
    this.c.submit(this);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws b
  {
    try
    {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    catch (Exception localException)
    {
      throw new e(localException);
    }
  }
  
  public void write(byte paramByte)
    throws b
  {
    try
    {
      this.b.write(paramByte);
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
      this.b.flush();
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
        c();
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
  
  public fb b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return this.b.toString();
  }
  
  protected void c()
    throws IOException
  {
    boolean bool = b.a;
    try
    {
      int i = this.b.read(this.d, 0, this.d.length);
      if (!bool)
      {
        if (i == -1) {
          this.e.a(this);
        }
      }
      else if (!bool) {
        return;
      }
      this.e.a(this, this.d, 0, i);
    }
    catch (d locald)
    {
      this.e.c(this);
    }
  }
  
  protected void a(Throwable paramThrowable)
  {
    if ((b.a) || (!closed())) {
      this.e.a(this, paramThrowable);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.u
 * JD-Core Version:    0.7.0.1
 */