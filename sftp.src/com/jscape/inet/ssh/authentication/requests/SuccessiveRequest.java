package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.AuthenticationRequest;
import java.util.List;

public class SuccessiveRequest
  extends AbstractComplexRequest
{
  public SuccessiveRequest() {}
  
  public SuccessiveRequest(SuccessiveRequest paramSuccessiveRequest)
  {
    super(paramSuccessiveRequest);
  }
  
  public Object clone()
  {
    return new SuccessiveRequest(this);
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
      if (i > 0) {
        pause();
      }
      AuthenticationRequest localAuthenticationRequest = (AuthenticationRequest)this.requests.get(i);
      executeRequest(localAuthenticationRequest);
      i++;
    } while (!bool);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.SuccessiveRequest
 * JD-Core Version:    0.7.0.1
 */