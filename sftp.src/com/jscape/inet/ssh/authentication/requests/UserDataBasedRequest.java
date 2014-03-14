package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.AuthenticationRequest;
import com.jscape.inet.ssh.transport.TransportClient;
import com.jscape.inet.ssh.util.User;
import com.jscape.util.m.b;

public class UserDataBasedRequest
  extends b
  implements AuthenticationRequest
{
  private static final String g = -1;
  private final SuccessiveAttemptRequest h;
  protected Throwable error;
  
  public UserDataBasedRequest()
  {
    this.h = new SuccessiveAttemptRequest();
  }
  
  public UserDataBasedRequest(UserDataBasedRequest paramUserDataBasedRequest)
  {
    this.h = new SuccessiveAttemptRequest(paramUserDataBasedRequest.h);
  }
  
  public User getUser()
  {
    return this.h.getUser();
  }
  
  public void setUser(User paramUser)
  {
    this.h.setUser(paramUser);
  }
  
  public String getServiceName()
  {
    return this.h.getServiceName();
  }
  
  public void setServiceName(String paramString)
  {
    this.h.setServiceName(paramString);
  }
  
  public TransportClient getTransportSession()
  {
    return this.h.getTransportSession();
  }
  
  public void setTransportSession(TransportClient paramTransportClient)
  {
    this.h.setTransportSession(paramTransportClient);
  }
  
  public boolean isSuccessful()
  {
    return this.h.isSuccessful();
  }
  
  public boolean isValid()
  {
    return this.h.isValid();
  }
  
  public String getBanner()
  {
    return this.h.getBanner();
  }
  
  public long getRequestsPause()
  {
    return this.h.getRequestsPause();
  }
  
  public void setRequestsPause(long paramLong)
  {
    this.h.setRequestsPause(paramLong);
  }
  
  public Object clone()
  {
    return new UserDataBasedRequest(this);
  }
  
  public boolean isDone()
  {
    return this.h.isDone();
  }
  
  public void cancel()
  {
    this.h.cancel();
  }
  
  public Throwable getError()
  {
    if (!AbstractAuthenticationRequest.g) {}
    return this.error != null ? this.error : this.h.getError();
  }
  
  protected void onStart()
  {
    boolean bool = AbstractAuthenticationRequest.g;
    this.h.clearRequests();
    if (!bool)
    {
      if (getUser().getKeyPair() != null) {
        this.h.addRequest(new PublicKeyRequest());
      }
      if (bool) {}
    }
    else if (getUser().getPassword() == null)
    {
      return;
    }
    this.h.addRequest(new PasswordRequest());
    RegexKBIRequest localRegexKBIRequest = new RegexKBIRequest();
    localRegexKBIRequest.addResponse(g, getUser().getPassword());
    this.h.addRequest(localRegexKBIRequest);
  }
  
  protected void onError(Throwable paramThrowable)
  {
    this.error = paramThrowable;
  }
  
  protected void execute()
  {
    this.h.run();
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.UserDataBasedRequest
 * JD-Core Version:    0.7.0.1
 */