package com.jscape.inet.sftp;

import java.io.IOException;

public class SftpException
  extends IOException
{
  public static SftpException wrap(Throwable paramThrowable)
  {
    return (SftpPacket.c) || ((paramThrowable instanceof SftpException)) ? (SftpException)paramThrowable : new SftpException(paramThrowable);
  }
  
  public SftpException(String paramString)
  {
    super(paramString);
  }
  
  public SftpException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public SftpException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.SftpException
 * JD-Core Version:    0.7.0.1
 */