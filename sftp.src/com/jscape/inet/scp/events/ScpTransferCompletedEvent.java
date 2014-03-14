package com.jscape.inet.scp.events;

import com.jscape.inet.scp.Scp;
import com.jscape.util.u;

public abstract class ScpTransferCompletedEvent
  extends ScpEvent
{
  private String c;
  private long d;
  private long e;
  
  protected ScpTransferCompletedEvent(Scp paramScp, String paramString, long paramLong1, long paramLong2)
  {
    super(paramScp);
    u.a(paramString);
    this.c = paramString;
    this.d = paramLong1;
    this.e = paramLong2;
    if (u.a) {
      ScpEvent.b = !bool;
    }
  }
  
  public String getFilename()
  {
    return this.c;
  }
  
  public long getSize()
  {
    return this.d;
  }
  
  public long getTime()
  {
    return this.e;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.events.ScpTransferCompletedEvent
 * JD-Core Version:    0.7.0.1
 */