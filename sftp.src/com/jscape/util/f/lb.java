package com.jscape.util.f;

public class lb<T>
  extends hb<T>
{
  private final hb<? super T> b;
  
  public lb(hb<? super T> paramhb)
  {
    this.b = paramhb;
  }
  
  public boolean a(T paramT)
  {
    if (hb.a == 0) {}
    return !this.b.a(paramT);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.lb
 * JD-Core Version:    0.7.0.1
 */