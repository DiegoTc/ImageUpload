package com.jscape.inet.util.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface a
{
  public abstract String getRemoteAddress();
  
  public abstract int getRemotePort();
  
  public abstract String getLocalAddress();
  
  public abstract int getLocalPort();
  
  public abstract long getTimeout()
    throws IOException;
  
  public abstract void setTimeout(long paramLong)
    throws IOException;
  
  public abstract InputStream getInputStream()
    throws IOException;
  
  public abstract OutputStream getOutputStream()
    throws IOException;
  
  public abstract void close();
  
  public abstract boolean isClosed();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.a.a
 * JD-Core Version:    0.7.0.1
 */