package com.jscape.inet.ssh.util.keyreader;

import com.jscape.util.u;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

public class CipherFactory$Entry
{
  private static final char a = '/';
  private final String b;
  private final String c;
  private final String d;
  private final int e;
  private static final String z = -1;
  
  public CipherFactory$Entry(String paramString1, String paramString2, int paramInt)
  {
    u.a(paramString1);
    u.a(paramString2);
    u.a(paramInt, 0L, z);
    this.b = paramString1;
    this.d = paramString2;
    this.e = paramInt;
    int i = this.d.indexOf('/');
    this.c = (i >= 0 ? this.d.substring(0, i) : this.d);
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public String getAlgorithm()
  {
    return this.c;
  }
  
  public String getJceName()
  {
    return this.d;
  }
  
  public int getKeySize()
  {
    return this.e;
  }
  
  public Cipher createCipher()
    throws NoSuchAlgorithmException, NoSuchPaddingException
  {
    return Cipher.getInstance(this.d);
  }
  
  public Cipher createCipher(IKeyFactory paramIKeyFactory, int paramInt)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException
  {
    int i = FormatException.a;
    Cipher localCipher = Cipher.getInstance(this.d);
    Key localKey = paramIKeyFactory.createKey(this.c, this.e);
    localCipher.init(paramInt, localKey, new IvParameterSpec(paramIKeyFactory.createIv(localCipher.getBlockSize())));
    if (i != 0) {
      u.a = !u.a;
    }
    return localCipher;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.CipherFactory.Entry
 * JD-Core Version:    0.7.0.1
 */