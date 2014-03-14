package com.jscape.util.l;

public class b
  extends Exception
{
  public static b a(Throwable paramThrowable)
  {
    if (!f.c) {}
    return paramThrowable.getMessage() != null ? new b(paramThrowable.getMessage(), paramThrowable) : (paramThrowable instanceof b) ? (b)paramThrowable : new b(paramThrowable);
  }
  
  public b() {}
  
  public b(String paramString)
  {
    super(paramString);
  }
  
  public b(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public b(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.l.b
 * JD-Core Version:    0.7.0.1
 */