package com.jscape.inet.a;

import com.jscape.inet.a.a.c.a.hb;
import com.jscape.inet.a.a.c.a.ib;
import com.jscape.util.gc;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class g
  extends OutputStream
  implements Runnable, ib
{
  private final OutputStream a;
  private volatile boolean b;
  private volatile Throwable c;
  final k d;
  private static final String z = -1;
  
  private g(k paramk, OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
  }
  
  public void run()
  {
    this.b = false;
    try
    {
      k.a(this.d).a(this);
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
      this.c = localThrowable;
    }
    finally
    {
      this.b = true;
    }
  }
  
  public void a(hb paramhb, long paramLong) {}
  
  public void write(int paramInt)
    throws IOException
  {
    c();
    this.a.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    c();
    this.a.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    c();
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void flush()
    throws IOException
  {
    c();
    this.a.flush();
  }
  
  public void close()
    throws IOException
  {
    b();
    qb.a(this.a);
    d();
    k.b(this.d);
  }
  
  private void b()
  {
    try
    {
      this.a.flush();
    }
    catch (IOException localIOException)
    {
      a(localIOException);
    }
  }
  
  private void c()
    throws IOException
  {
    if ((e.b != 0) || (this.c != null)) {
      throw qb.a(this.c);
    }
  }
  
  private void d()
  {
    int i = e.b;
    do
    {
      if (this.b) {
        break;
      }
      k.t().j();
    } while (i == 0);
  }
  
  private void a(Throwable paramThrowable)
  {
    if ((e.b != 0) || (k.c(this.d).isLoggable(Level.WARNING))) {
      k.c(this.d).log(Level.WARNING, z, paramThrowable);
    }
  }
  
  g(k paramk, OutputStream paramOutputStream, l paraml)
  {
    this(paramk, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.g
 * JD-Core Version:    0.7.0.1
 */