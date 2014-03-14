package com.jscape.inet.ssh.transport.compression;

import com.jscape.util.u;

public final class NullCompression
  extends Compression
{
  public static final String ALGORITHM = -1;
  
  public NullCompression()
  {
    super(ALGORITHM);
  }
  
  public byte[] update(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte;
  }
  
  public byte[] update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = Compression.c;
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, arrayOfByte.length);
    if (u.a) {
      Compression.c = ++i;
    }
    return arrayOfByte;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.compression.NullCompression
 * JD-Core Version:    0.7.0.1
 */