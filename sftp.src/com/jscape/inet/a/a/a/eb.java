package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.jb;
import com.jscape.util.g.a.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class eb
  extends a
{
  private static final String z = -1;
  
  public com.jscape.inet.a.a.b.o a(InputStream paramInputStream)
    throws IOException
  {
    String str = com.jscape.util.g.a.o.a(z, paramInputStream);
    long l = g.a(paramInputStream);
    boolean bool = com.jscape.util.g.a.a.a(paramInputStream);
    return new jb(str, l, bool);
  }
  
  public void a(com.jscape.inet.a.a.b.o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    jb localjb = (jb)paramo;
    com.jscape.util.g.a.o.a(localjb.b, z, paramOutputStream);
    g.a(localjb.c, paramOutputStream);
    com.jscape.util.g.a.a.a(localjb.d, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.eb
 * JD-Core Version:    0.7.0.1
 */