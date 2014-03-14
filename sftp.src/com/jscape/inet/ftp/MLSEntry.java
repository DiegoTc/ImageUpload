package com.jscape.inet.ftp;

import com.jscape.util.u;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class MLSEntry
{
  private String a;
  private Long b;
  private Date c;
  private Date d;
  private MLSEntry.Type e;
  private String f;
  private MLSEntry.Permissions g;
  private String h;
  private String i;
  private String j;
  private Map k;
  
  public MLSEntry(String paramString)
  {
    u.a(paramString);
    this.a = paramString;
    this.k = new HashMap();
  }
  
  public String getPathname()
  {
    return this.a;
  }
  
  public Long getSize()
  {
    return this.b;
  }
  
  public void setSize(Long paramLong)
  {
    this.b = paramLong;
  }
  
  public Date getLastModificationDate()
  {
    return this.c;
  }
  
  public void setLastModificationDate(Date paramDate)
  {
    this.c = paramDate;
  }
  
  public Date getCreationDate()
  {
    return this.d;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.d = paramDate;
  }
  
  public MLSEntry.Type getType()
  {
    return this.e;
  }
  
  public void setType(MLSEntry.Type paramType)
  {
    this.e = paramType;
  }
  
  public String getUniqueId()
  {
    return this.f;
  }
  
  public void setUniqueId(String paramString)
  {
    this.f = paramString;
  }
  
  public MLSEntry.Permissions getPermissions()
  {
    if (!FtpEvent.a) {}
    return this.g != null ? new MLSEntry.Permissions(this.g) : null;
  }
  
  public void setPermissions(MLSEntry.Permissions paramPermissions)
  {
    if (!FtpEvent.a) {}
    this.g = (paramPermissions != null ? new MLSEntry.Permissions(paramPermissions) : null);
  }
  
  public String getLanguage()
  {
    return this.h;
  }
  
  public void setLanguage(String paramString)
  {
    this.h = paramString;
  }
  
  public String getMediaType()
  {
    return this.i;
  }
  
  public void setMediaType(String paramString)
  {
    this.i = paramString;
  }
  
  public String getCharset()
  {
    return this.j;
  }
  
  public void setCharset(String paramString)
  {
    this.j = paramString;
  }
  
  public String getAdditionalFact(String paramString)
  {
    return (String)this.k.get(paramString);
  }
  
  public void setAdditionalFact(String paramString1, String paramString2)
  {
    this.k.put(paramString1, paramString2);
  }
  
  public Map getAdditionalFacts()
  {
    return new HashMap(this.k);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.MLSEntry
 * JD-Core Version:    0.7.0.1
 */