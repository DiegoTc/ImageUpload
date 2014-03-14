package com.jscape.util.g.a;

import com.jscape.util.g.hb;
import com.jscape.util.kb;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class d
  implements hb<Integer>
{
  private final kb a;
  public static int b;
  
  public static void a(int paramInt, kb paramkb, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = paramkb.a(paramInt, new byte[4], 0);
    paramOutputStream.write(arrayOfByte);
  }
  
  public static void a(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramInt >>> 24);
    paramOutputStream.write(paramInt >>> 16);
    paramOutputStream.write(paramInt >>> 8);
    paramOutputStream.write(paramInt);
  }
  
  public static void b(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramInt);
    paramOutputStream.write(paramInt >>> 8);
    paramOutputStream.write(paramInt >>> 16);
    paramOutputStream.write(paramInt >>> 24);
  }
  
  public static int a(kb paramkb, InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = qb.a(new byte[4], paramInputStream);
    return paramkb.d(arrayOfByte, 0);
  }
  
  public static int a(InputStream paramInputStream)
    throws IOException
  {
    int i = qb.b(paramInputStream) << 24;
    i |= qb.b(paramInputStream) << 16;
    i |= qb.b(paramInputStream) << 8;
    i |= qb.b(paramInputStream);
    return i;
  }
  
  public static int b(InputStream paramInputStream)
    throws IOException
  {
    int i = qb.b(paramInputStream);
    i |= qb.b(paramInputStream) << 8;
    i |= qb.b(paramInputStream) << 16;
    i |= qb.b(paramInputStream) << 24;
    return i;
  }
  
  public d(kb paramkb)
  {
    this.a = paramkb;
  }
  
  public void a(Integer paramInteger, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramInteger.intValue(), this.a, paramOutputStream);
  }
  
  public Integer c(InputStream paramInputStream)
    throws IOException
  {
    return Integer.valueOf(a(this.a, paramInputStream));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.d
 * JD-Core Version:    0.7.0.1
 */