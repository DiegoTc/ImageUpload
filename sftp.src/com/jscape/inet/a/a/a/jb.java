package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.yb;
import com.jscape.util.g.a.g;
import com.jscape.util.g.a.o;
import com.jscape.util.g.hb;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class jb
  implements hb<yb>
{
  public static final String a = -1;
  
  public yb a(InputStream paramInputStream)
    throws IOException
  {
    int i = a.b;
    String str = o.a(a, paramInputStream);
    com.jscape.inet.a.a.b.b localb = com.jscape.inet.a.a.b.b.a(com.jscape.util.g.a.b.a(paramInputStream));
    boolean bool1 = com.jscape.util.g.a.a.a(paramInputStream);
    boolean bool2 = com.jscape.util.g.a.a.a(paramInputStream);
    long l1 = g.a(paramInputStream);
    long l2 = g.a(paramInputStream);
    if (i != 0) {
      u.a = !u.a;
    }
    return new yb(str, localb, bool1, bool2, l1, l2);
  }
  
  public void a(yb paramyb, OutputStream paramOutputStream)
    throws IOException
  {
    o.a(paramyb.a, a, paramOutputStream);
    com.jscape.util.g.a.b.a((byte)paramyb.b.ordinal(), paramOutputStream);
    com.jscape.util.g.a.a.a(paramyb.c, paramOutputStream);
    com.jscape.util.g.a.a.a(paramyb.d, paramOutputStream);
    g.a(paramyb.e, paramOutputStream);
    g.a(paramyb.f, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.jb
 * JD-Core Version:    0.7.0.1
 */