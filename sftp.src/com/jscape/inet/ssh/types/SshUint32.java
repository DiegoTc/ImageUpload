package com.jscape.inet.ssh.types;

import com.jscape.util.qb;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class SshUint32
  implements Comparable
{
  public static final long MIN_VALUE = 0L;
  public static final long MAX_VALUE = 4294967295L;
  public static final int LENGTH = 4;
  private final long a;
  public static int b;
  private static final String z = -1;
  
  public static long readValue(InputStream paramInputStream)
    throws IOException
  {
    int i = qb.b(paramInputStream);
    int j = qb.b(paramInputStream);
    int k = qb.b(paramInputStream);
    int m = qb.b(paramInputStream);
    return (i << 24 | j << 16 | k << 8 | m) & 0xFFFFFFFF;
  }
  
  public static void writeValue(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    int i = (int)(paramLong & 0xFFFFFFFF);
    paramOutputStream.write(i >>> 24 & 0xFF);
    paramOutputStream.write(i >>> 16 & 0xFF);
    paramOutputStream.write(i >>> 8 & 0xFF);
    paramOutputStream.write(i & 0xFF);
  }
  
  public static long readLongFrom(InputStream paramInputStream)
    throws IOException
  {
    return readValue(paramInputStream);
  }
  
  public static int readIntFrom(InputStream paramInputStream)
    throws IOException
  {
    return (int)readLongFrom(paramInputStream);
  }
  
  public static SshUint32 readFrom(InputStream paramInputStream)
    throws IOException
  {
    return new SshUint32(readLongFrom(paramInputStream));
  }
  
  public static void writeLongTo(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramOutputStream);
    paramOutputStream.write((int)(paramLong >>> 24) & 0xFF);
    paramOutputStream.write((int)(paramLong >>> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >>> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >>> 0) & 0xFF);
  }
  
  public static void writeIntTo(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    writeLongTo(paramInt, paramOutputStream);
  }
  
  public SshUint32(long paramLong)
  {
    u.a(paramLong, 0L, 4294967295L, z + paramLong);
    this.a = paramLong;
  }
  
  public int intValue()
  {
    return (int)this.a;
  }
  
  public long longValue()
  {
    return this.a;
  }
  
  public String toString()
  {
    return Long.toString(this.a);
  }
  
  public boolean equals(Object paramObject)
  {
    int i = b;
    if (i == 0) {
      if (this == paramObject) {
        return true;
      }
    }
    if (i == 0) {
      if (!(paramObject instanceof SshUint32)) {
        return false;
      }
    }
    SshUint32 localSshUint32 = (SshUint32)paramObject;
    if (i == 0) {}
    return this.a == localSshUint32.a;
  }
  
  public int hashCode()
  {
    return (int)(this.a ^ this.a >>> 32);
  }
  
  public int compareTo(Object paramObject)
  {
    int i = b;
    SshUint32 localSshUint32 = (SshUint32)paramObject;
    if (i == 0) {
      if (this.a < localSshUint32.a) {
        return -1;
      }
    }
    if (i == 0) {
      if (this.a > localSshUint32.a) {
        return 1;
      }
    }
    return 0;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    writeLongTo(this.a, paramOutputStream);
  }
  
  public static int restore(byte[] paramArrayOfByte, int paramInt)
  {
    int j = b;
    int i = (paramArrayOfByte[paramInt] & 0xFF) << 24;
    i |= (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16;
    i |= (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8;
    i |= paramArrayOfByte[(paramInt + 3)] & 0xFF;
    if (j != 0) {
      u.a = !u.a;
    }
    return i;
  }
  
  public static void store(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = b;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0xFF));
    if (u.a)
    {
      i++;
      b = i;
    }
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.types.SshUint32
 * JD-Core Version:    0.7.0.1
 */