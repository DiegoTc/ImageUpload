package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.k;
import com.jscape.util.g.a.d;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    int j = d.a(paramInputStream);
    int k = d.a(paramInputStream);
    return new k(i, j, k);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    k localk = (k)paramj;
    d.a(localk.a, paramOutputStream);
    d.a(localk.e, paramOutputStream);
    d.a(localk.f, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */