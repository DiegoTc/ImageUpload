package com.jscape.b;

import java.util.EventObject;

public class k
  extends EventObject
{
  String a = null;
  
  public k(Object paramObject, String paramString)
  {
    super(paramObject);
    this.a = paramString;
  }
  
  public String b()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.b.k
 * JD-Core Version:    0.7.0.1
 */