package com.jscape.inet.ftp;

import java.io.Serializable;

public class FtpFile
  implements Serializable
{
  private String a;
  private long b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private boolean h;
  private boolean i;
  private String j;
  private int k;
  private FtpFileParser l;
  private String m;
  private boolean n;
  
  public FtpFile(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt, String paramString8)
  {
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramString7;
    this.k = paramInt;
    this.m = paramString8;
  }
  
  public FtpFile(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt, String paramString8, boolean paramBoolean3)
  {
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramString7;
    this.k = paramInt;
    this.m = paramString8;
    this.n = paramBoolean3;
  }
  
  public FtpFile(String paramString)
  {
    this.a = paramString;
  }
  
  public FtpFile(String paramString1, String paramString2, FtpFileParser paramFtpFileParser)
  {
    this(paramString1);
    this.m = paramString2;
    this.l = paramFtpFileParser;
  }
  
  public FtpFile(String paramString, FtpFileParser paramFtpFileParser)
  {
    this(paramString);
    this.l = paramFtpFileParser;
  }
  
  public boolean isYearSet()
  {
    return this.n;
  }
  
  public void setFilename(String paramString)
  {
    this.a = paramString;
  }
  
  public String getFilename()
  {
    return this.a;
  }
  
  public void setFilesize(String paramString)
  {
    try
    {
      this.b = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.b = 0L;
    }
  }
  
  public long getFilesize()
  {
    return this.b;
  }
  
  public void setOwner(String paramString)
  {
    this.c = paramString;
  }
  
  public String getOwner()
  {
    return this.c;
  }
  
  public void setGroup(String paramString)
  {
    this.d = paramString;
  }
  
  public String getGroup()
  {
    return this.d;
  }
  
  public void setPermission(String paramString)
  {
    if (!FtpEvent.a) {
      if (paramString.indexOf('d') != -1) {
        this.h = true;
      }
    }
    if (paramString.indexOf('l') != -1) {
      this.i = true;
    }
    this.e = paramString;
  }
  
  public String getPermission()
  {
    return this.e;
  }
  
  public boolean isDirectory()
  {
    return this.h;
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean isLink()
  {
    return this.i;
  }
  
  public void setLinkTarget(String paramString)
  {
    this.j = new String(paramString);
  }
  
  public String getLinkTarget()
  {
    return this.j;
  }
  
  public void setDate(String paramString)
  {
    this.f = paramString;
  }
  
  public String getDate()
  {
    return this.f;
  }
  
  public void setTime(String paramString)
  {
    this.g = paramString;
  }
  
  public String getTime()
  {
    return this.g;
  }
  
  public String toString()
  {
    return this.m;
  }
  
  public boolean isHidden()
  {
    return getFilename().startsWith(".");
  }
  
  public FtpFileParser getFtpFileParser()
  {
    return this.l;
  }
  
  public void setFtpFileParser(FtpFileParser paramFtpFileParser)
  {
    this.l = paramFtpFileParser;
  }
  
  public void setLine(String paramString)
  {
    this.m = paramString;
  }
  
  public String getLine()
  {
    return this.m;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpFile
 * JD-Core Version:    0.7.0.1
 */