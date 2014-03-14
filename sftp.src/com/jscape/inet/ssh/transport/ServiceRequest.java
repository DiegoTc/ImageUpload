package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.transport.messages.SshMsgServiceAccept;
import com.jscape.inet.ssh.transport.messages.SshMsgServiceRequest;
import com.jscape.util.m.b;
import com.jscape.util.u;
import java.io.IOException;

public class ServiceRequest
  extends b
{
  private String g;
  private TransportClient h;
  private Throwable i;
  private static final String z = -1;
  
  public String getServiceName()
  {
    return this.g;
  }
  
  public void setServiceName(String paramString)
  {
    u.a(paramString);
    this.g = paramString;
  }
  
  public TransportClient getSession()
  {
    return this.h;
  }
  
  public void setSession(TransportClient paramTransportClient)
  {
    u.a(paramTransportClient);
    this.h = paramTransportClient;
  }
  
  public boolean isValid()
  {
    return ((Message.c != 0) || (this.g != null)) && (this.h != null);
  }
  
  public boolean isSuccessful()
  {
    return this.i == null;
  }
  
  public Throwable getError()
  {
    return this.i;
  }
  
  protected void onStart()
  {
    super.onStart();
    this.h.registerMessage(5, SshMsgServiceRequest.class);
    this.h.registerMessage(6, SshMsgServiceAccept.class);
  }
  
  protected void execute()
    throws Exception
  {
    SshMsgServiceRequest localSshMsgServiceRequest = new SshMsgServiceRequest(this.g);
    this.h.sendMessage(localSshMsgServiceRequest);
    Message localMessage = this.h.receiveMessage();
    if (!(localMessage instanceof SshMsgServiceAccept)) {
      throw new IOException(z);
    }
  }
  
  protected void onError(Throwable paramThrowable)
  {
    this.i = paramThrowable;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.ServiceRequest
 * JD-Core Version:    0.7.0.1
 */