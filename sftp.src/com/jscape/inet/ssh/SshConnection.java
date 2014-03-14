package com.jscape.inet.ssh;

import com.jscape.inet.ssh.connection.ConnectionClient;
import com.jscape.inet.ssh.connection.channels.Channel;
import com.jscape.inet.ssh.transport.Transport;
import com.jscape.inet.util.a.a;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SshConnection
  implements a
{
  private ConnectionClient a;
  private Channel b;
  private boolean c;
  
  public SshConnection(ConnectionClient paramConnectionClient, Channel paramChannel, boolean paramBoolean)
  {
    u.a(paramConnectionClient);
    u.a(paramChannel);
    this.a = paramConnectionClient;
    this.b = paramChannel;
    this.c = paramBoolean;
  }
  
  public String getRemoteAddress()
  {
    return this.a.getTransport().getSocket().getInetAddress().getHostAddress();
  }
  
  public int getRemotePort()
  {
    return this.a.getTransport().getSocket().getPort();
  }
  
  public String getLocalAddress()
  {
    return this.a.getTransport().getSocket().getLocalAddress().getHostAddress();
  }
  
  public int getLocalPort()
  {
    return this.a.getTransport().getSocket().getLocalPort();
  }
  
  public long getTimeout()
    throws IOException
  {
    return this.a.getTransport().getSocket().getSoTimeout();
  }
  
  public void setTimeout(long paramLong)
    throws IOException
  {
    this.a.getTransport().getSocket().setSoTimeout((int)paramLong);
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.b.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.b.getOutputStream();
  }
  
  public boolean isClosed()
  {
    return this.b.isClosed();
  }
  
  public ConnectionClient getConnection()
  {
    return this.a;
  }
  
  public Channel getChannel()
  {
    return this.b;
  }
  
  public boolean isOwner()
  {
    return this.c;
  }
  
  public void close()
  {
    this.b.close();
    if ((SshWriter.c) || (this.c)) {
      this.a.close();
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.SshConnection
 * JD-Core Version:    0.7.0.1
 */