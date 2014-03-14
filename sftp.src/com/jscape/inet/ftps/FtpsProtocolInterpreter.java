package com.jscape.inet.ftps;

import com.jscape.inet.ftp.ClientProtocolInterpreter;
import com.jscape.inet.ftp.FtpException;
import com.jscape.util.u;

final class FtpsProtocolInterpreter
  implements ClientProtocolInterpreter
{
  private FtpsClient a;
  
  public FtpsProtocolInterpreter(FtpsClient paramFtpsClient)
  {
    u.a(paramFtpsClient);
    this.a = paramFtpsClient;
  }
  
  public void sendCommand(String paramString)
    throws FtpException
  {
    this.a.sendCommand(paramString);
  }
  
  public String receiveReply()
    throws FtpException
  {
    return this.a.readResponse().toString();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FtpsProtocolInterpreter
 * JD-Core Version:    0.7.0.1
 */