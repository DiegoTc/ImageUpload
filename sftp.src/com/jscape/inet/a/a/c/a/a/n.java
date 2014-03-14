package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.t;
import com.jscape.util.g.a.d;
import com.jscape.util.g.a.g;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class n
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    long l = g.a(paramInputStream);
    return new t(i, l);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    t localt = (t)paramj;
    d.a(localt.a, paramOutputStream);
    g.a(localt.e, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */