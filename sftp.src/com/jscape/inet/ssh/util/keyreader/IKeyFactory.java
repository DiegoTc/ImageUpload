package com.jscape.inet.ssh.util.keyreader;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

public abstract interface IKeyFactory
{
  public abstract Key createKey(String paramString, int paramInt)
    throws NoSuchAlgorithmException;
  
  public abstract byte[] createIv(int paramInt);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.IKeyFactory
 * JD-Core Version:    0.7.0.1
 */