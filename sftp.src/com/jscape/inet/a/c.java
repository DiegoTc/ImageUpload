package com.jscape.inet.a;

import com.jscape.inet.a.a.c.a.hb;
import com.jscape.inet.a.a.c.a.ib;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class c
  extends InputStream
  implements Runnable, ib
{
  private final InputStream a;
  private volatile Throwable b;
  final k c;
  private static final String z = -1;
  
  private c(k paramk, InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public void run()
  {
    try
    {
      k.a(this.c).a(this);
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
      this.b = localThrowable;
    }
  }
  
  public void a(hb paramhb, long paramLong) {}
  
  public int read()
    throws IOException
  {
    b();
    return this.a.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    b();
    return this.a.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    b();
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    b();
    return this.a.skip(paramLong);
  }
  
  public int available()
    throws IOException
  {
    b();
    return this.a.available();
  }
  
  public void close()
    throws IOException
  {
    qb.a(this.a);
    k.b(this.c);
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public void reset()
    throws IOException
  {
    b();
    this.a.reset();
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  private void b()
    throws IOException
  {
    if ((e.b != 0) || (this.b != null)) {
      throw qb.a(this.b);
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    if ((e.b != 0) || (k.c(this.c).isLoggable(Level.WARNING))) {
      k.c(this.c).log(Level.WARNING, z, paramThrowable);
    }
  }
  
  c(k paramk, InputStream paramInputStream, l paraml)
  {
    this(paramk, paramInputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.c
 * JD-Core Version:    0.7.0.1
 */