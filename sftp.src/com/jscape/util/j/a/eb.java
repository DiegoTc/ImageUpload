package com.jscape.util.j.a;

import com.jscape.util.bc;
import com.jscape.util.g.hb;
import com.jscape.util.j.n;
import com.jscape.util.u;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.Map;

public class eb<M>
  implements db<M>
{
  private final fb a;
  private hb<M> b;
  private final OutputStream c;
  private final InputStream d;
  
  public eb(fb paramfb, hb<M> paramhb)
  {
    bc.a(paramfb);
    this.a = paramfb;
    bc.a(paramhb);
    this.b = paramhb;
    this.d = new BufferedInputStream(new a(this.a));
    this.c = new BufferedOutputStream(new i(this.a));
    if (u.a) {
      b.a = !bool;
    }
  }
  
  public long creationTime()
  {
    return this.a.creationTime();
  }
  
  public n localAddress()
  {
    return this.a.localAddress();
  }
  
  public n remoteAddress()
  {
    return this.a.remoteAddress();
  }
  
  public Map<Object, Object> attributes()
  {
    return this.a.attributes();
  }
  
  public boolean closed()
  {
    return this.a.closed();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public M b()
    throws b
  {
    try
    {
      return this.b.read(this.d);
    }
    catch (InterruptedIOException localInterruptedIOException)
    {
      throw new d(localInterruptedIOException);
    }
    catch (Exception localException)
    {
      throw b.a(localException);
    }
  }
  
  public void a(M paramM)
    throws b
  {
    try
    {
      this.b.write(paramM, this.c);
      this.c.flush();
    }
    catch (Exception localException)
    {
      throw new e(localException);
    }
  }
  
  public fb e()
  {
    return this.a;
  }
  
  public hb<M> f()
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
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.eb
 * JD-Core Version:    0.7.0.1
 */