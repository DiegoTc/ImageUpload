package com.jscape.inet.ssh.util.keyreader;

import java.security.KeyPair;

public abstract interface KeyPairFormat
{
  public abstract KeyPair restoreKeyPair(byte[] paramArrayOfByte, String paramString)
    throws FormatException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.KeyPairFormat
 * JD-Core Version:    0.7.0.1
 */