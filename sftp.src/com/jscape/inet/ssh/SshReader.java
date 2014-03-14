package com.jscape.inet.ssh;

import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SshReader
{
  private final InputStream a;
  private final boolean b;
  
  public SshReader(byte[] paramArrayOfByte)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), true);
  }
  
  public SshReader(InputStream paramInputStream, boolean paramBoolean)
  {
    u.a(paramInputStream);
    this.a = paramInputStream;
    this.b = paramBoolean;
  }
  
  public void close()
  {
    if ((SshWriter.c) || (this.b)) {
      try
      {
        this.a.close();
      }
      catch (IOException localIOException) {}
    }
  }
  
  public boolean readBoolean()
    throws IOException
  {
    if (!SshWriter.c) {}
    return readByte() > 0;
  }
  
  public int readByte()
    throws IOException
  {
    int i = this.a.read();
    if (!SshWriter.c) {
      if (i < 0) {
        throw new EOFException();
      }
    }
    return i;
  }
  
  public long readUint32()
    throws IOException
  {
    return readInt32() & 0xFFFFFFFF;
  }
  
  public int readInt32()
    throws IOException
  {
    int i = readByte() << 24;
    i |= readByte() << 16;
    i |= readByte() << 8;
    i |= readByte() << 0;
    return i;
  }
  
  public BigInteger readUint64()
    throws IOException
  {
    return BigInteger.valueOf(readInt64()).abs();
  }
  
  public long readInt64()
    throws IOException
  {
    boolean bool = SshWriter.c;
    long l = (readByte() & 0xFFFFFFFF) << 56;
    l |= (readByte() & 0xFFFFFFFF) << 48;
    l |= (readByte() & 0xFFFFFFFF) << 40;
    l |= (readByte() & 0xFFFFFFFF) << 32;
    l |= (readByte() & 0xFFFFFFFF) << 24;
    l |= (readByte() & 0xFFFFFFFF) << 16;
    l |= (readByte() & 0xFFFFFFFF) << 8;
    l |= (readByte() & 0xFFFFFFFF) << 0;
    if (bool) {
      u.a = !u.a;
    }
    return l;
  }
  
  public String readString()
    throws IOException
  {
    return new String(readStringAsByteArray());
  }
  
  public byte[] readStringAsByteArray()
    throws IOException
  {
    int i = (int)readUint32();
    byte[] arrayOfByte = new byte[i];
    readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  public BigInteger readMpint()
    throws IOException
  {
    return new BigInteger(readStringAsByteArray());
  }
  
  public String[] readNameList()
    throws IOException
  {
    boolean bool = SshWriter.c;
    StringTokenizer localStringTokenizer = new StringTokenizer(readString(), ",");
    String[] arrayOfString = new String[localStringTokenizer.countTokens()];
    int i = 0;
    do
    {
      if (i >= arrayOfString.length) {
        break;
      }
      if (bool) {
        break label56;
      }
      arrayOfString[i] = localStringTokenizer.nextToken();
      i++;
    } while (!bool);
    label56:
    return arrayOfString;
  }
  
  public String readLine()
    throws IOException
  {
    boolean bool = SshWriter.c;
    StringBuffer localStringBuffer = new StringBuffer();
    do
    {
      char c;
      for (;;)
      {
        c = (char)readByte();
        if (c != '\r')
        {
          if ((!bool) && (c != '\n')) {
            break;
          }
          if (bool) {
            break label69;
          }
          if (localStringBuffer.length() != 0) {
            break label61;
          }
        }
      }
      localStringBuffer.append(c);
    } while (!bool);
    label61:
    label69:
    return (bool) || (localStringBuffer.length() > 0) ? localStringBuffer.toString() : null;
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool = SshWriter.c;
    int i = 0;
    do
    {
      if (i >= paramInt2) {
        break;
      }
      int j = this.a.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (!bool) {
        if (j < 0) {
          throw new EOFException();
        }
      }
      i += j;
    } while (!bool);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.SshReader
 * JD-Core Version:    0.7.0.1
 */