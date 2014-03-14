package com.jscape.inet.a.a.c.a.a;

import com.jscape.util.g.a.b;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class j
  implements hb<com.jscape.inet.a.a.c.a.b.j>
{
  private static final k a;
  private final Map<Integer, k> b = new HashMap();
  private final Map<Class, k> c = new HashMap();
  private static final String z = -1;
  
  public j(k... paramVarArgs)
  {
    a(paramVarArgs);
  }
  
  public j a(k... paramVarArgs)
  {
    for (k localk : paramVarArgs)
    {
      this.b.put(Integer.valueOf(localk.a), localk);
      this.c.put(localk.b, localk);
    }
    return this;
  }
  
  public com.jscape.inet.a.a.c.a.b.j a(InputStream paramInputStream)
    throws IOException
  {
    int i = b.a(paramInputStream) & 0xFF;
    k localk = a(i);
    return (com.jscape.inet.a.a.c.a.b.j)localk.c.read(paramInputStream);
  }
  
  public void a(com.jscape.inet.a.a.c.a.b.j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    Class localClass = paramj.getClass();
    k localk = a(localClass);
    b.a((byte)localk.a, paramOutputStream);
    localk.c.write(paramj, paramOutputStream);
  }
  
  private k a(int paramInt)
    throws IOException
  {
    k localk = (k)this.b.get(Integer.valueOf(paramInt));
    if (k.d == 0) {}
    return localk != null ? localk : a;
  }
  
  private k a(Class paramClass)
    throws IOException
  {
    k localk = (k)this.c.get(paramClass);
    if (k.d == 0) {
      if (localk == null) {
        throw new IOException(z + paramClass);
      }
    }
    return localk;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.j
 * JD-Core Version:    0.7.0.1
 */