package com.jscape.util.g;

import java.io.IOException;

public class k
  extends IOException
{
  public static k a(Throwable paramThrowable)
    throws k
  {
    throw ((m.d != 0) || ((paramThrowable instanceof k)) ? (k)paramThrowable : new k(paramThrowable));
  }
  
  public k() {}
  
  public k(String paramString)
  {
    super(paramString);
  }
  
  public k(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
  
  public k(Throwable paramThrowable)
  {
    initCause(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.k
 * JD-Core Version:    0.7.0.1
 */