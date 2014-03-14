package com.jscape.inet.ftp;

import java.util.EventObject;

public abstract class FtpEvent
  extends EventObject
{
  public static boolean a;
  
  protected FtpEvent(Object paramObject)
  {
    super(paramObject);
  }
  
  public abstract void accept(FtpListener paramFtpListener);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpEvent
 * JD-Core Version:    0.7.0.1
 */