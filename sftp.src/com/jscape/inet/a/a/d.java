package com.jscape.inet.a.a;

import java.io.IOException;

public class d
  extends IOException
{
  public static d a(Throwable paramThrowable)
    throws d
  {
    throw ((e.e != 0) || ((paramThrowable instanceof d)) ? (d)paramThrowable : new d(paramThrowable));
  }
  
  public d() {}
  
  public d(String paramString)
  {
    super(paramString);
  }
  
  public d(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
  
  public d(Throwable paramThrowable)
  {
    initCause(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.d
 * JD-Core Version:    0.7.0.1
 */