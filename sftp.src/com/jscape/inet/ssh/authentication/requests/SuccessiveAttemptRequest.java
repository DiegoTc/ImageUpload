package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.AuthenticationRequest;
import java.util.List;

public class SuccessiveAttemptRequest
  extends AbstractComplexRequest
{
  public SuccessiveAttemptRequest() {}
  
  public SuccessiveAttemptRequest(SuccessiveAttemptRequest paramSuccessiveAttemptRequest)
  {
    super(paramSuccessiveAttemptRequest);
  }
  
  public Object clone()
  {
    return new SuccessiveAttemptRequest(this);
  }
  
  protected void execute()
    throws Exception
  {
    boolean bool = AbstractAuthenticationRequest.g;
    int i = 0;
    int j = this.requests.size();
    do
    {
      if (i >= j) {
        break;
      }
      if (i > 0)
      {
        this.error = null;
        pause();
      }
      AuthenticationRequest localAuthenticationRequest = (AuthenticationRequest)this.requests.get(i);
      executeRequest(localAuthenticationRequest);
      if (!bool)
      {
        if (this.error == null) {
          return;
        }
        i++;
      }
    } while (!bool);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.SuccessiveAttemptRequest
 * JD-Core Version:    0.7.0.1
 */