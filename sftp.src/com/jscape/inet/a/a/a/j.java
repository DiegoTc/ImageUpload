package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.mb;
import com.jscape.inet.a.a.b.o;
import com.jscape.util.g.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class j
  extends a
{
  public o a(InputStream paramInputStream)
    throws IOException
  {
    int i = b.a(paramInputStream) & 0xFF;
    return new mb(com.jscape.inet.a.a.b.a.a(i));
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    mb localmb = (mb)paramo;
    b.a((byte)localmb.b.i, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */