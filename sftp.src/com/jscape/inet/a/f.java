package com.jscape.inet.a;

import com.jscape.inet.a.a.c.a.hb;
import com.jscape.inet.a.a.c.a.ib;
import com.jscape.util.gc;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class f
  extends OutputStream
  implements Runnable, ib
{
  private final OutputStream a;
  private volatile boolean b;
  private volatile boolean c;
  final h d;
  private static final String z = -1;
  
  private f(h paramh, OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
  }
  
  public void run()
  {
    this.b = false;
    try
    {
      h.a(this.d).a(this);
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
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
    this.a.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void flush()
    throws IOException
  {
    if (e.b == 0)
    {
      if (this.c) {
        return;
      }
      this.a.flush();
      this.a.close();
      b();
      h.e(this.d);
      h.c(this.d);
    }
    this.c = true;
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
    this.d.e();
  }
  
  private void b()
  {
    int i = e.b;
    do
    {
      if (this.b) {
        break;
      }
      h.v().j();
    } while (i == 0);
  }
  
  private void a(Throwable paramThrowable)
  {
    if ((e.b != 0) || (h.d(this.d).isLoggable(Level.WARNING))) {
      h.d(this.d).log(Level.WARNING, z, paramThrowable);
    }
  }
  
  f(h paramh, OutputStream paramOutputStream, i parami)
  {
    this(paramh, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.f
 * JD-Core Version:    0.7.0.1
 */