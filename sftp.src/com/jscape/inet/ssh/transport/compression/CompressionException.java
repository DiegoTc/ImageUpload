package com.jscape.inet.ssh.transport.compression;

import com.jscape.inet.ssh.transport.TransportException;

public class CompressionException
  extends TransportException
{
  public CompressionException() {}
  
  public CompressionException(String paramString)
  {
    super(paramString);
  }
  
  public CompressionException(Exception paramException)
  {
    super(paramException);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.compression.CompressionException
 * JD-Core Version:    0.7.0.1
 */