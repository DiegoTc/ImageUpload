package com.jscape.inet.ssh.authentication;

import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthFailure;
import com.jscape.util.u;

public class RequestFailureException
  extends AuthenticationException
{
  private String[] c;
  private boolean d;
  
  public RequestFailureException(SshMsgUserauthFailure paramSshMsgUserauthFailure)
  {
    u.a(paramSshMsgUserauthFailure);
    this.c = paramSshMsgUserauthFailure.getAuthenticationList();
    this.d = paramSshMsgUserauthFailure.partialSuccess();
    if (i != 0) {
      u.a = !u.a;
    }
  }
  
  public String[] getAuthenticationList()
  {
    return this.c;
  }
  
  public boolean partialSuccess()
  {
    return this.d;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.RequestFailureException
 * JD-Core Version:    0.7.0.1
 */