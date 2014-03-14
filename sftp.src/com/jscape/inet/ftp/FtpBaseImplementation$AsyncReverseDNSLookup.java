package com.jscape.inet.ftp;

import java.net.InetAddress;

class FtpBaseImplementation$AsyncReverseDNSLookup
  extends Thread
{
  private String a = null;
  private boolean b = false;
  final FtpBaseImplementation c;
  
  public FtpBaseImplementation$AsyncReverseDNSLookup(FtpBaseImplementation paramFtpBaseImplementation, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    boolean bool = FtpEvent.a;
    int i = 0;
    try
    {
      this.a = InetAddress.getByName(this.a).getHostAddress();
      if (bool) {}
    }
    catch (Exception localException)
    {
      i = 1;
      this.b = false;
      if (bool) {}
    }
    finally
    {
      if (i == 0) {
        this.b = true;
      }
    }
  }
  
  static boolean a(AsyncReverseDNSLookup paramAsyncReverseDNSLookup)
  {
    return paramAsyncReverseDNSLookup.b;
  }
  
  static String b(AsyncReverseDNSLookup paramAsyncReverseDNSLookup)
  {
    return paramAsyncReverseDNSLookup.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpBaseImplementation.AsyncReverseDNSLookup
 * JD-Core Version:    0.7.0.1
 */