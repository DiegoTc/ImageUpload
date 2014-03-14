package com.jscape.util.j.a;

import com.jscape.util.bc;
import com.jscape.util.g.d;
import com.jscape.util.g.hb;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

public class p<M>
  implements m<M>, z<M>, s
{
  private final r a;
  private hb<M> b;
  private final com.jscape.util.g.m c;
  private final com.jscape.util.g.m d;
  private final d e;
  private volatile boolean f;
  private n<M> g;
  
  public p(r paramr, hb<M> paramhb)
  {
    bc.a(paramr);
    this.a = paramr;
    bc.a(paramhb);
    this.b = paramhb;
    this.c = new com.jscape.util.g.m();
    this.d = new com.jscape.util.g.m();
    this.e = new d(this.d.b());
  }
  
  public long creationTime()
  {
    return this.a.creationTime();
  }
  
  public com.jscape.util.j.n localAddress()
  {
    return this.a.localAddress();
  }
  
  public com.jscape.util.j.n remoteAddress()
  {
    return this.a.remoteAddress();
  }
  
  public Map<Object, Object> attributes()
  {
    return this.a.attributes();
  }
  
  public boolean closed()
  {
    return this.f;
  }
  
  public void close()
  {
    boolean bool = b.a;
    if (!bool)
    {
      if (this.f) {
        return;
      }
      this.f = true;
      this.a.close();
    }
    if ((bool) || (this.g != null)) {
      this.g.b(this);
    }
  }
  
  public void a(n<M> paramn)
    throws b
  {
    bc.a(paramn);
    this.g = paramn;
    this.a.a(this);
  }
  
  public void a(M paramM)
    throws b
  {
    try
    {
      this.b.write(paramM, this.c);
      this.a.write(this.c.b(), 0, this.c.c());
    }
    catch (Exception localException)
    {
      throw b.a(localException);
    }
    finally
    {
      this.c.d();
    }
  }
  
  public void a(r paramr, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = b.a;
    this.d.write(paramArrayOfByte, paramInt1, paramInt2);
    this.e.a(this.d.b(), 0, this.d.c());
    try
    {
      do
      {
        Object localObject;
        if ((localObject = d()) == null) {
          break;
        }
        this.g.a(this, localObject);
        if (bool) {
          break;
        }
      } while (!bool);
    }
    catch (Exception localException)
    {
      this.g.a(this, localException);
    }
  }
  
  public void a(r paramr)
  {
    this.g.a(this);
  }
  
  public void a(r paramr, Throwable paramThrowable)
  {
    this.g.a(this, paramThrowable);
  }
  
  public void b(r paramr)
  {
    if ((b.a) || (!this.f)) {
      this.g.a(this, new c());
    }
  }
  
  public void c(r paramr)
  {
    this.g.c(this);
  }
  
  public r c()
  {
    return this.a;
  }
  
  public hb<M> b()
  {
    return this.b;
  }
  
  public void a(hb<M> paramhb)
  {
    bc.a(paramhb);
    this.b = paramhb;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  private M d()
    throws IOException
  {
    try
    {
      if (!b.a) {
        if (this.e.available() == 0) {
          return null;
        }
      }
      Object localObject = this.b.read(this.e);
      int i = this.d.c() - this.e.available();
      this.d.b(i);
      this.e.a(this.d.b(), 0, this.d.c());
      return localObject;
    }
    catch (EOFException localEOFException) {}
    return null;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.p
 * JD-Core Version:    0.7.0.1
 */