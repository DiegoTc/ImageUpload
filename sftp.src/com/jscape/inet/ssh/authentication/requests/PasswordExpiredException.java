package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.AuthenticationException;
import com.jscape.util.u;

public class PasswordExpiredException
  extends AuthenticationException
{
  private final String c;
  
  public PasswordExpiredException(String paramString)
  {
    u.a(paramString);
    this.c = paramString;
  }
  
  public String getPromt()
  {
    return this.c;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.PasswordExpiredException
 * JD-Core Version:    0.7.0.1
 */