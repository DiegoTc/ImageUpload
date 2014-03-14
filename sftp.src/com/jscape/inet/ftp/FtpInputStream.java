package com.jscape.inet.ftp;

import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;

public class FtpInputStream
  extends InputStream
{
  private Ftp a;
  private boolean b;
  private InputStream c;
  
  public FtpInputStream(Ftp paramFtp, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong)
    throws IOException, FtpException
  {
    this.a = paramFtp;
    if (!FtpEvent.a)
    {
      if (paramBoolean1) {
        this.a.connect();
      }
      this.c = this.a.getInputStream(paramString, paramLong);
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
  {
    qb.a(this.c);
    if ((FtpEvent.a) || (this.b)) {
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
 * Qualified Name:     com.jscape.inet.ftp.FtpInputStream
 * JD-Core Version:    0.7.0.1
 */