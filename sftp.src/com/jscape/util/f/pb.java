package com.jscape.util.f;

public class pb<T>
  extends ob<T>
{
  private final ob<? super T> a;
  private final ob<? super T> b;
  
  private pb(ob<? super T> paramob1, ob<? super T> paramob2)
  {
    this.a = paramob1;
    this.b = paramob2;
  }
  
  public void a(T paramT)
  {
    this.a.a(paramT);
    this.b.a(paramT);
  }
  
  pb(ob paramob1, ob paramob2, qb paramqb)
  {
    this(paramob1, paramob2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.pb
 * JD-Core Version:    0.7.0.1
 */