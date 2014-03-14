package com.jscape.inet.ftp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class UnixParser$UnixParserDate
{
  private Date a;
  private String b;
  private boolean c;
  final UnixParser d;
  
  public UnixParser$UnixParserDate(UnixParser paramUnixParser, Date paramDate, String paramString, boolean paramBoolean)
  {
    this.a = paramDate;
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  public Date getDate()
  {
    return this.a;
  }
  
  public void setDate(Date paramDate)
  {
    this.a = paramDate;
  }
  
  public String getFormat()
  {
    return this.b;
  }
  
  public void setFormat(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean isYearSet()
  {
    return this.c;
  }
  
  public String getFormattedDateAsString()
  {
    return new SimpleDateFormat(getFormat(), Locale.ENGLISH).format(getDate());
  }
  
  public String getFormattedDateAsString(String paramString)
  {
    return new SimpleDateFormat(paramString, Locale.ENGLISH).format(getDate());
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.UnixParser.UnixParserDate
 * JD-Core Version:    0.7.0.1
 */