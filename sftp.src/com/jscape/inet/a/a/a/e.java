package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class e
  extends a
{
  private static final String z = -1;
  
  public com.jscape.inet.a.a.b.o a(InputStream paramInputStream)
    throws IOException
  {
    String str1 = com.jscape.util.g.a.o.a(z, paramInputStream);
    String str2 = com.jscape.util.g.a.o.a(z, paramInputStream);
    return new t(str1, str2);
  }
  
  public void a(com.jscape.inet.a.a.b.o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    t localt = (t)paramo;
    com.jscape.util.g.a.o.a(localt.b, z, paramOutputStream);
    com.jscape.util.g.a.o.a(localt.c, z, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */