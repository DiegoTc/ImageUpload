package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class Ftps$TransferMode
{
  private final int a;
  final Ftps b;
  
  private Ftps$TransferMode(Ftps paramFtps, int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public abstract long transmit(InputStream paramInputStream, OutputStream paramOutputStream, String paramString, int paramInt, long paramLong1, long paramLong2)
    throws FtpException;
  
  Ftps$TransferMode(Ftps paramFtps, int paramInt, Ftps.1 param1)
  {
    this(paramFtps, paramInt);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.TransferMode
 * JD-Core Version:    0.7.0.1
 */