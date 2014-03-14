package com.jscape.inet.ftp;

public class FtpConnectionLostEvent
  extends FtpEvent
{
  private String b;
  
  public FtpConnectionLostEvent(Object paramObject, String paramString)
  {
    super(paramObject);
    this.b = paramString;
  }
  
  public String getHostname()
  {
    return this.b;
  }
  
  public void accept(FtpListener paramFtpListener)
  {
    if ((FtpEvent.a) || (paramFtpListener != null)) {
      paramFtpListener.connectionLost(this);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpConnectionLostEvent
 * JD-Core Version:    0.7.0.1
 */