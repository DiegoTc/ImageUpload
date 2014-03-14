package com.jscape.inet.ftp;

public class FtpDisconnectedEvent
  extends FtpEvent
{
  private String b;
  private static final String z = -1;
  
  public FtpDisconnectedEvent(Object paramObject, String paramString)
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
      paramFtpListener.disconnected(this);
    }
  }
  
  public String toString()
  {
    return z + this.b;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpDisconnectedEvent
 * JD-Core Version:    0.7.0.1
 */