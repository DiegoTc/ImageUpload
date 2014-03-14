package com.jscape.util.g;

import com.jscape.util.gc;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class z
{
  private static final gc a;
  private final BlockingQueue<bb> b;
  private volatile boolean c;
  private bb d;
  private static final String z = -1;
  
  public z(int paramInt)
  {
    this.b = new LinkedBlockingQueue(paramInt);
  }
  
  public z()
  {
    this(2147483647);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = m.d;
    c();
    if (i == 0) {
      if (!d())
      {
        if (i != 0) {
          break label45;
        }
        if (this.c) {
          return -1;
        }
      }
    }
    label45:
    return this.d.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = m.d;
    boolean bool = false;
    do
    {
      for (;;)
      {
        if (this.c) {
          break label74;
        }
        if ((i != 0) || (i != 0)) {
          break label78;
        }
        if (bool) {
          break label74;
        }
        try
        {
          bool = this.b.offer(new bb(paramArrayOfByte, paramInt1, paramInt2, null), a.a, a.b);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    } while (i == 0);
    label74:
    label78:
    if ((i != 0) || ((this.c) && (!bool))) {
      throw new IOException(z);
    }
  }
  
  public void b()
  {
    this.c = true;
  }
  
  private void c()
  {
    int i = m.d;
    if (i == 0) {
      if (this.c)
      {
        if (i != 0) {
          break label36;
        }
        if (this.b.isEmpty()) {
          return;
        }
      }
    }
    label36:
    do
    {
      for (;;)
      {
        if (d()) {
          return;
        }
        if ((i == 0) && (this.c)) {
          return;
        }
        try
        {
          this.d = ((bb)this.b.poll(a.a, a.b));
        }
        catch (InterruptedException localInterruptedException) {}
      }
    } while (i == 0);
  }
  
  private boolean d()
  {
    int i = m.d;
    if ((i != 0) || (this.d != null)) {
      if (i != 0) {}
    }
    return !this.d.b();
  }
  
  private void e()
  {
    int i = m.d;
    do
    {
      if ((this.c) || (this.b.isEmpty())) {
        break;
      }
      a.j();
    } while (i == 0);
  }
  
  static void a(z paramz)
  {
    paramz.e();
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.z
 * JD-Core Version:    0.7.0.1
 */