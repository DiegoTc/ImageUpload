package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.y;
import com.jscape.util.g.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class o
  extends a
{
  public com.jscape.inet.a.a.b.o a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    return new y(i);
  }
  
  public void a(com.jscape.inet.a.a.b.o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    y localy = (y)paramo;
    d.a(localy.b, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */