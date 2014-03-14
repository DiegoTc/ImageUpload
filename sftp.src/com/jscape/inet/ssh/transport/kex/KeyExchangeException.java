package com.jscape.inet.ssh.transport.kex;

import com.jscape.inet.ssh.transport.TransportException;

public class KeyExchangeException
  extends TransportException
{
  public KeyExchangeException() {}
  
  public KeyExchangeException(String paramString)
  {
    super(paramString);
  }
  
  public KeyExchangeException(Exception paramException)
  {
    super(paramException);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.kex.KeyExchangeException
 * JD-Core Version:    0.7.0.1
 */