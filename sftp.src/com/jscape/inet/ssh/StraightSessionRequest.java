package com.jscape.inet.ssh;

import com.jscape.inet.ssh.connection.ConnectionClient;
import com.jscape.inet.ssh.connection.ConnectionException;
import com.jscape.util.u;
import java.io.IOException;

public final class StraightSessionRequest
  extends SessionRequest
{
  public StraightSessionRequest(long paramLong, int paramInt)
  {
    super(paramLong, paramInt);
  }
  
  public StraightSessionRequest() {}
  
  public synchronized void execute(ConnectionClient paramConnectionClient)
    throws IOException, ConnectionException
  {
    u.a(paramConnectionClient);
    this.channel = paramConnectionClient.openSession(this.windowSize, this.packetSize);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.StraightSessionRequest
 * JD-Core Version:    0.7.0.1
 */