package com.jscape.inet.file;

import java.io.IOException;
import java.io.OutputStream;

public class JFileOutputStream
  extends OutputStream
{
  private final JRandomAccessFile a;
  
  private static JFileOpenFlags a(long paramLong)
  {
    boolean bool = JAcl.Mask.r;
    JFileOpenFlags localJFileOpenFlags = new JFileOpenFlags();
    if (!bool)
    {
      if (paramLong == 0L) {
        localJFileOpenFlags.setCreateTruncate(true);
      }
    }
    else {
      if (!bool) {
        break label36;
      }
    }
    localJFileOpenFlags.setOpenOrCreate(true);
    label36:
    localJFileOpenFlags.setWriteLock(true);
    return localJFileOpenFlags;
  }
  
  private static JAcl.Mask b()
  {
    JAcl.Mask localMask = new JAcl.Mask();
    localMask.setWriteData(true);
    return localMask;
  }
  
  public JFileOutputStream(JFile paramJFile)
    throws IOException
  {
    this(paramJFile, 0L);
  }
  
  public JFileOutputStream(JFile paramJFile, long paramLong)
    throws IOException
  {
    this(paramJFile.getRandomAccessFile(a(paramLong), b()));
    this.a.setFilePointer(paramLong);
  }
  
  public JFileOutputStream(JRandomAccessFile paramJRandomAccessFile)
  {
    this.a = paramJRandomAccessFile;
  }
  
  public synchronized void close()
    throws IOException
  {
    this.a.close();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
  
  public synchronized void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
  }
  
  public synchronized void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JFileOutputStream
 * JD-Core Version:    0.7.0.1
 */