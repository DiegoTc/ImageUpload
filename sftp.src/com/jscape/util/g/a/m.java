package com.jscape.util.g.a;

import com.jscape.util.g.hb;
import com.jscape.util.kb;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class m
  implements hb<byte[]>
{
  private final kb a;
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, kb paramkb, OutputStream paramOutputStream)
    throws IOException
  {
    n.a((short)paramInt2, paramkb, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte, kb paramkb, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length, paramkb, paramOutputStream);
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    n.a((short)paramInt2, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length, paramOutputStream);
  }
  
  public static void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    n.b((short)paramInt2, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static void b(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length, paramOutputStream);
  }
  
  public static byte[] a(kb paramkb, InputStream paramInputStream)
    throws IOException
  {
    int i = n.a(paramkb, paramInputStream) & 0xFFFF;
    return qb.a(new byte[i], paramInputStream);
  }
  
  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    int i = n.a(paramInputStream) & 0xFFFF;
    return qb.a(new byte[i], paramInputStream);
  }
  
  public static byte[] b(InputStream paramInputStream)
    throws IOException
  {
    int i = n.b(paramInputStream) & 0xFFFF;
    return qb.a(new byte[i], paramInputStream);
  }
  
  public m(kb paramkb)
  {
    this.a = paramkb;
  }
  
  public void c(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramArrayOfByte, this.a, paramOutputStream);
  }
  
  public byte[] c(InputStream paramInputStream)
    throws IOException
  {
    return a(this.a, paramInputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.m
 * JD-Core Version:    0.7.0.1
 */