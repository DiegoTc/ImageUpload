package com.jscape.inet.ftp;

import com.jscape.util.qb;
import java.io.IOException;
import java.io.OutputStream;

final class FtpBaseImplementation$DataConnectionOutputStream
  extends OutputStream
{
  private final FtpBaseImplementation a;
  private final FtpConnection b;
  private final OutputStream c;
  
  public FtpBaseImplementation$DataConnectionOutputStream(FtpBaseImplementation paramFtpBaseImplementation, FtpConnection paramFtpConnection)
    throws FtpException
  {
    this.a = paramFtpBaseImplementation;
    this.b = paramFtpConnection;
    this.c = this.b.getOutputStream();
  }
  
  public void close()
    throws IOException
  {
    qb.a(this.c);
    this.b.close();
    try
    {
      this.a.readResponse();
    }
    catch (FtpException localFtpException) {}
  }
  
  public void flush()
    throws IOException
  {
    this.c.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.c.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.c.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.c.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpBaseImplementation.DataConnectionOutputStream
 * JD-Core Version:    0.7.0.1
 */