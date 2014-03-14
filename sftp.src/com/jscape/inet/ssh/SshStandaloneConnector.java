package com.jscape.inet.ssh;

import com.jscape.inet.ssh.connection.ConnectionClient;
import com.jscape.inet.ssh.connection.channels.Channel;
import com.jscape.inet.ssh.connection.channels.IncomingWindow;
import com.jscape.inet.ssh.util.User;
import com.jscape.inet.util.ConnectionParameters;
import com.jscape.inet.util.a.a;
import com.jscape.inet.util.a.b;
import com.jscape.util.u;
import java.io.IOException;

public class SshStandaloneConnector
  implements b
{
  private SshConfiguration a;
  private ConnectionParameters b;
  private User c;
  private ChannelRequest d;
  
  public SshStandaloneConnector(SshConfiguration paramSshConfiguration, ConnectionParameters paramConnectionParameters, User paramUser, ChannelRequest paramChannelRequest)
  {
    setConfiguration(paramSshConfiguration);
    setConnectionParameters(paramConnectionParameters);
    setUser(paramUser);
    this.d = paramChannelRequest;
  }
  
  public SshConfiguration getConfiguration()
  {
    return this.a;
  }
  
  public void setConfiguration(SshConfiguration paramSshConfiguration)
  {
    u.a(paramSshConfiguration);
    this.a = paramSshConfiguration;
  }
  
  public ConnectionParameters getConnectionParameters()
  {
    return new ConnectionParameters(this.b);
  }
  
  public void setConnectionParameters(ConnectionParameters paramConnectionParameters)
  {
    u.a(paramConnectionParameters);
    this.b = new ConnectionParameters(paramConnectionParameters);
  }
  
  public User getUser()
  {
    return new User(this.c);
  }
  
  public void setUser(User paramUser)
  {
    u.a(paramUser);
    this.c = new User(paramUser);
  }
  
  public ChannelRequest getChannelRequest()
  {
    return this.d;
  }
  
  public void setChannelRequest(ChannelRequest paramChannelRequest)
  {
    u.a(paramChannelRequest);
    this.d = paramChannelRequest;
  }
  
  public String getAddress()
  {
    return this.b.getHost();
  }
  
  public int getPort()
  {
    return this.b.getPort();
  }
  
  public long getTimeout()
  {
    return this.b.getConnectionTimeout();
  }
  
  public void setTimeout(long paramLong)
    throws IOException
  {
    this.b.setConnectionTimeout((int)paramLong);
  }
  
  public boolean isClosed()
  {
    return false;
  }
  
  public a openConnection()
    throws IOException
  {
    ConnectionClient localConnectionClient = this.a.createConnectionClient(this.b, this.c);
    this.d.execute(localConnectionClient);
    Channel localChannel = this.d.getChannel();
    localChannel.getIncomingWindow().setMinWindowSize(getConnectionParameters().getMinIncomingWindowSize());
    localChannel.getIncomingWindow().setMaxWindowSize(getConnectionParameters().getMaxIncomingWindowSize());
    return new SshConnection(localConnectionClient, localChannel, true);
  }
  
  public void close() {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.SshStandaloneConnector
 * JD-Core Version:    0.7.0.1
 */