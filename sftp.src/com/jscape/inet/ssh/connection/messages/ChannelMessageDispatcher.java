package com.jscape.inet.ssh.connection.messages;

import com.jscape.inet.ssh.transport.Message;

public abstract interface ChannelMessageDispatcher
{
  public abstract void dispatch(Message paramMessage);
  
  public abstract void onSshMsgChannelData(SshMsgChannelData paramSshMsgChannelData);
  
  public abstract void onSshMsgChannelEof(SshMsgChannelEof paramSshMsgChannelEof);
  
  public abstract void onSshMsgChannelExtendedData(SshMsgChannelExtendedData paramSshMsgChannelExtendedData);
  
  public abstract void onSshMsgChannelFailure(SshMsgChannelFailure paramSshMsgChannelFailure);
  
  public abstract void onSshMsgChannelRequest(SshMsgChannelRequest paramSshMsgChannelRequest);
  
  public abstract void onSshMsgChannelSuccess(SshMsgChannelSuccess paramSshMsgChannelSuccess);
  
  public abstract void onSshMsgChannelWindowAdjust(SshMsgChannelWindowAdjust paramSshMsgChannelWindowAdjust);
  
  public abstract void onSshMsgChannelClose(SshMsgChannelClose paramSshMsgChannelClose);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.messages.ChannelMessageDispatcher
 * JD-Core Version:    0.7.0.1
 */