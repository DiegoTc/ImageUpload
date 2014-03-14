package com.jscape.inet.ftp;

public class FtpResponseEvent
  extends FtpEvent
{
  private String b;
  
  public FtpResponseEvent(Object paramObject, String paramString)
  {
    super(paramObject);
    this.b = paramString;
  }
  
  public String getResponse()
  {
    return this.b;
  }
  
  public void accept(FtpListener paramFtpListener)
  {
    if ((FtpEvent.a) || (paramFtpListener != null)) {
      paramFtpListener.responseReceived(this);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpResponseEvent
 * JD-Core Version:    0.7.0.1
 */