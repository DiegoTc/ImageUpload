package com.jscape.inet.ssh.connection.messages;

import com.jscape.inet.ssh.transport.Message;

public abstract interface ConnectionMessageDispatcher
{
  public abstract void dispatch(Message paramMessage);
  
  public abstract void onSshMsgGlobalRequest(SshMsgGlobalRequest paramSshMsgGlobalRequest);
  
  public abstract void onSsgMsgRequestFailure(SshMsgRequestFailure paramSshMsgRequestFailure);
  
  public abstract void onSshMsgRequestSuccess(SshMsgRequestSuccess paramSshMsgRequestSuccess);
  
  public abstract void onSshMsgChannelOpen(SshMsgChannelOpen paramSshMsgChannelOpen);
  
  public abstract void onSshMsgChannelOpenConfirmation(SshMsgChannelOpenConfirmation paramSshMsgChannelOpenConfirmation);
  
  public abstract void onSshMsgChannelOpenFailure(SshMsgChannelOpenFailure paramSshMsgChannelOpenFailure);
  
  public abstract void onSshMsgChannel(long paramLong, Message paramMessage);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.messages.ConnectionMessageDispatcher
 * JD-Core Version:    0.7.0.1
 */