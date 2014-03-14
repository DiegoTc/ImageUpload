package com.jscape.inet.ftp;

import java.util.EventObject;

public class FxpFailedEvent
  extends EventObject
{
  private Exception a;
  private Object b;
  private Object c;
  private String d;
  
  public FxpFailedEvent(Object paramObject1, Object paramObject2, String paramString, Exception paramException)
  {
    super(paramObject1);
    this.b = paramObject1;
    this.c = paramObject2;
    this.d = paramString;
    this.a = paramException;
  }
  
  public Exception getException()
  {
    return this.a;
  }
  
  public Object getSource()
  {
    return this.b;
  }
  
  public Object getDestination()
  {
    return this.c;
  }
  
  public String getFilename()
  {
    return this.d;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FxpFailedEvent
 * JD-Core Version:    0.7.0.1
 */