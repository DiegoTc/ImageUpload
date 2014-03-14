package com.jscape.inet.ssh.util;

import com.jscape.inet.ssh.util.keyreader.FormatException;
import com.jscape.util.u;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.KeyPair;

public class User
  implements Serializable
{
  private static final KeyPairAssembler a = new KeyPairAssembler();
  private String b;
  private String c;
  private KeyPair d;
  
  public User(String paramString1, String paramString2, KeyPair paramKeyPair)
  {
    setName(paramString1);
    setPassword(paramString2);
    setKeyPair(paramKeyPair);
  }
  
  public User(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public User(String paramString, KeyPair paramKeyPair)
  {
    this(paramString, null, paramKeyPair);
  }
  
  public User(String paramString1, File paramFile, String paramString2)
    throws IOException
  {
    this(paramString1, null, paramFile, paramString2);
  }
  
  public User(String paramString1, String paramString2, File paramFile, String paramString3)
    throws IOException
  {
    this(paramString1, paramString2, a.restoreKeyPair(paramFile, paramString3));
  }
  
  public User(User paramUser)
  {
    setName(paramUser.b);
    setPassword(paramUser.c);
    setKeyPair(paramUser.d);
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public String getPassword()
  {
    return this.c;
  }
  
  public KeyPair getKeyPair()
  {
    return this.d;
  }
  
  public void setName(String paramString)
  {
    u.a(paramString);
    this.b = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.c = paramString;
  }
  
  public void setKeyPair(KeyPair paramKeyPair)
  {
    this.d = paramKeyPair;
  }
  
  public void setKeyPair(File paramFile, String paramString)
    throws IOException
  {
    setKeyPair(a.restoreKeyPair(paramFile, paramString));
  }
  
  public void setKeyPair(String paramString1, String paramString2)
    throws FormatException
  {
    setKeyPair(a.restoreKeyPair(paramString1, paramString2));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.User
 * JD-Core Version:    0.7.0.1
 */