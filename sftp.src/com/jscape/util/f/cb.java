package com.jscape.util.f;

import com.jscape.util.u;

public class cb
  extends z<String, String>
{
  private final String a;
  private final String b;
  
  public cb(String paramString1, String paramString2)
  {
    u.a(paramString1);
    this.a = paramString1;
    u.a(paramString2);
    this.b = paramString2;
  }
  
  public String a(String paramString)
  {
    return this.a.replaceAll(this.b, paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.cb
 * JD-Core Version:    0.7.0.1
 */