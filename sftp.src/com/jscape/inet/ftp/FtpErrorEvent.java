package com.jscape.inet.ftp;

public class FtpErrorEvent
  extends FtpEvent
{
  private final String b;
  private final String c;
  private final String d;
  private final int e;
  private static final String z = -1;
  
  public FtpErrorEvent(Object paramObject, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramObject);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramInt;
  }
  
  public String getFilename()
  {
    return this.b;
  }
  
  public String getPath()
  {
    return this.c;
  }
  
  public String getLocalPath()
  {
    return this.d;
  }
  
  public long getMode()
  {
    return this.e;
  }
  
  public void accept(FtpListener paramFtpListener) {}
  
  public String toString()
  {
    return String.format(z, new Object[] { this.b, this.c, this.d, Integer.valueOf(this.e) });
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpErrorEvent
 * JD-Core Version:    0.7.0.1
 */