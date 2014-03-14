package com.jscape.inet.ssh.connection;

import com.jscape.inet.ssh.connection.messages.SshMsgChannelOpenFailure;

public class OpenFailureException
  extends ConnectionException
{
  private final long b;
  
  public OpenFailureException(SshMsgChannelOpenFailure paramSshMsgChannelOpenFailure)
  {
    super(paramSshMsgChannelOpenFailure.getAdditionalInfo());
    this.b = paramSshMsgChannelOpenFailure.getReasonCode();
  }
  
  public long getReasonCode()
  {
    return this.b;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.OpenFailureException
 * JD-Core Version:    0.7.0.1
 */