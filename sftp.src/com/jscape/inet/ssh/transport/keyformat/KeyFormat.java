package com.jscape.inet.ssh.transport.keyformat;

import com.jscape.util.u;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public abstract class KeyFormat
{
  private String a;
  public static boolean b;
  
  protected KeyFormat(String paramString)
  {
    u.a(paramString);
    this.a = paramString;
  }
  
  public String getAlgorithm()
  {
    return this.a;
  }
  
  public abstract PublicKey getKeyFrom(byte[] paramArrayOfByte)
    throws KeyFormatException;
  
  public abstract byte[] format(PublicKey paramPublicKey)
    throws KeyFormatException;
  
  public abstract byte[] getSignatureFrom(byte[] paramArrayOfByte)
    throws KeyFormatException;
  
  public abstract byte[] sign(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
    throws KeyFormatException;
  
  public abstract void verifySignature(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
    throws KeyFormatException;
  
  public abstract KeyPair generateKeyPair()
    throws KeyFormatException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.keyformat.KeyFormat
 * JD-Core Version:    0.7.0.1
 */