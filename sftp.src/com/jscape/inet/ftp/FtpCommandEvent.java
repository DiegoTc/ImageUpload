package com.jscape.inet.ftp;

public class FtpCommandEvent
  extends FtpEvent
{
  private String b;
  
  public FtpCommandEvent(Object paramObject, String paramString)
  {
    super(paramObject);
    this.b = paramString;
  }
  
  public String getCommand()
  {
    return this.b;
  }
  
  public void accept(FtpListener paramFtpListener)
  {
    if ((FtpEvent.a) || (paramFtpListener != null)) {
      paramFtpListener.commandSent(this);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpCommandEvent
 * JD-Core Version:    0.7.0.1
 */