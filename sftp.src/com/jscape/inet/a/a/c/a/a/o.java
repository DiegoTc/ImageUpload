package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.u;
import com.jscape.util.g.a.d;
import com.jscape.util.g.hb;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class o
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    byte[] arrayOfByte = qb.a(new byte[paramInputStream.available()], paramInputStream);
    return new u(i, arrayOfByte);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    u localu = (u)paramj;
    d.a(localu.a, paramOutputStream);
    paramOutputStream.write(localu.e);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.o
 * JD-Core Version:    0.7.0.1
 */