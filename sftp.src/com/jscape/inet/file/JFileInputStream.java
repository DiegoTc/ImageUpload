package com.jscape.inet.file;

import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;

public class JFileInputStream
  extends InputStream
{
  protected final JRandomAccessFile file;
  
  private static JFileOpenFlags b()
  {
    JFileOpenFlags localJFileOpenFlags = new JFileOpenFlags();
    localJFileOpenFlags.setOpenExisting(true);
    localJFileOpenFlags.setReadLock(true);
    return localJFileOpenFlags;
  }
  
  private static JAcl.Mask c()
  {
    JAcl.Mask localMask = new JAcl.Mask();
    localMask.setReadData(true);
    return localMask;
  }
  
  public JFileInputStream(JFile paramJFile)
    throws IOException
  {
    this(paramJFile, 0L);
  }
  
  public JFileInputStream(JFile paramJFile, long paramLong)
    throws IOException
  {
    this(paramJFile.getRandomAccessFile(b(), c()));
    this.file.setFilePointer(paramLong);
  }
  
  public JFileInputStream(JRandomAccessFile paramJRandomAccessFile)
  {
    u.a(paramJRandomAccessFile);
    this.file = paramJRandomAccessFile;
  }
  
  public synchronized void close()
    throws IOException
  {
    this.file.close();
  }
  
  public synchronized int read()
    throws IOException
  {
    return this.file.read();
  }
  
  public synchronized int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.file.read(paramArrayOfByte);
  }
  
  public synchronized int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.file.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JFileInputStream
 * JD-Core Version:    0.7.0.1
 */