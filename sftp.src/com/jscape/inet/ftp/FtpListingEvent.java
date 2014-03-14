package com.jscape.inet.ftp;

import java.util.Enumeration;

public class FtpListingEvent
  extends FtpEvent
{
  private Enumeration b;
  
  public FtpListingEvent(Object paramObject, Enumeration paramEnumeration)
  {
    super(paramObject);
    this.b = paramEnumeration;
  }
  
  public Enumeration getListing()
  {
    return this.b;
  }
  
  public void accept(FtpListener paramFtpListener)
  {
    if ((FtpEvent.a) || (paramFtpListener != null)) {
      paramFtpListener.listing(this);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpListingEvent
 * JD-Core Version:    0.7.0.1
 */