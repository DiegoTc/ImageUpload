package com.jscape.inet.ftp;

public class FxpRetr
  extends Thread
{
  private Fxp a;
  private Ftp b;
  private Ftp c;
  private String d;
  private static final String z = -1;
  
  public FxpRetr(Fxp paramFxp, Ftp paramFtp1, Ftp paramFtp2, String paramString)
  {
    this.a = paramFxp;
    this.b = paramFtp1;
    this.c = paramFtp2;
    this.d = paramString;
  }
  
  public void run()
  {
    try
    {
      this.b.issueCommand(z + this.d);
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
 * Qualified Name:     com.jscape.inet.ftp.FxpRetr
 * JD-Core Version:    0.7.0.1
 */