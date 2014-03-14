package com.jscape.util.f.a;

import com.jscape.util.f.b;
import com.jscape.util.f.m;

public class c<F, S, R>
  extends b<F, S, R>
{
  private final m<? super F, ? super S> a;
  
  public static <F, S, R> b<F, S, R> a(m<? super F, ? super S> paramm)
  {
    return new c(paramm);
  }
  
  public c(m<? super F, ? super S> paramm)
  {
    this.a = paramm;
  }
  
  public R a(F paramF, S paramS)
  {
    this.a.a(paramF, paramS);
    return null;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.c
 * JD-Core Version:    0.7.0.1
 */