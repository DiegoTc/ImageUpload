package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.nb;
import com.jscape.inet.a.a.b.o;
import com.jscape.util.g.a.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class k
  extends a
{
  public o a(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = m.a(paramInputStream);
    return new nb(arrayOfByte);
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    nb localnb = (nb)paramo;
    m.a(localnb.b, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */