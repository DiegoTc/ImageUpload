package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.inet.ftp.FtpProgressEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.SSLHandshakeException;

class Ftps$BinaryMode
  extends Ftps.TransferMode
{
  final Ftps c;
  
  public Ftps$BinaryMode(Ftps paramFtps)
  {
    super(paramFtps, 2, null);
  }
  
  public long transmit(InputStream paramInputStream, OutputStream paramOutputStream, String paramString, int paramInt, long paramLong1, long paramLong2)
    throws FtpException
  {
    int j = Ftps.kb;
    byte[] arrayOfByte = new byte[Ftps.b(this.c)];
    long l = 0L;
    try
    {
      String str = "";
      if ((j != 0) || (Ftps.c(this.c) != null)) {
        str = Ftps.c(this.c).getAbsolutePath();
      }
      if (j == 0) {
        if (paramLong1 == 0L) {
          this.c.fireEvent(new FtpProgressEvent(this.c, paramString, Ftps.d(this.c), str, paramInt, l + paramLong2, 0L, paramLong1));
        }
      }
      int i = paramInputStream.read(arrayOfByte);
      do
      {
        if (i == -1) {
          break;
        }
        if (j == 0)
        {
          if (this.c.interrupted()) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
          paramOutputStream.flush();
          l += i;
          this.c.fireEvent(new FtpProgressEvent(this.c, paramString, Ftps.d(this.c), str, paramInt, l + paramLong2, i, paramLong1));
        }
        i = paramInputStream.read(arrayOfByte);
      } while (j == 0);
      return l;
    }
    catch (IOException localIOException)
    {
      if ((localIOException instanceof SSLHandshakeException)) {
        return 0L;
      }
      throw new FtpException(localIOException.getMessage(), localIOException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.BinaryMode
 * JD-Core Version:    0.7.0.1
 */