package com.jscape.inet.a;

import com.jscape.inet.a.a.c.a.hb;
import com.jscape.inet.a.a.c.a.ib;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class b
  extends InputStream
  implements Runnable, ib
{
  private final InputStream a;
  final h b;
  private static final String z = -1;
  
  private b(h paramh, InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public void run()
  {
    try
    {
      h.a(this.b).a(this);
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  public void a(hb paramhb, long paramLong) {}
  
  public int read()
    throws IOException
  {
    return this.a.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.a.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.a.skip(paramLong);
  }
  
  public int available()
    throws IOException
  {
    return this.a.available();
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
    h.b(this.b);
    h.c(this.b);
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public void reset()
    throws IOException
  {
    this.a.reset();
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  private void a(Throwable paramThrowable)
  {
    if ((e.b != 0) || (h.d(this.b).isLoggable(Level.WARNING))) {
      h.d(this.b).log(Level.WARNING, z, paramThrowable);
    }
  }
  
  b(h paramh, InputStream paramInputStream, i parami)
  {
    this(paramh, paramInputStream);
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.b
 * JD-Core Version:    0.7.0.1
 */