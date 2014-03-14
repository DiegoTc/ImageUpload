package com.jscape.inet.scp.events;

import com.jscape.inet.scp.Scp;
import com.jscape.util.u;

public abstract class ScpEvent
{
  private Scp a;
  public static boolean b;
  
  protected ScpEvent(Scp paramScp)
  {
    u.a(paramScp);
    this.a = paramScp;
  }
  
  public Scp getSource()
  {
    return this.a;
  }
  
  public abstract void accept(ScpEventListener paramScpEventListener);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.events.ScpEvent
 * JD-Core Version:    0.7.0.1
 */