package com.jscape.inet.ftp;

import java.util.EventObject;

public class FxpEndEvent
  extends EventObject
{
  private Object a;
  private Object b;
  private String c;
  
  public FxpEndEvent(Object paramObject1, Object paramObject2, String paramString)
  {
    super(paramObject1);
    this.a = paramObject1;
    this.b = paramObject2;
    this.c = paramString;
  }
  
  public Object getSource()
  {
    return this.a;
  }
  
  public Object getDestination()
  {
    return this.b;
  }
  
  public String getFilename()
  {
    return this.c;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FxpEndEvent
 * JD-Core Version:    0.7.0.1
 */