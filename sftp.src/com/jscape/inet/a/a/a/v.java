package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.db;
import com.jscape.util.g.a.g;
import com.jscape.util.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class v
  extends a
{
  private static final String z = -1;
  
  public com.jscape.inet.a.a.b.o a(InputStream paramInputStream)
    throws IOException
  {
    String str = com.jscape.util.g.a.o.a(z, paramInputStream);
    long l = g.a(paramInputStream);
    x localx = x.a(g.a(paramInputStream));
    boolean bool1 = com.jscape.util.g.a.a.a(paramInputStream);
    boolean bool2 = com.jscape.util.g.a.a.a(paramInputStream);
    return new db(str, l, localx, bool1, bool2);
  }
  
  public void a(com.jscape.inet.a.a.b.o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    db localdb = (db)paramo;
    com.jscape.util.g.a.o.a(localdb.b, z, paramOutputStream);
    g.a(localdb.c, paramOutputStream);
    g.a(localdb.d.b(), paramOutputStream);
    com.jscape.util.g.a.a.a(localdb.e, paramOutputStream);
    com.jscape.util.g.a.a.a(localdb.f, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.v
 * JD-Core Version:    0.7.0.1
 */