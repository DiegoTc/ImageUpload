package com.jscape.inet.ssh.util.keyreader.vandyke;

import com.jscape.inet.ssh.util.keyreader.CipherFactory;
import com.jscape.inet.ssh.util.keyreader.FormatException;
import com.jscape.inet.ssh.util.keyreader.IKeyFactory;
import com.jscape.util.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;

public class Record
{
  public static final String NO_ENCRYPTION = -1;
  private final String a;
  private final String b;
  private final Map c;
  private final byte[] d;
  private final byte[] e;
  private final byte[] f;
  
  public Record(String paramString1, String paramString2, Map paramMap, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    u.a(paramString1);
    u.a(paramString2);
    u.a(paramMap);
    u.a(paramArrayOfByte1);
    u.a(paramArrayOfByte2);
    u.a(paramArrayOfByte3);
    this.a = paramString1;
    this.b = paramString2;
    this.c = new HashMap(paramMap);
    this.d = ((byte[])paramArrayOfByte1.clone());
    this.e = ((byte[])paramArrayOfByte2.clone());
    this.f = ((byte[])paramArrayOfByte3.clone());
    if (bool) {
      u.a = !u.a;
    }
  }
  
  public String getAlgorithm()
  {
    return this.a;
  }
  
  public boolean isEncrypted()
  {
    if (!VanDykeFormat.f) {}
    return !this.b.equalsIgnoreCase(NO_ENCRYPTION);
  }
  
  public String getEncryptionAlgorithm()
  {
    return this.b;
  }
  
  public String getComment(String paramString)
  {
    return (String)this.c.get(paramString);
  }
  
  public Iterator comments()
  {
    return this.c.keySet().iterator();
  }
  
  public byte[] getPublicKeyData()
  {
    return (byte[])this.d.clone();
  }
  
  public byte[] getPrivateKeyData()
  {
    return (byte[])this.e.clone();
  }
  
  public byte[] getMac()
  {
    return (byte[])this.f.clone();
  }
  
  public Record decrypt(CipherFactory paramCipherFactory, IKeyFactory paramIKeyFactory)
    throws FormatException
  {
    if (!VanDykeFormat.f)
    {
      u.a(paramCipherFactory);
      u.a(paramIKeyFactory);
      if (!isEncrypted()) {
        return this;
      }
    }
    try
    {
      Cipher localCipher = paramCipherFactory.createDecipher(this.b, paramIKeyFactory);
      byte[] arrayOfByte = localCipher.doFinal(this.e);
      return new Record(this.a, NO_ENCRYPTION, this.c, this.d, arrayOfByte, this.f);
    }
    catch (Exception localException)
    {
      throw new FormatException(localException.getMessage());
    }
  }
  
  public Record encrypt(String paramString, CipherFactory paramCipherFactory, IKeyFactory paramIKeyFactory)
    throws FormatException
  {
    boolean bool = VanDykeFormat.f;
    u.a(paramString);
    u.a(paramCipherFactory);
    u.a(paramIKeyFactory);
    try
    {
      Cipher localCipher = paramCipherFactory.createEncipher(paramString, paramIKeyFactory);
      byte[] arrayOfByte = localCipher.doFinal(this.e);
      if (u.a) {
        VanDykeFormat.f = !bool;
      }
      return new Record(this.a, paramString, this.c, this.d, arrayOfByte, this.f);
    }
    catch (Exception localException)
    {
      throw new FormatException(localException.getMessage());
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.vandyke.Record
 * JD-Core Version:    0.7.0.1
 */