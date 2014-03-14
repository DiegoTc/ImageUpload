package com.jscape.inet.ssh;

import com.jscape.inet.ssh.connection.ConnectionClient;
import com.jscape.inet.ssh.connection.channels.Channel.Parameters;
import com.jscape.inet.ssh.connection.channels.SessionClient;
import com.jscape.util.u;
import java.io.IOException;

public class AdaptiveSessionRequest
  extends SessionRequest
{
  public AdaptiveSessionRequest(long paramLong, int paramInt)
  {
    super(paramLong, paramInt);
  }
  
  public AdaptiveSessionRequest() {}
  
  public synchronized void execute(ConnectionClient paramConnectionClient)
    throws IOException
  {
    u.a(paramConnectionClient);
    this.channel = null;
    SessionClient localSessionClient = paramConnectionClient.openSession(this.windowSize, this.packetSize);
    long l = localSessionClient.getParameters().getRemotePacketSize();
    if (!SshWriter.c)
    {
      if (l != localSessionClient.getParameters().getLocalPacketSize())
      {
        localSessionClient.close();
        localSessionClient = paramConnectionClient.openSession(this.windowSize, (int)l);
      }
      this.channel = localSessionClient;
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.AdaptiveSessionRequest
 * JD-Core Version:    0.7.0.1
 */