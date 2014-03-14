package com.jscape.util.g.a;

import com.jscape.util.g.hb;
import com.jscape.util.kb;
import com.jscape.util.qb;
import com.jscape.util.v;
import com.jscape.util.vb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class g
  implements hb<Long>
{
  private final kb a;
  
  public static void a(long paramLong, kb paramkb, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = paramkb.a(paramLong, new byte[8], 0);
    paramOutputStream.write(arrayOfByte);
  }
  
  public static void a(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramLong, v.a, paramOutputStream);
  }
  
  public static void b(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramLong, vb.a, paramOutputStream);
  }
  
  public static long a(kb paramkb, InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = qb.a(new byte[8], paramInputStream);
    return paramkb.e(arrayOfByte, 0);
  }
  
  public static long a(InputStream paramInputStream)
    throws IOException
  {
    return a(v.a, paramInputStream);
  }
  
  public static long b(InputStream paramInputStream)
    throws IOException
  {
    return a(vb.a, paramInputStream);
  }
  
  public g(kb paramkb)
  {
    this.a = paramkb;
  }
  
  public void a(Long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramLong.longValue(), this.a, paramOutputStream);
  }
  
  public Long c(InputStream paramInputStream)
    throws IOException
  {
    return Long.valueOf(a(this.a, paramInputStream));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.g
 * JD-Core Version:    0.7.0.1
 */