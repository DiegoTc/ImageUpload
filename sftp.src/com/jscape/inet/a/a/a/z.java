package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.gb;
import com.jscape.util.g.a.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class z
  extends a
{
  private static final String z = -1;
  
  public com.jscape.inet.a.a.b.o a(InputStream paramInputStream)
    throws IOException
  {
    String str = com.jscape.util.g.a.o.a(z, paramInputStream);
    long l = g.a(paramInputStream);
    return new gb(str, l);
  }
  
  public void a(com.jscape.inet.a.a.b.o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    gb localgb = (gb)paramo;
    com.jscape.util.g.a.o.a(localgb.b, z, paramOutputStream);
    g.a(localgb.c, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.z
 * JD-Core Version:    0.7.0.1
 */