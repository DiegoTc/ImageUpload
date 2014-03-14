package com.jscape.util.g.a;

import com.jscape.util.g.hb;
import com.jscape.util.kb;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class n
  implements hb<Short>
{
  private final kb a;
  
  public static void a(short paramShort, kb paramkb, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = paramkb.a(paramShort, new byte[2], 0);
    paramOutputStream.write(arrayOfByte);
  }
  
  public static void a(short paramShort, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramShort >>> 8);
    paramOutputStream.write(paramShort);
  }
  
  public static void b(short paramShort, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramShort);
    paramOutputStream.write(paramShort >>> 8);
  }
  
  public static short a(kb paramkb, InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = qb.a(new byte[2], paramInputStream);
    return paramkb.c(arrayOfByte, 0);
  }
  
  public static short a(InputStream paramInputStream)
    throws IOException
  {
    int i = qb.b(paramInputStream) << 8;
    i |= qb.b(paramInputStream);
    return (short)i;
  }
  
  public static short b(InputStream paramInputStream)
    throws IOException
  {
    int i = qb.b(paramInputStream);
    i |= qb.b(paramInputStream) << 8;
    return (short)i;
  }
  
  public n(kb paramkb)
  {
    this.a = paramkb;
  }
  
  public void a(Short paramShort, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramShort.shortValue(), this.a, paramOutputStream);
  }
  
  public Short c(InputStream paramInputStream)
    throws IOException
  {
    return Short.valueOf(a(this.a, paramInputStream));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.n
 * JD-Core Version:    0.7.0.1
 */