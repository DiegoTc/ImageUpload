package com.jscape.util.j.a;

import java.io.IOException;

public class b
  extends IOException
{
  public static boolean a;
  
  public static b a(Throwable paramThrowable)
  {
    return (a) || ((paramThrowable instanceof b)) ? (b)paramThrowable : new b(paramThrowable);
  }
  
  public b() {}
  
  public b(String paramString)
  {
    super(paramString);
  }
  
  public b(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
  
  public b(Throwable paramThrowable)
  {
    initCause(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.b
 * JD-Core Version:    0.7.0.1
 */