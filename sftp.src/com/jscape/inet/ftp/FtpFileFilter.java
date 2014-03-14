package com.jscape.inet.ftp;

import java.util.Vector;

public class FtpFileFilter
{
  private static final String a = "*";
  private final String b;
  
  public FtpFileFilter(String paramString)
  {
    if (!FtpEvent.a) {}
    this.b = (paramString.length() != 0 ? paramString : "*");
  }
  
  public Vector applyTo(Vector paramVector)
  {
    boolean bool = FtpEvent.a;
    Vector localVector = new Vector();
    int i = 0;
    do
    {
      if (i >= paramVector.size()) {
        break;
      }
      if (bool) {
        break label70;
      }
      FtpFile localFtpFile = (FtpFile)paramVector.elementAt(i);
      if (!bool)
      {
        if (a(localFtpFile.getFilename())) {
          localVector.addElement(localFtpFile);
        }
        i++;
      }
    } while (!bool);
    label70:
    return localVector;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = FtpEvent.a;
    int i = this.b.indexOf("*");
    if (!bool) {
      if (i != -1)
      {
        String str1 = this.b.substring(0, i);
        String str2 = this.b.substring(i + "*".length());
        if ((bool) || (paramString.startsWith(str1))) {
          if (bool) {}
        }
        return paramString.endsWith(str2);
      }
    }
    return paramString.equals(this.b);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpFileFilter
 * JD-Core Version:    0.7.0.1
 */