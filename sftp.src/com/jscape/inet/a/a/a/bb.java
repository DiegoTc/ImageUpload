package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.c;
import com.jscape.inet.a.a.b.o;
import com.jscape.inet.a.a.b.rb;
import com.jscape.util.g.a.b;
import com.jscape.util.g.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bb
  extends a
{
  public o a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    int j = b.a(paramInputStream) & 0xFF;
    return new rb(i, c.a(j));
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    rb localrb = (rb)paramo;
    d.a(localrb.b, paramOutputStream);
    b.a((byte)localrb.c.f, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */