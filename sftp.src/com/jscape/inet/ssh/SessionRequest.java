package com.jscape.inet.ssh;

import com.jscape.inet.ssh.connection.channels.Channel;
import com.jscape.inet.ssh.connection.channels.SessionClient;

public abstract class SessionRequest
  extends AbstractChannelRequest
{
  protected SessionClient channel;
  
  public SessionRequest(long paramLong, int paramInt)
  {
    super(paramLong, paramInt);
  }
  
  protected SessionRequest() {}
  
  public Channel getChannel()
  {
    return this.channel;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.SessionRequest
 * JD-Core Version:    0.7.0.1
 */