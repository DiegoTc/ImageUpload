package com.jscape.inet.ssh.connection;

import java.io.IOException;

public class ConnectionException
  extends IOException
{
  private Exception a;
  
  public ConnectionException() {}
  
  public ConnectionException(String paramString)
  {
    super(paramString);
  }
  
  public ConnectionException(Exception paramException)
  {
    this(paramException.getMessage());
    this.a = paramException;
  }
  
  public Exception getReason()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.ConnectionException
 * JD-Core Version:    0.7.0.1
 */