package com.jscape.inet.ssh.types;

import com.jscape.inet.ssh.util.ReadUtil;
import com.jscape.util.qb;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class SshByte
  implements Comparable
{
  public static final int MIN_VALUE = 0;
  public static final int MAX_VALUE = 255;
  public static final int LENGTH = 1;
  private final int a;
  private static final String z = -1;
  
  public static int readValue(InputStream paramInputStream)
    throws IOException
  {
    return qb.b(paramInputStream);
  }
  
  public static void writeValue(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramInt);
  }
  
  public static int readIntFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    return ReadUtil.read(paramInputStream) & 0xFF;
  }
  
  public static SshByte readFrom(InputStream paramInputStream)
    throws IOException
  {
    return new SshByte(readIntFrom(paramInputStream));
  }
  
  public static void writeIntTo(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramOutputStream);
    paramOutputStream.write(paramInt & 0xFF);
  }
  
  public SshByte(int paramInt)
  {
    u.a(paramInt, 0L, 255L, z + paramInt);
    this.a = paramInt;
  }
  
  public int intValue()
  {
    return this.a;
  }
  
  public String toString()
  {
    return Integer.toString(this.a);
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
      if (!(paramObject instanceof SshByte)) {
        return false;
      }
    }
    SshByte localSshByte = (SshByte)paramObject;
    if (i == 0) {}
    return this.a == localSshByte.a;
  }
  
  public int hashCode()
  {
    return this.a;
  }
  
  public int compareTo(Object paramObject)
  {
    int i = SshUint32.b;
    SshByte localSshByte = (SshByte)paramObject;
    if (i == 0)
    {
      if (this.a < localSshByte.a) {
        return -1;
      }
      if (i != 0) {}
    }
    else if (this.a > localSshByte.a)
    {
      return 1;
    }
    return 0;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    writeIntTo(this.a, paramOutputStream);
  }
  
  public static int restore(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt];
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.types.SshByte
 * JD-Core Version:    0.7.0.1
 */