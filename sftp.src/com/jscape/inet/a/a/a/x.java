package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.eb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class x
  extends a
{
  private static final String z = -1;
  
  public com.jscape.inet.a.a.b.o a(InputStream paramInputStream)
    throws IOException
  {
    String str = com.jscape.util.g.a.o.a(z, paramInputStream);
    boolean bool = com.jscape.util.g.a.a.a(paramInputStream);
    return new eb(str, bool);
  }
  
  public void a(com.jscape.inet.a.a.b.o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    eb localeb = (eb)paramo;
    com.jscape.util.g.a.o.a(localeb.b, z, paramOutputStream);
    com.jscape.util.g.a.a.a(localeb.c, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */