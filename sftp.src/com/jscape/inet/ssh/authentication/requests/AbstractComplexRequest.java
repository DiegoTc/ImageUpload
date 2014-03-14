package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.AuthenticationRequest;
import com.jscape.util.u;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComplexRequest
  extends AbstractAuthenticationRequest
{
  private static final long h = 0L;
  protected final List requests;
  protected long requestsPause;
  private static final String z = -1;
  
  public AbstractComplexRequest()
  {
    this.requests = new ArrayList();
    this.requestsPause = 0L;
  }
  
  protected AbstractComplexRequest(AbstractComplexRequest paramAbstractComplexRequest)
  {
    super(paramAbstractComplexRequest);
    this.requests = new ArrayList(paramAbstractComplexRequest.requests);
    this.requestsPause = paramAbstractComplexRequest.requestsPause;
  }
  
  public void addRequest(AuthenticationRequest paramAuthenticationRequest)
  {
    u.a(paramAuthenticationRequest);
    this.requests.add(paramAuthenticationRequest);
  }
  
  public void setRequest(AuthenticationRequest paramAuthenticationRequest, int paramInt)
  {
    u.a(paramAuthenticationRequest);
    this.requests.set(paramInt, paramAuthenticationRequest);
  }
  
  public void removeRequest(AuthenticationRequest paramAuthenticationRequest)
  {
    this.requests.remove(paramAuthenticationRequest);
  }
  
  public void removeRequest(int paramInt)
  {
    this.requests.remove(paramInt);
  }
  
  public void clearRequests()
  {
    this.requests.clear();
  }
  
  public long getRequestsPause()
  {
    return this.requestsPause;
  }
  
  public void setRequestsPause(long paramLong)
  {
    u.b(paramLong, 0L, z);
    this.requestsPause = paramLong;
  }
  
  protected void executeRequest(AuthenticationRequest paramAuthenticationRequest)
  {
    setupRequest(paramAuthenticationRequest);
    paramAuthenticationRequest.run();
    if (!AbstractAuthenticationRequest.g)
    {
      if ((paramAuthenticationRequest.getBanner() != null) && (paramAuthenticationRequest.getBanner().length() > 0)) {
        this.banner = paramAuthenticationRequest.getBanner();
      }
      this.error = paramAuthenticationRequest.getError();
    }
  }
  
  protected void setupRequest(AuthenticationRequest paramAuthenticationRequest)
  {
    paramAuthenticationRequest.setUser(this.user);
    paramAuthenticationRequest.setServiceName(this.serviceName);
    paramAuthenticationRequest.setTransportSession(this.session);
  }
  
  protected void pause()
  {
    if (!AbstractAuthenticationRequest.g) {
      if (this.requestsPause == 0L) {
        return;
      }
    }
    try
    {
      Thread.sleep(this.requestsPause);
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.AbstractComplexRequest
 * JD-Core Version:    0.7.0.1
 */