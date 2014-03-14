package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.q;
import com.jscape.util.g.a.d;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class g
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    return new q(i);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    q localq = (q)paramj;
    d.a(localq.a, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */