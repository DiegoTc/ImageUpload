package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.o;
import com.jscape.inet.a.a.b.ub;
import com.jscape.util.g.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class fb
  extends a
{
  public o a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    return new ub(i);
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    ub localub = (ub)paramo;
    d.a(localub.b, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.fb
 * JD-Core Version:    0.7.0.1
 */