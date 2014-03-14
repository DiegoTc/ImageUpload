package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.transport.messages.SshMsgDebug;
import com.jscape.inet.ssh.transport.messages.SshMsgDisconnect;
import com.jscape.inet.ssh.transport.messages.SshMsgIgnore;
import com.jscape.inet.ssh.transport.messages.SshMsgKexInit;
import com.jscape.inet.ssh.transport.messages.SshMsgUnimplemented;
import com.jscape.inet.ssh.transport.messages.SshMsgUnknown;
import com.jscape.inet.ssh.transport.messages.TransportDispatchable;
import com.jscape.inet.ssh.transport.messages.TransportMessageDispatcher;

public class Transport$TransportDispatcher
  implements TransportMessageDispatcher
{
  final Transport a;
  
  protected Transport$TransportDispatcher(Transport paramTransport) {}
  
  public boolean onSshMsgDisconnect(SshMsgDisconnect paramSshMsgDisconnect)
  {
    this.a.close();
    return true;
  }
  
  public boolean onSshMsgIgnore(SshMsgIgnore paramSshMsgIgnore)
  {
    return true;
  }
  
  public boolean onSshMsgDebug(SshMsgDebug paramSshMsgDebug)
  {
    return true;
  }
  
  public boolean onSshMsgKexInit(SshMsgKexInit paramSshMsgKexInit)
  {
    return false;
  }
  
  public boolean onSshMsgUnknown(SshMsgUnknown paramSshMsgUnknown)
  {
    try
    {
      this.a.sendMessage(new SshMsgUnimplemented(paramSshMsgUnknown.getId()));
    }
    catch (Exception localException) {}
    return true;
  }
  
  public boolean dispatch(Message paramMessage)
  {
    if (Message.c == 0) {
      if (!(paramMessage instanceof TransportDispatchable)) {
        return false;
      }
    }
    return ((TransportDispatchable)paramMessage).accept(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.Transport.TransportDispatcher
 * JD-Core Version:    0.7.0.1
 */