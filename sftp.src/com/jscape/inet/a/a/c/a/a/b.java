package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.l;
import com.jscape.util.g.a.d;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class b
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    int j = d.a(paramInputStream);
    int k = d.a(paramInputStream);
    int m = d.a(paramInputStream);
    return new l(i, j, k, m);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    l locall = (l)paramj;
    d.a(locall.a, paramOutputStream);
    d.a(locall.e, paramOutputStream);
    d.a(locall.f, paramOutputStream);
    d.a(locall.g, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */