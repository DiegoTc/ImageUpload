package com.jscape.inet.ftp;

import com.jscape.util.qb;
import java.io.IOException;
import java.io.OutputStream;

public class FtpOutputStream
  extends OutputStream
{
  private boolean a;
  private OutputStream b;
  private Ftp c;
  
  public FtpOutputStream(Ftp paramFtp, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong, boolean paramBoolean3)
    throws FtpException, IOException
  {
    this.c = paramFtp;
    this.a = paramBoolean2;
    if (!FtpEvent.a)
    {
      if (paramBoolean1) {
        this.c.connect();
      }
      this.b = paramFtp.getOutputStream(paramString, paramLong, paramBoolean3);
    }
  }
  
  public void close()
  {
    qb.a(this.b);
    if ((FtpEvent.a) || (this.a)) {
      this.c.disconnect();
    }
  }
  
  public void flush()
    throws IOException
  {
    this.b.flush();
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
  
  public void write(int paramInt)
    throws IOException
  {
    this.b.write(paramInt);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpOutputStream
 * JD-Core Version:    0.7.0.1
 */