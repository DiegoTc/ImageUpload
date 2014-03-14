package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.transport.messages.SshMsgKexInit;

public class Transport$KexDispatcher
  extends Transport.TransportDispatcher
{
  final Transport b;
  
  protected Transport$KexDispatcher(Transport paramTransport)
  {
    super(paramTransport);
  }
  
  public boolean onSshMsgKexInit(SshMsgKexInit paramSshMsgKexInit)
  {
    try
    {
      this.b.exchangeKeys(paramSshMsgKexInit);
    }
    catch (Exception localException) {}
    return true;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.Transport.KexDispatcher
 * JD-Core Version:    0.7.0.1
 */