package com.jscape.inet.scp.events;

import com.jscape.inet.scp.Scp;
import com.jscape.util.u;

public final class ScpConnectedEvent
  extends ScpEvent
{
  private String c;
  private int d;
  
  public ScpConnectedEvent(Scp paramScp, String paramString, int paramInt)
  {
    super(paramScp);
    u.a(paramString);
    this.c = paramString;
    this.d = paramInt;
  }
  
  public String getHost()
  {
    return this.c;
  }
  
  public int getPort()
  {
    return this.d;
  }
  
  public void accept(ScpEventListener paramScpEventListener)
  {
    paramScpEventListener.connected(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.events.ScpConnectedEvent
 * JD-Core Version:    0.7.0.1
 */