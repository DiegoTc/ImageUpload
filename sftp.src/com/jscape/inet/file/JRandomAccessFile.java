package com.jscape.inet.file;

import java.io.IOException;

public abstract interface JRandomAccessFile
{
  public abstract void close()
    throws IOException;
  
  public abstract long getFilePointer()
    throws IOException;
  
  public abstract void setFilePointer(long paramLong)
    throws IOException;
  
  public abstract int read()
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void write(int paramInt)
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract JFile getFile();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JRandomAccessFile
 * JD-Core Version:    0.7.0.1
 */