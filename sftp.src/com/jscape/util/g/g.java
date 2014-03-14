package com.jscape.util.g;

import com.jscape.util.qb;
import com.jscape.util.u;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class g
  extends InputStream
{
  protected final RandomAccessFile a;
  
  public g(String paramString, long paramLong)
    throws IOException
  {
    this(new File(paramString), paramLong);
  }
  
  public g(File paramFile, long paramLong)
    throws IOException
  {
    u.a(paramFile);
    this.a = new RandomAccessFile(paramFile, "r");
    try
    {
      this.a.seek(paramLong);
    }
    catch (IOException localIOException)
    {
      close();
      throw localIOException;
    }
  }
  
  public int available()
    throws IOException
  {
    return (int)(this.a.length() - this.a.getFilePointer());
  }
  
  public void close()
  {
    qb.a(this.a);
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = Math.min(Math.max(0L, paramLong), this.a.length() - this.a.getFilePointer());
    this.a.seek(this.a.getFilePointer() + paramLong);
    return paramLong;
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
 * Qualified Name:     com.jscape.util.g.g
 * JD-Core Version:    0.7.0.1
 */