package com.jscape.inet.ssh.transport.keyformat;

import com.jscape.inet.ssh.transport.TransportException;

public class KeyFormatException
  extends TransportException
{
  public KeyFormatException() {}
  
  public KeyFormatException(String paramString)
  {
    super(paramString);
  }
  
  public KeyFormatException(Exception paramException)
  {
    super(paramException);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.keyformat.KeyFormatException
 * JD-Core Version:    0.7.0.1
 */