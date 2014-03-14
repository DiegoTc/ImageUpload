package com.jscape.inet.sftp.events;

import com.jscape.inet.sftp.Sftp;
import com.jscape.util.u;
import java.util.Enumeration;

public class SftpListingEvent
  extends SftpEvent
{
  private final Enumeration c;
  
  public SftpListingEvent(Sftp paramSftp, Enumeration paramEnumeration)
  {
    super(paramSftp);
    u.a(paramEnumeration);
    this.c = paramEnumeration;
  }
  
  public Enumeration getFiles()
  {
    return this.c;
  }
  
  public void acceptListener(SftpListener paramSftpListener)
  {
    paramSftpListener.dirListing(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.events.SftpListingEvent
 * JD-Core Version:    0.7.0.1
 */