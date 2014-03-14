package com.jscape.inet.ftps;

import java.net.InetAddress;

class FtpsClient$AsyncReverseDNSLookup
  extends Thread
{
  private String a;
  private boolean b;
  final FtpsClient c;
  
  public FtpsClient$AsyncReverseDNSLookup(FtpsClient paramFtpsClient, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    try
    {
      this.a = InetAddress.getByName(this.a).getHostAddress();
      this.b = true;
    }
    catch (Exception localException)
    {
      this.b = false;
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
 * Qualified Name:     com.jscape.inet.ftps.FtpsClient.AsyncReverseDNSLookup
 * JD-Core Version:    0.7.0.1
 */