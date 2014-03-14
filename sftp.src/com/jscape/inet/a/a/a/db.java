package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.o;
import com.jscape.inet.a.a.b.tb;
import com.jscape.util.g.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class db
  extends a
{
  private static final int c = 10;
  
  public o a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    if (a.b == 0) {}
    int j = paramInputStream.available() > 0 ? d.a(paramInputStream) : 10;
    return new tb(i, j);
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    tb localtb = (tb)paramo;
    d.a(localtb.b, paramOutputStream);
    d.a(localtb.c, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.db
 * JD-Core Version:    0.7.0.1
 */