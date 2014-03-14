package com.jscape.inet.a.a.c.a;

import com.jscape.util.bc;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class bb
{
  private final int a;
  private final Map<Integer, cb> b;
  private final Lock c;
  private int d;
  private static final String z = -1;
  
  public bb(int paramInt)
  {
    bc.a(paramInt, 0L, z);
    this.a = paramInt;
    this.b = new HashMap();
    this.c = new ReentrantLock();
  }
  
  public boolean b()
  {
    this.c.lock();
    try
    {
      boolean bool = this.b.isEmpty();
      return bool;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public cb a(int paramInt)
  {
    this.c.lock();
    try
    {
      cb localcb = (cb)this.b.get(Integer.valueOf(paramInt));
      return localcb;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public void a(cb paramcb)
  {
    this.c.lock();
    try
    {
      this.b.put(Integer.valueOf(paramcb.b()), paramcb);
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public boolean b(int paramInt)
  {
    this.c.lock();
    try
    {
      if (!u.r) {}
      boolean bool = this.d > paramInt;
      return bool;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public boolean c(int paramInt)
  {
    boolean bool2 = u.r;
    this.c.lock();
    try
    {
      if (!bool2)
      {
        if (paramInt < this.d) {
          break label49;
        }
        if (bool2) {
          break label46;
        }
      }
      label46:
      label49:
      boolean bool1 = paramInt < this.d + this.a;
      return bool1;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public void a(BlockingQueue<cb> paramBlockingQueue)
  {
    boolean bool = u.r;
    this.c.lock();
    try
    {
      do
      {
        cb localcb;
        if (((localcb = a(this.d)) == null) || ((!bool) && (!localcb.d()))) {
          break;
        }
        if (!bool)
        {
          if (paramBlockingQueue.remainingCapacity() <= 0) {
            break;
          }
          this.b.remove(Integer.valueOf(this.d));
          this.d += 1;
        }
        paramBlockingQueue.add(localcb);
      } while (!bool);
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.bb
 * JD-Core Version:    0.7.0.1
 */