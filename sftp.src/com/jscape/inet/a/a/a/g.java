package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.kb;
import com.jscape.inet.a.a.b.o;
import com.jscape.util.g.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class g
  extends a
{
  public o a(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = c.a(paramInputStream);
    return new kb(arrayOfByte);
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    kb localkb = (kb)paramo;
    c.a(localkb.b, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */