package com.jscape.inet.ftps;

public class FxpsStor
  extends Thread
{
  private Fxps a;
  private Ftps b;
  private Ftps c;
  private String d;
  private static final String z = -1;
  
  public FxpsStor(Fxps paramFxps, Ftps paramFtps1, Ftps paramFtps2, String paramString)
  {
    this.a = paramFxps;
    this.b = paramFtps1;
    this.c = paramFtps2;
    this.d = paramString;
  }
  
  public void run()
  {
    try
    {
      this.c.issueCommand(z + this.d);
      this.c.readResponse();
    }
    catch (Exception localException)
    {
      this.a.fireFxpFailed(this.b, this.c, this.d, localException);
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.FxpsStor
 * JD-Core Version:    0.7.0.1
 */