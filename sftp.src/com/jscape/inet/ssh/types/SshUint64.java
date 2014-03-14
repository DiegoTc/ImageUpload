package com.jscape.inet.ssh.types;

import com.jscape.inet.ssh.util.ReadUtil;
import com.jscape.util.kb;
import com.jscape.util.qb;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class SshUint64
  implements Comparable
{
  public static final BigInteger MIN_VALUE;
  public static final BigInteger MAX_VALUE;
  public static final int LENGTH = 8;
  private static final kb a;
  private final BigInteger b;
  private static final String z = -1;
  
  public static long readValue(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8];
    qb.a(arrayOfByte, 0, arrayOfByte.length, paramInputStream);
    return a.e(arrayOfByte, 0);
  }
  
  public static void writeValue(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8];
    a.a(paramLong, arrayOfByte, 0);
    paramOutputStream.write(arrayOfByte);
  }
  
  public static BigInteger readBigIntegerFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    byte[] arrayOfByte = new byte[8];
    ReadUtil.read(arrayOfByte, paramInputStream);
    return new BigInteger(arrayOfByte);
  }
  
  public static long readLongFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    return readBigIntegerFrom(paramInputStream).longValue();
  }
  
  public static SshUint64 readFrom(InputStream paramInputStream)
    throws IOException
  {
    return new SshUint64(readBigIntegerFrom(paramInputStream));
  }
  
  public static void writeBigIntegerTo(BigInteger paramBigInteger, OutputStream paramOutputStream)
    throws IOException
  {
    writeLongTo(paramBigInteger.longValue(), paramOutputStream);
  }
  
  public static void writeLongTo(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramOutputStream);
    SshInt64.writeValue(paramLong, paramOutputStream);
  }
  
  public SshUint64(long paramLong)
  {
    this(BigInteger.valueOf(paramLong));
  }
  
  public SshUint64(BigInteger paramBigInteger)
  {
    u.a(paramBigInteger);
    this.b = paramBigInteger;
  }
  
  public BigInteger bigIntegerValue()
  {
    return this.b;
  }
  
  public long longValue()
  {
    return this.b.longValue();
  }
  
  public String toString()
  {
    return this.b.toString();
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    int i = SshUint32.b;
    if (i == 0) {
      if (this == paramObject) {
        return true;
      }
    }
    if (i == 0) {
      if (!(paramObject instanceof SshUint64)) {
        return false;
      }
    }
    SshUint64 localSshUint64 = (SshUint64)paramObject;
    return this.b.equals(localSshUint64.b);
  }
  
  public int compareTo(Object paramObject)
  {
    SshUint64 localSshUint64 = (SshUint64)paramObject;
    return this.b.compareTo(localSshUint64.b);
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    writeBigIntegerTo(this.b, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.types.SshUint64
 * JD-Core Version:    0.7.0.1
 */