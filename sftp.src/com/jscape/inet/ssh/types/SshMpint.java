package com.jscape.inet.ssh.types;

import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class SshMpint
  implements Comparable
{
  private final BigInteger a;
  
  public static byte[] readValue(InputStream paramInputStream)
    throws IOException
  {
    return SshString.readValue(paramInputStream);
  }
  
  public static void writeValue(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    SshString.writeValue(paramArrayOfByte, paramOutputStream);
  }
  
  public static BigInteger readBigIntegerFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    byte[] arrayOfByte = SshString.readValue(paramInputStream);
    return new BigInteger(arrayOfByte);
  }
  
  public static SshMpint readFrom(InputStream paramInputStream)
    throws IOException
  {
    return new SshMpint(readBigIntegerFrom(paramInputStream));
  }
  
  public static void writeBigIntegerTo(BigInteger paramBigInteger, OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramBigInteger);
    u.a(paramOutputStream);
    SshString.writeValue(paramBigInteger.toByteArray(), paramOutputStream);
  }
  
  public SshMpint(BigInteger paramBigInteger)
  {
    u.a(paramBigInteger);
    this.a = paramBigInteger;
  }
  
  public BigInteger bigIntegerValue()
  {
    return this.a;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
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
      if (!(paramObject instanceof SshMpint)) {
        return false;
      }
    }
    SshMpint localSshMpint = (SshMpint)paramObject;
    return this.a.equals(localSshMpint.a);
  }
  
  public int compareTo(Object paramObject)
  {
    SshMpint localSshMpint = (SshMpint)paramObject;
    return this.a.compareTo(localSshMpint.a);
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    writeBigIntegerTo(this.a, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.types.SshMpint
 * JD-Core Version:    0.7.0.1
 */