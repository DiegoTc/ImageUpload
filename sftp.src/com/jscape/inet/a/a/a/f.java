package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.u;
import com.jscape.util.g.a.c;
import com.jscape.util.g.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class f
  extends a
{
  private static final String z = -1;
  
  public com.jscape.inet.a.a.b.o a(InputStream paramInputStream)
    throws IOException
  {
    String str = com.jscape.util.g.a.o.a(z, paramInputStream);
    int i = d.a(paramInputStream);
    byte[] arrayOfByte = c.a(paramInputStream);
    return new u(str, i, arrayOfByte);
  }
  
  public void a(com.jscape.inet.a.a.b.o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    u localu = (u)paramo;
    com.jscape.util.g.a.o.a(localu.b, z, paramOutputStream);
    d.a(localu.c, paramOutputStream);
    c.a(localu.d, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */