package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

final class Ftps$DataConnectionOutputStream
  extends OutputStream
{
  private final Ftps a;
  private final OutputStream b;
  private final Socket c;
  
  public Ftps$DataConnectionOutputStream(Ftps paramFtps, Socket paramSocket)
    throws IOException
  {
    this.a = paramFtps;
    this.c = paramSocket;
    this.b = this.c.getOutputStream();
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
  
  public void flush()
    throws IOException
  {
    this.b.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.b.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.b.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.b.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.DataConnectionOutputStream
 * JD-Core Version:    0.7.0.1
 */