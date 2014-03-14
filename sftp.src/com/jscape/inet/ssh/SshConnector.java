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

public class SshConnector
  implements b
{
  private SshConfiguration a;
  private ConnectionParameters b;
  private User c;
  private ChannelRequest d;
  private ConnectionClient e;
  
  public SshConnector(SshConfiguration paramSshConfiguration, ConnectionParameters paramConnectionParameters, User paramUser, ChannelRequest paramChannelRequest)
    throws IOException
  {
    u.a(paramSshConfiguration);
    u.a(paramConnectionParameters);
    u.a(paramUser);
    u.a(paramChannelRequest);
    this.a = paramSshConfiguration;
    this.b = new ConnectionParameters(paramConnectionParameters);
    this.c = new User(paramUser);
    this.d = paramChannelRequest;
    this.e = this.a.createConnectionClient(this.b, this.c);
  }
  
  public SshConfiguration getConfiguration()
  {
    return this.a;
  }
  
  public ConnectionParameters getConnectionParameters()
  {
    return new ConnectionParameters(this.b);
  }
  
  public User getUser()
  {
    return new User(this.c);
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
    return this.e.isClosed();
  }
  
  public a openConnection()
    throws IOException
  {
    this.d.execute(this.e);
    Channel localChannel = this.d.getChannel();
    localChannel.getIncomingWindow().setMinWindowSize(getConnectionParameters().getMinIncomingWindowSize());
    localChannel.getIncomingWindow().setMaxWindowSize(getConnectionParameters().getMaxIncomingWindowSize());
    return new SshConnection(this.e, localChannel, false);
  }
  
  public void close()
  {
    this.e.close();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.SshConnector
 * JD-Core Version:    0.7.0.1
 */