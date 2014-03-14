package com.jscape.inet.ftp;

import com.jscape.util.u;

public abstract class AbstractRequest
{
  private static final String z = -1;
  
  public abstract boolean isValid();
  
  public abstract void execute(ClientProtocolInterpreter paramClientProtocolInterpreter)
    throws FtpException;
  
  protected void assertIsPositive(String paramString)
    throws FtpException
  {
    if ((FtpEvent.a) || ((paramString.startsWith("4")) || (paramString.startsWith("5")))) {
      throw new FtpException(paramString);
    }
  }
  
  protected void assertIsValid()
  {
    u.c(isValid(), z);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.AbstractRequest
 * JD-Core Version:    0.7.0.1
 */