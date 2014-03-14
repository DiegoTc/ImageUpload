package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.n;
import com.jscape.util.g.a.m;
import com.jscape.util.g.hb;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class d
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int n = k.d;
    int i = com.jscape.util.g.a.d.a(paramInputStream);
    int j = com.jscape.util.g.a.d.a(paramInputStream);
    int k = com.jscape.util.g.a.d.a(paramInputStream);
    int m = com.jscape.util.g.a.d.a(paramInputStream);
    byte[] arrayOfByte = m.a(paramInputStream);
    if (u.a) {
      k.d = ++n;
    }
    return new n(i, j, k, m, arrayOfByte);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    int i = k.d;
    n localn = (n)paramj;
    com.jscape.util.g.a.d.a(localn.a, paramOutputStream);
    com.jscape.util.g.a.d.a(localn.e, paramOutputStream);
    com.jscape.util.g.a.d.a(localn.f, paramOutputStream);
    com.jscape.util.g.a.d.a(localn.g, paramOutputStream);
    m.a(localn.h, paramOutputStream);
    if (i != 0) {
      u.a = !u.a;
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */