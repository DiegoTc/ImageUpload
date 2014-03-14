package com.jscape.inet.ssh.util.keyreader.openssh;

import com.jscape.util.u;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class DataReader
{
  private final DataInputStream a;
  private static final String z = -1;
  
  public DataReader(InputStream paramInputStream)
  {
    u.a(paramInputStream);
    this.a = new DataInputStream(paramInputStream);
  }
  
  public int readByte()
    throws IOException
  {
    return this.a.readByte() & 0xFF;
  }
  
  public BigInteger readBigInteger()
    throws IOException
  {
    int i = readLength();
    try
    {
      byte[] arrayOfByte = new byte[i];
      this.a.readFully(arrayOfByte);
      return new BigInteger(arrayOfByte);
    }
    catch (NegativeArraySizeException localNegativeArraySizeException)
    {
      throw new IOException(z);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new IOException(z);
    }
  }
  
  public int readLength()
    throws IOException
  {
    boolean bool = Record.f;
    int i = readByte();
    if (!bool) {
      if ((i & 0x80) != 0)
      {
        int j = 0;
        int k = i % 128;
        do
        {
          if (k <= 0) {
            break;
          }
          j <<= 8;
          j |= readByte();
          k--;
          if (bool) {
            return i;
          }
        } while (!bool);
        i = j;
      }
    }
    return i;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.openssh.DataReader
 * JD-Core Version:    0.7.0.1
 */