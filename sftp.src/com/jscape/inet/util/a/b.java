package com.jscape.inet.util.a;

import java.io.IOException;

public abstract interface b
{
  public abstract String getAddress();
  
  public abstract int getPort();
  
  public abstract long getTimeout()
    throws IOException;
  
  public abstract void setTimeout(long paramLong)
    throws IOException;
  
  public abstract a openConnection()
    throws IOException;
  
  public abstract void close();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.a.b
 * JD-Core Version:    0.7.0.1
 */