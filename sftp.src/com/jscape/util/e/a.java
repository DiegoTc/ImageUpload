package com.jscape.util.e;

public class a
  extends Exception
{
  public static a a(Throwable paramThrowable)
  {
    if (g.a == 0) {}
    return paramThrowable.getMessage() != null ? new a(paramThrowable.getMessage(), paramThrowable) : (paramThrowable instanceof a) ? (a)paramThrowable : new a(paramThrowable);
  }
  
  public a() {}
  
  public a(String paramString)
  {
    super(paramString);
  }
  
  public a(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public a(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.e.a
 * JD-Core Version:    0.7.0.1
 */