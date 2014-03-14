package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthRequest;
import com.jscape.inet.ssh.transport.Message;
import com.jscape.inet.ssh.transport.TransportClient;
import com.jscape.inet.ssh.util.User;

public class NoneRequest
  extends AbstractAuthenticationRequest
{
  public static final String NAME = -1;
  
  public NoneRequest() {}
  
  public NoneRequest(NoneRequest paramNoneRequest)
  {
    super(paramNoneRequest);
  }
  
  public Object clone()
  {
    return new NoneRequest(this);
  }
  
  protected void execute()
    throws Exception
  {
    Message localMessage1 = l();
    this.session.sendMessage(localMessage1);
    Message localMessage2 = receiveResponse();
    assertSuccess(localMessage2);
  }
  
  private Message l()
  {
    return new SshMsgUserauthRequest(this.user.getName(), this.serviceName, NAME, new byte[0]);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.NoneRequest
 * JD-Core Version:    0.7.0.1
 */