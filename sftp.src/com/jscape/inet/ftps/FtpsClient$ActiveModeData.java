package com.jscape.inet.ftps;

class FtpsClient$ActiveModeData
{
  private String a = null;
  private String b = null;
  final FtpsClient c;
  
  public FtpsClient$ActiveModeData(FtpsClient paramFtpsClient, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getHostname()
  {
    return this.a;
  }
  
  public String getCommandData()
  {
    return this.b;
  }
  
  public boolean isEPRTRequired()
  {
    return getCommandData().startsWith("|");
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FtpsClient.ActiveModeData
 * JD-Core Version:    0.7.0.1
 */