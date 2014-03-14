package com.jscape.util.j.a;

import java.io.IOException;

public class g
  extends IOException
{
  public static g a(Throwable paramThrowable)
  {
    return (b.a) || ((paramThrowable instanceof g)) ? (g)paramThrowable : new g(paramThrowable);
  }
  
  public g() {}
  
  public g(String paramString)
  {
    super(paramString);
  }
  
  public g(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public g(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.a.g
 * JD-Core Version:    0.7.0.1
 */