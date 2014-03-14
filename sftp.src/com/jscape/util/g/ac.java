package com.jscape.util.g;

import com.jscape.util.t;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ac
  implements mb
{
  private final boolean a;
  private byte[] b;
  private static final String z = -1;
  
  public ac(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    u.a(paramArrayOfByte);
    this.b = paramArrayOfByte;
    this.a = paramBoolean;
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, true);
  }
  
  public ac(boolean paramBoolean)
  {
    this(new byte[0], paramBoolean);
  }
  
  public ac()
  {
    this(true);
  }
  
  public boolean writeAllowed()
  {
    return true;
  }
  
  public boolean readAllowed()
  {
    int i = m.d;
    if (i == 0) {
      if (this.b.length <= 0) {
        if (i != 0) {
          break label28;
        }
      }
    }
    label28:
    return this.a;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return new ByteArrayInputStream(this.b);
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return new b(this);
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return z + t.a(this.b) + '}';
  }
  
  static byte[] a(ac paramac, byte[] paramArrayOfByte)
  {
    return paramac.b = paramArrayOfByte;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.ac
 * JD-Core Version:    0.7.0.1
 */