package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.r;
import com.jscape.util.g.a.d;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class h
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    return new r(i);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    r localr = (r)paramj;
    d.a(localr.a, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.h
 * JD-Core Version:    0.7.0.1
 */