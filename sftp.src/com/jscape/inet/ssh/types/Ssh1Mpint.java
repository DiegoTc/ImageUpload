package com.jscape.inet.ssh.types;

import com.jscape.util.qb;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Ssh1Mpint
{
  public static byte[] readValue(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    if (SshUint32.b == 0) {
      if ((i | j) < 0) {
        throw new EOFException();
      }
    }
    int k = i << 8 | j;
    byte[] arrayOfByte = new byte[(k + 7) / 8];
    qb.a(arrayOfByte, 0, arrayOfByte.length, paramInputStream);
    return arrayOfByte;
  }
  
  public static void writeValue(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramArrayOfByte.length * 8;
    paramOutputStream.write(i >>> 8 & 0xFF);
    paramOutputStream.write(i & 0xFF);
    paramOutputStream.write(paramArrayOfByte);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.types.Ssh1Mpint
 * JD-Core Version:    0.7.0.1
 */