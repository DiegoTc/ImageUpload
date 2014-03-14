package com.jscape.inet.ssh.connection;

import com.jscape.inet.ssh.connection.messages.SshMsgGlobalRequest;
import com.jscape.inet.ssh.transport.Message;

public abstract interface GlobalRequestHandler
{
  public abstract Message handle(SshMsgGlobalRequest paramSshMsgGlobalRequest, Connection paramConnection);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.GlobalRequestHandler
 * JD-Core Version:    0.7.0.1
 */