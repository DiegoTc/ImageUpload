package com.jscape.util.j.a;

import java.io.IOException;
import java.io.InputStream;

public class a
  extends InputStream
{
  private final fb a;
  
  public a(fb paramfb)
  {
    this.a = paramfb;
  }
  
  public int read()
    throws IOException
  {
    return this.a.read();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.a
 * JD-Core Version:    0.7.0.1
 */