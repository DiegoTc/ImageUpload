package com.jscape.util.g;

import com.jscape.util.qb;
import com.jscape.util.u;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class o
  extends OutputStream
{
  protected final RandomAccessFile a;
  private static final String z = -1;
  
  public o(String paramString, long paramLong)
    throws IOException
  {
    this(new File(paramString), paramLong);
  }
  
  public o(File paramFile, long paramLong)
    throws IOException
  {
    u.a(paramFile);
    this.a = new RandomAccessFile(paramFile, z);
    try
    {
      this.a.seek(paramLong);
      this.a.setLength(paramLong);
    }
    catch (IOException localIOException)
    {
      close();
      throw localIOException;
    }
  }
  
  public void close()
  {
    qb.a(this.a);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.o
 * JD-Core Version:    0.7.0.1
 */