package com.jscape.inet.ssh.types;

import com.jscape.util.ec;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class SshString
{
  public static byte[] readValue(InputStream paramInputStream)
    throws IOException
  {
    int i = (int)SshUint32.readValue(paramInputStream);
    byte[] arrayOfByte = new byte[i];
    qb.a(arrayOfByte, 0, arrayOfByte.length, paramInputStream);
    return arrayOfByte;
  }
  
  public static String readValue(InputStream paramInputStream, String paramString)
    throws IOException
  {
    return ec.a(readValue(paramInputStream), paramString);
  }
  
  public static void writeValue(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    writeValue(paramArrayOfByte, 0, paramArrayOfByte.length, paramOutputStream);
  }
  
  public static void writeValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    SshUint32.writeValue(paramInt2, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static void writeValue(String paramString1, String paramString2, OutputStream paramOutputStream)
    throws IOException
  {
    writeValue(ec.b(paramString1, paramString2), paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.types.SshString
 * JD-Core Version:    0.7.0.1
 */