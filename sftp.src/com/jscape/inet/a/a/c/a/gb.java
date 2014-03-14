package com.jscape.inet.a.a.c.a;

import com.jscape.util.b.d;
import com.jscape.util.bc;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class gb
  implements Iterable<db>
{
  private final int a;
  private final Map<Integer, db> b;
  private final Lock c;
  private final d<db> d;
  private static final String z = -1;
  
  public gb(int paramInt)
  {
    bc.a(paramInt, 0L, z);
    this.a = paramInt;
    this.b = new LinkedHashMap();
    this.c = new ReentrantLock();
    this.d = new d(paramInt);
  }
  
  public void a(db paramdb)
  {
    this.c.lock();
    try
    {
      this.b.put(Integer.valueOf(paramdb.b()), paramdb);
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public db a(int paramInt)
  {
    this.c.lock();
    try
    {
      db localdb = (db)this.b.get(Integer.valueOf(paramInt));
      return localdb;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public db b(int paramInt)
  {
    this.c.lock();
    try
    {
      db localdb = (db)this.b.remove(Integer.valueOf(paramInt));
      return localdb;
    }
    finally
    {
      this.c.unlock();
    }
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
  
  public Iterator<db> iterator()
  {
    boolean bool = u.r;
    this.c.lock();
    try
    {
      this.d.e();
      Iterator localIterator = this.b.values().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        db localdb = (db)localIterator.next();
        this.d.a(localdb);
        if (bool) {
          break label90;
        }
      } while (!bool);
      localIterator = this.d.iterator();
      label90:
      return localIterator;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public boolean c()
  {
    this.c.lock();
    try
    {
      if (!u.r) {}
      boolean bool = this.b.size() < this.a;
      return bool;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public boolean d()
  {
    boolean bool3 = u.r;
    this.c.lock();
    try
    {
      Iterator localIterator = this.b.values().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        db localdb = (db)localIterator.next();
        if (bool3) {
          break label84;
        }
        if ((bool3) || (!localdb.f()))
        {
          boolean bool2 = false;
          return bool2;
        }
      } while (!bool3);
      label84:
      boolean bool1 = true;
      return bool1;
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
 * Qualified Name:     com.jscape.inet.a.a.c.a.gb
 * JD-Core Version:    0.7.0.1
 */