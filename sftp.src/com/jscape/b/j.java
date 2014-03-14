package com.jscape.b;

import java.util.EventObject;

public class j
  extends EventObject
{
  private String a;
  private String b;
  
  public j(Object paramObject, String paramString1, String paramString2)
  {
    super(paramObject);
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.b.j
 * JD-Core Version:    0.7.0.1
 */