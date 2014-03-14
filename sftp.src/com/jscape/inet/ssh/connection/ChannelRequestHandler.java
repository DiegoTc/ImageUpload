package com.jscape.inet.ssh.connection;

import com.jscape.inet.ssh.connection.messages.SshMsgChannelOpen;
import com.jscape.inet.ssh.transport.Message;

public abstract interface ChannelRequestHandler
{
  public abstract Message handle(SshMsgChannelOpen paramSshMsgChannelOpen, Connection paramConnection);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.ChannelRequestHandler
 * JD-Core Version:    0.7.0.1
 */