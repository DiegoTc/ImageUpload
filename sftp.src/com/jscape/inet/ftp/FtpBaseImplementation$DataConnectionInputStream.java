package com.jscape.inet.ftp;

import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;

class FtpBaseImplementation$DataConnectionInputStream
  extends InputStream
{
  private final FtpBaseImplementation a;
  private final FtpConnection b;
  private final InputStream c;
  
  public FtpBaseImplementation$DataConnectionInputStream(FtpBaseImplementation paramFtpBaseImplementation, FtpConnection paramFtpConnection)
    throws FtpException
  {
    this.a = paramFtpBaseImplementation;
    this.b = paramFtpConnection;
    this.c = this.b.getInputStream();
  }
  
  public int available()
    throws IOException
  {
    return this.c.available();
  }
  
  public int read()
    throws IOException
  {
    return this.c.read();
  }
  
  public void close()
  {
    qb.a(this.c);
    this.b.close();
    try
    {
      this.a.readResponse();
    }
    catch (FtpException localFtpException) {}
  }
  
  public void reset()
    throws IOException
  {
    this.c.reset();
  }
  
  public boolean markSupported()
  {
    return this.c.markSupported();
  }
  
  public void mark(int paramInt)
  {
    this.c.mark(paramInt);
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.c.skip(paramLong);
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.c.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.c.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpBaseImplementation.DataConnectionInputStream
 * JD-Core Version:    0.7.0.1
 */