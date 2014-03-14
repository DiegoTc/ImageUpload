package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

final class Ftps$DataConnectionInputStream
  extends InputStream
{
  private final Ftps a;
  private final InputStream b;
  private final Socket c;
  
  public Ftps$DataConnectionInputStream(Ftps paramFtps, Socket paramSocket)
    throws IOException
  {
    this.a = paramFtps;
    this.c = paramSocket;
    this.b = this.c.getInputStream();
  }
  
  public int available()
    throws IOException
  {
    return this.b.available();
  }
  
  public void close()
    throws IOException
  {
    qb.a(this.b);
    qb.a(this.c);
    try
    {
      this.a.readResponse();
    }
    catch (FtpException localFtpException) {}
  }
  
  public void mark(int paramInt)
  {
    this.b.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.b.markSupported();
  }
  
  public int read()
    throws IOException
  {
    return this.b.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.b.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.b.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
    throws IOException
  {
    this.b.reset();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.b.skip(paramLong);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.DataConnectionInputStream
 * JD-Core Version:    0.7.0.1
 */