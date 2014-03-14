package com.jscape.util.k;

public class b
  extends Exception
{
  private final Throwable a;
  
  public b()
  {
    this(null, null);
  }
  
  public b(String paramString)
  {
    this(paramString, null);
  }
  
  public b(Throwable paramThrowable)
  {
    this(paramThrowable.getMessage(), paramThrowable);
  }
  
  public b(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.a = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.k.b
 * JD-Core Version:    0.7.0.1
 */