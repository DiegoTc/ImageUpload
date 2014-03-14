package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.OutputStream;

public class FtpsOutputStream
  extends OutputStream
{
  private OutputStream a;
  private boolean b;
  private Ftps c;
  
  public FtpsOutputStream(Ftps paramFtps, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong, boolean paramBoolean3)
    throws FtpException, IOException
  {
    this.c = paramFtps;
    this.b = paramBoolean2;
    if (Ftps.kb == 0)
    {
      if (paramBoolean1) {
        this.c.connect();
      }
      this.a = paramFtps.getOutputStream(paramString, paramLong, paramBoolean3);
    }
  }
  
  public void close()
    throws IOException
  {
    qb.a(this.a);
    try
    {
      this.c.readResponse();
    }
    catch (FtpException localFtpException) {}
    if ((Ftps.kb != 0) || (this.b)) {
      this.c.disconnect();
    }
  }
  
  public void flush()
    throws IOException
  {
    this.a.flush();
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FtpsOutputStream
 * JD-Core Version:    0.7.0.1
 */