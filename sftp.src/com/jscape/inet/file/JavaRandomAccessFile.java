package com.jscape.inet.file;

import com.jscape.util.u;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class JavaRandomAccessFile
  implements JRandomAccessFile
{
  private RandomAccessFile a;
  private JFile b;
  
  public JavaRandomAccessFile(JFile paramJFile, JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask)
    throws FileNotFoundException
  {
    u.a(paramJFile);
    u.a(paramJFileOpenFlags);
    String str = "r";
    if (!JAcl.Mask.r)
    {
      if (paramMask.writeData()) {
        str = str + "w";
      }
      this.a = new RandomAccessFile(paramJFile.getPath(), str);
      this.b = paramJFile;
    }
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public long getFilePointer()
    throws IOException
  {
    return this.a.getFilePointer();
  }
  
  public void setFilePointer(long paramLong)
    throws IOException
  {
    this.a.seek(paramLong);
  }
  
  public int read()
    throws IOException
  {
    return this.a.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.a.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public JFile getFile()
  {
    return this.b;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JavaRandomAccessFile
 * JD-Core Version:    0.7.0.1
 */