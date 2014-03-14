package com.jscape.inet.ssh.connection.channels;

import com.jscape.inet.ssh.connection.Connection;
import com.jscape.inet.util.ConnectionParameters;

public class X11Client
  extends Channel
{
  protected static Channel.Parameters open(long paramLong1, long paramLong2, long paramLong3, ConnectionParameters paramConnectionParameters, Connection paramConnection)
  {
    return null;
  }
  
  public X11Client(long paramLong1, long paramLong2, long paramLong3, ConnectionParameters paramConnectionParameters, Connection paramConnection)
  {
    super(open(paramLong1, paramLong2, paramLong3, paramConnectionParameters, paramConnection), paramConnection);
    this.connection.addChannel(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.channels.X11Client
 * JD-Core Version:    0.7.0.1
 */