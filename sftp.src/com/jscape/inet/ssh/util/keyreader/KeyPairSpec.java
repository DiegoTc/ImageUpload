package com.jscape.inet.ssh.util.keyreader;

import com.jscape.util.u;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class KeyPairSpec
{
  private String a;
  private KeySpec b = null;
  private KeySpec c = null;
  
  public KeyPairSpec(String paramString, KeySpec paramKeySpec1, KeySpec paramKeySpec2)
  {
    u.a(paramString);
    u.a(paramKeySpec1);
    u.a(paramKeySpec2);
    this.a = paramString;
    this.b = paramKeySpec1;
    this.c = paramKeySpec2;
    if (u.a)
    {
      i++;
      FormatException.a = i;
    }
  }
  
  public String getAlgorithm()
  {
    return this.a;
  }
  
  public KeySpec getPublicSpec()
  {
    return this.b;
  }
  
  public KeySpec getPrivateSpec()
  {
    return this.c;
  }
  
  public KeyPair toKeyPair()
    throws FormatException, NoSuchAlgorithmException, InvalidKeySpecException
  {
    KeyFactory localKeyFactory = KeyFactory.getInstance(this.a);
    PublicKey localPublicKey = localKeyFactory.generatePublic(this.b);
    PrivateKey localPrivateKey = localKeyFactory.generatePrivate(this.c);
    return new KeyPair(localPublicKey, localPrivateKey);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.KeyPairSpec
 * JD-Core Version:    0.7.0.1
 */