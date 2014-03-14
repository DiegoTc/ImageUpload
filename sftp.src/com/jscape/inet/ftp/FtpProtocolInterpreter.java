package com.jscape.inet.ftp;

import com.jscape.util.u;

final class FtpProtocolInterpreter
  implements ClientProtocolInterpreter
{
  private FtpBaseImplementation a;
  
  public FtpProtocolInterpreter(FtpBaseImplementation paramFtpBaseImplementation)
  {
    u.a(paramFtpBaseImplementation);
    this.a = paramFtpBaseImplementation;
  }
  
  public FtpBaseImplementation getImplementation()
  {
    return this.a;
  }
  
  public void sendCommand(String paramString)
    throws FtpException
  {
    this.a.sendCommand(paramString);
  }
  
  public String receiveReply()
    throws FtpException
  {
    this.a.readResponse();
    return this.a.getResponse();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpProtocolInterpreter
 * JD-Core Version:    0.7.0.1
 */