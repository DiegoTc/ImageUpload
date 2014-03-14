package com.jscape.util.g;

import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;

public class c
  extends InputStream
{
  private final z a;
  private final byte[] b;
  
  public c(z paramz)
  {
    u.a(paramz);
    this.a = paramz;
    this.b = new byte[1];
  }
  
  public int read()
    throws IOException
  {
    int i = read(this.b);
    return (m.d != 0) || (i != -1) ? this.b[0] & 0xFF : -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void close()
  {
    this.a.b();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.c
 * JD-Core Version:    0.7.0.1
 */