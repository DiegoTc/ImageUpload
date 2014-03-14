package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import com.jscape.inet.util.l;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

class FtpsClient$ActiveConnector
  implements FtpsClient.DataConnector
{
  private final ServerSocket a;
  final FtpsClient b;
  
  public FtpsClient$ActiveConnector(FtpsClient paramFtpsClient, int paramInt1, int paramInt2, boolean paramBoolean, SSLContext paramSSLContext)
    throws FtpException
  {
    try
    {
      if (i == 0)
      {
        if (!paramBoolean)
        {
          this.a = l.a(paramInt1, paramInt2);
          if (i == 0) {}
        }
        else
        {
          this.a = l.a(paramSSLContext.getServerSocketFactory(), paramInt1, paramInt2);
        }
      }
      else {
        ((SSLServerSocket)this.a).setUseClientMode(true);
      }
      b();
    }
    catch (Exception localException)
    {
      throw new FtpException(localException.getMessage(), localException);
    }
  }
  
  private void b()
    throws FtpException
  {
    try
    {
      this.a.setSoTimeout(FtpsClient.d(this.b).getTimeout());
    }
    catch (Exception localException)
    {
      throw new FtpException(localException.getMessage(), localException);
    }
  }
  
  public Socket openConnection(String paramString)
    throws FtpException
  {
    this.b.sendCommand(paramString);
    try
    {
      Socket localSocket1 = this.a.accept();
      if (Ftps.kb == 0) {
        if ((localSocket1 instanceof SSLSocket)) {
          ((SSLSocket)localSocket1).startHandshake();
        }
      }
      Socket localSocket2 = localSocket1;
      return localSocket2;
    }
    catch (Exception localException)
    {
      throw new FtpException(localException.getMessage(), localException);
    }
    finally
    {
      this.b.readResponse();
    }
  }
  
  public int getLocalPort()
  {
    return this.a.getLocalPort();
  }
  
  public void close()
  {
    try
    {
      this.a.close();
    }
    catch (Exception localException) {}
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FtpsClient.ActiveConnector
 * JD-Core Version:    0.7.0.1
 */