package com.jscape.util.g;

import com.jscape.util.bc;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class yb
  implements fc
{
  private static final String a = -1;
  private final String b;
  private final byte[] c;
  
  public yb(String paramString, byte[] paramArrayOfByte)
  {
    bc.a(paramString);
    this.b = paramString;
    bc.a(paramArrayOfByte);
    this.c = paramArrayOfByte;
  }
  
  public InputStream a(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      Cipher localCipher = a(1);
      return new CipherInputStream(paramInputStream, localCipher);
    }
    catch (Exception localException)
    {
      throw new k(localException);
    }
  }
  
  public InputStream b(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      Cipher localCipher = a(2);
      return new CipherInputStream(paramInputStream, localCipher);
    }
    catch (Exception localException)
    {
      throw new k(localException);
    }
  }
  
  public OutputStream a(OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      Cipher localCipher = a(1);
      return new CipherOutputStream(paramOutputStream, localCipher);
    }
    catch (Exception localException)
    {
      throw new k(localException);
    }
  }
  
  public OutputStream b(OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      Cipher localCipher = a(2);
      return new CipherOutputStream(paramOutputStream, localCipher);
    }
    catch (Exception localException)
    {
      throw new k(localException);
    }
  }
  
  private Cipher a(int paramInt)
    throws Exception
  {
    String str = String.format(a, new Object[] { this.b });
    Cipher localCipher = Cipher.getInstance(str);
    byte[] arrayOfByte = new byte[localCipher.getBlockSize()];
    localCipher.init(paramInt, new SecretKeySpec(this.c, this.b), new IvParameterSpec(arrayOfByte));
    return localCipher;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.yb
 * JD-Core Version:    0.7.0.1
 */