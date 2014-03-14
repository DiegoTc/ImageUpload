package com.jscape.util.l;

import com.jscape.util.f.ob;

public class d<T>
  extends ob<g<T>>
{
  private final T a;
  
  public static <T> d<T> b(T paramT)
  {
    return new d(paramT);
  }
  
  public d(T paramT)
  {
    this.a = paramT;
  }
  
  public void a(g<T> paramg)
  {
    try
    {
      if ((f.c) || (!paramg.c())) {
        paramg.a(this.a);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.l.d
 * JD-Core Version:    0.7.0.1
 */