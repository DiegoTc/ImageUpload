package com.jscape.util.j.a;

import java.io.IOException;
import java.io.OutputStream;

public class i
  extends OutputStream
{
  private final fb a;
  
  public i(fb paramfb)
  {
    this.a = paramfb;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.a.write((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void flush()
    throws IOException
  {
    this.a.flush();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.i
 * JD-Core Version:    0.7.0.1
 */