package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.o;
import com.jscape.inet.a.a.b.q;
import com.jscape.util.g.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class b
  extends a
{
  public o a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    return new q(i);
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    q localq = (q)paramo;
    d.a(localq.b, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */