package com.jscape.inet.ssh.types;

import com.jscape.util.kb;
import com.jscape.util.qb;
import com.jscape.util.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshInt64
  implements Comparable
{
  public static final long MIN_VALUE = -9223372036854775808L;
  public static final long MAX_VALUE = 9223372036854775807L;
  public static final int LENGTH = 8;
  private static final kb a = new v();
  private final long b;
  
  public static long readValue(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8];
    qb.a(arrayOfByte, 0, arrayOfByte.length, paramInputStream);
    return a.e(arrayOfByte, 0);
  }
  
  public static SshInt64 readFrom(InputStream paramInputStream)
    throws IOException
  {
    return new SshInt64(readValue(paramInputStream));
  }
  
  public static void writeValue(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8];
    a.a(paramLong, arrayOfByte, 0);
    paramOutputStream.write(arrayOfByte);
  }
  
  public SshInt64(long paramLong)
  {
    this.b = paramLong;
  }
  
  public long getLongValue()
  {
    return this.b;
  }
  
  public String toString()
  {
    return Long.toString(this.b);
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
      if (!(paramObject instanceof SshInt64)) {
        return false;
      }
    }
    SshInt64 localSshInt64 = (SshInt64)paramObject;
    if (i == 0) {}
    return this.b == localSshInt64.b;
  }
  
  public int hashCode()
  {
    return (int)(this.b ^ this.b >>> 32);
  }
  
  public int compareTo(Object paramObject)
  {
    int i = SshUint32.b;
    SshInt64 localSshInt64 = (SshInt64)paramObject;
    if (i == 0) {
      if (this.b < localSshInt64.b) {
        return -1;
      }
    }
    if (i == 0) {
      if (this.b > localSshInt64.b) {
        return 1;
      }
    }
    return 0;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    writeValue(this.b, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.types.SshInt64
 * JD-Core Version:    0.7.0.1
 */