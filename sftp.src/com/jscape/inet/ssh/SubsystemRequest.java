package com.jscape.inet.ssh;

import com.jscape.inet.ssh.connection.ConnectionClient;
import com.jscape.inet.ssh.connection.ConnectionException;
import com.jscape.inet.ssh.connection.channels.Channel;
import com.jscape.inet.ssh.connection.channels.SessionClient;
import com.jscape.util.u;
import java.io.IOException;

public final class SubsystemRequest
  implements ChannelRequest
{
  private SessionRequest a;
  private String b;
  private boolean c;
  
  public SubsystemRequest(SessionRequest paramSessionRequest, String paramString, boolean paramBoolean)
  {
    u.a(paramSessionRequest);
    this.a = paramSessionRequest;
    u.a(paramString);
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  public long getWindowSize()
  {
    return this.a.getWindowSize();
  }
  
  public int getPacketSize()
  {
    return this.a.getPacketSize();
  }
  
  public String getSubsystem()
  {
    return this.b;
  }
  
  public synchronized void execute(ConnectionClient paramConnectionClient)
    throws IOException, ConnectionException
  {
    this.a.execute(paramConnectionClient);
    SessionClient localSessionClient = (SessionClient)getChannel();
    localSessionClient.startSubsystem(this.b, this.c);
  }
  
  public Channel getChannel()
  {
    return this.a.getChannel();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.SubsystemRequest
 * JD-Core Version:    0.7.0.1
 */