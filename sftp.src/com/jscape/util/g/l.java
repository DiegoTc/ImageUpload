package com.jscape.util.g;

import com.jscape.util.u;
import java.io.IOException;
import java.io.OutputStream;

public class l
  extends OutputStream
{
  private final z a;
  private final byte[] b;
  
  public l(z paramz)
  {
    u.a(paramz);
    this.a = paramz;
    this.b = new byte[1];
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.b[0] = ((byte)paramInt);
    write(this.b);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void flush()
    throws IOException
  {
    z.a(this.a);
  }
  
  public void close()
  {
    this.a.b();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.l
 * JD-Core Version:    0.7.0.1
 */