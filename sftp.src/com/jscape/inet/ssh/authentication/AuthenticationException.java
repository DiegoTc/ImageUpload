package com.jscape.inet.ssh.authentication;

import com.jscape.util.u;
import java.io.IOException;

public class AuthenticationException
  extends IOException
{
  private Throwable a;
  public static int b;
  
  public AuthenticationException() {}
  
  public AuthenticationException(String paramString)
  {
    super(paramString);
  }
  
  public AuthenticationException(Throwable paramThrowable)
  {
    u.a(paramThrowable);
    this.a = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.AuthenticationException
 * JD-Core Version:    0.7.0.1
 */