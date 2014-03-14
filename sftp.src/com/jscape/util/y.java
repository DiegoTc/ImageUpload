package com.jscape.util;

public class y
{
  public static final int a = 0;
  private boolean b;
  
  public y(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public y()
  {
    this(false);
  }
  
  public synchronized boolean b()
  {
    return this.b;
  }
  
  public synchronized boolean c()
  {
    if (!bc.a) {}
    return !this.b;
  }
  
  public synchronized void a(boolean paramBoolean)
  {
    if (paramBoolean != this.b)
    {
      this.b = paramBoolean;
      notifyAll();
    }
  }
  
  public synchronized boolean a(long paramLong)
  {
    boolean bool = d(paramLong);
    if (!bc.a) {
      if (bool) {
        a(true);
      }
    }
    return bool;
  }
  
  public synchronized boolean d()
  {
    return a(0L);
  }
  
  public synchronized boolean b(long paramLong)
  {
    boolean bool = c(paramLong);
    if (!bc.a) {
      if (bool) {
        a(false);
      }
    }
    return bool;
  }
  
  public synchronized boolean e()
  {
    return b(0L);
  }
  
  public boolean c(long paramLong)
  {
    return a(true, paramLong);
  }
  
  public boolean f()
  {
    return c(0L);
  }
  
  public boolean d(long paramLong)
  {
    return a(false, paramLong);
  }
  
  public boolean g()
  {
    return d(0L);
  }
  
  public synchronized boolean a(boolean paramBoolean, long paramLong)
  {
    boolean bool = bc.a;
    if (!bool) {
      if (paramLong == 0L)
      {
        do
        {
          for (;;)
          {
            if (this.b == paramBoolean) {
              break label38;
            }
            try
            {
              wait();
            }
            catch (InterruptedException localInterruptedException1) {}
          }
        } while (!bool);
        label38:
        return true;
      }
    }
    long l1 = System.currentTimeMillis() + paramLong;
    long l2 = paramLong;
    do
    {
      if (this.b == paramBoolean) {
        break;
      }
      if ((bool) || (bool)) {
        break label103;
      }
      if (l2 <= 0L) {
        break;
      }
      try
      {
        wait(l2);
      }
      catch (InterruptedException localInterruptedException2) {}
      l2 = l1 - System.currentTimeMillis();
    } while (!bool);
    label103:
    if (!bool) {}
    return this.b == paramBoolean;
  }
  
  public boolean b(boolean paramBoolean)
  {
    return a(paramBoolean, 0L);
  }
  
  public synchronized boolean c(boolean paramBoolean)
  {
    boolean bool = this.b;
    this.b = paramBoolean;
    return bool;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.y
 * JD-Core Version:    0.7.0.1
 */