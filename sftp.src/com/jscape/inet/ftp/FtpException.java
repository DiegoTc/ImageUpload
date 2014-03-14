package com.jscape.inet.ftp;

import com.jscape.util.ExceptionWrapper;

public class FtpException
  extends Exception
  implements ExceptionWrapper
{
  protected final Exception exception;
  
  public FtpException(String paramString)
  {
    this(paramString, null);
  }
  
  public FtpException(String paramString, Exception paramException)
  {
    super(paramString);
    this.exception = paramException;
  }
  
  public FtpException(Exception paramException)
  {
    this(paramException.getMessage(), paramException);
  }
  
  public Exception getException()
  {
    return this.exception;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpException
 * JD-Core Version:    0.7.0.1
 */