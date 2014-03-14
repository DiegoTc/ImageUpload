package com.jscape.inet.ftp;

public class FtpChangeDirEvent
  extends FtpEvent
{
  private String b;
  private static final String z = -1;
  
  public FtpChangeDirEvent(Object paramObject, String paramString)
  {
    super(paramObject);
    this.b = paramString;
  }
  
  public void accept(FtpListener paramFtpListener)
  {
    if ((FtpEvent.a) || (paramFtpListener != null)) {
      paramFtpListener.changeDir(this);
    }
  }
  
  public String getDirectory()
  {
    return this.b;
  }
  
  public String toString()
  {
    return z + this.b;
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpChangeDirEvent
 * JD-Core Version:    0.7.0.1
 */