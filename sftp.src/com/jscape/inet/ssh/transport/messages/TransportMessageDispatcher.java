package com.jscape.inet.ssh.transport.messages;

import com.jscape.inet.ssh.transport.Message;

public abstract interface TransportMessageDispatcher
{
  public abstract boolean dispatch(Message paramMessage);
  
  public abstract boolean onSshMsgDisconnect(SshMsgDisconnect paramSshMsgDisconnect);
  
  public abstract boolean onSshMsgIgnore(SshMsgIgnore paramSshMsgIgnore);
  
  public abstract boolean onSshMsgDebug(SshMsgDebug paramSshMsgDebug);
  
  public abstract boolean onSshMsgUnknown(SshMsgUnknown paramSshMsgUnknown);
  
  public abstract boolean onSshMsgKexInit(SshMsgKexInit paramSshMsgKexInit);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.messages.TransportMessageDispatcher
 * JD-Core Version:    0.7.0.1
 */