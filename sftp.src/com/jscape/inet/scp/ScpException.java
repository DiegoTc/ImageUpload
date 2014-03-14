package com.jscape.inet.scp;

import java.io.IOException;

public class ScpException
  extends IOException
{
  public ScpException() {}
  
  public ScpException(String paramString)
  {
    super(paramString);
  }
  
  public ScpException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ScpException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.ScpException
 * JD-Core Version:    0.7.0.1
 */