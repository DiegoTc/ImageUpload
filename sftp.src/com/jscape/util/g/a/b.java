package com.jscape.util.g.a;

import com.jscape.util.g.hb;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class b
  implements hb<Byte>
{
  public static void a(byte paramByte, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramByte);
  }
  
  public static byte a(InputStream paramInputStream)
    throws IOException
  {
    return (byte)qb.b(paramInputStream);
  }
  
  public void a(Byte paramByte, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramByte.byteValue(), paramOutputStream);
  }
  
  public Byte b(InputStream paramInputStream)
    throws IOException
  {
    return Byte.valueOf(a(paramInputStream));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.b
 * JD-Core Version:    0.7.0.1
 */