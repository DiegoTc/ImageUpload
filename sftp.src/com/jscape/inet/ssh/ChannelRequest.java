package com.jscape.inet.ssh;

import com.jscape.inet.ssh.connection.ConnectionClient;
import com.jscape.inet.ssh.connection.channels.Channel;
import java.io.IOException;

public abstract interface ChannelRequest
{
  public static final int DEFAULT_WINDOW_SIZE = 2097152;
  public static final int DEFAULT_PACKET_SIZE = 32768;
  
  public abstract long getWindowSize();
  
  public abstract int getPacketSize();
  
  public abstract void execute(ConnectionClient paramConnectionClient)
    throws IOException;
  
  public abstract Channel getChannel();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.ChannelRequest
 * JD-Core Version:    0.7.0.1
 */