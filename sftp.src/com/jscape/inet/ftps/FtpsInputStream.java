package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;

public class FtpsInputStream
  extends InputStream
{
  private Ftps a;
  private boolean b;
  private InputStream c;
  
  public FtpsInputStream(Ftps paramFtps, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong)
    throws IOException, FtpException
  {
    this.a = paramFtps;
    if (Ftps.kb == 0)
    {
      if (paramBoolean1) {
        this.a.connect();
      }
      this.c = paramFtps.getInputStream(paramString, paramLong);
      this.b = paramBoolean2;
    }
  }
  
  public int read()
    throws IOException
  {
    return this.c.read();
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
  
  public void close()
    throws IOException
  {
    qb.a(this.c);
    try
    {
      this.a.readResponse();
    }
    catch (FtpException localFtpException) {}
    if ((Ftps.kb != 0) || (this.b)) {
      this.a.disconnect();
    }
  }
  
  public synchronized int available()
    throws IOException
  {
    return this.c.available();
  }
  
  public synchronized long skip(long paramLong)
    throws IOException
  {
    return this.c.skip(paramLong);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FtpsInputStream
 * JD-Core Version:    0.7.0.1
 */