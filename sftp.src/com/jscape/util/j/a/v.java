package com.jscape.util.j.a;

import com.jscape.util.j.n;
import java.util.Map;

public abstract interface v
{
  public abstract long creationTime();
  
  public abstract n localAddress();
  
  public abstract n remoteAddress();
  
  public abstract Map<Object, Object> attributes();
  
  public abstract boolean closed();
  
  public abstract void close();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.v
 * JD-Core Version:    0.7.0.1
 */