package com.jscape.util.f;

public class db<T, R, U>
  extends z<T, U>
{
  private final z<? super T, ? extends R> a;
  private final z<? super R, ? extends U> b;
  
  private db(z<? super T, ? extends R> paramz, z<? super R, ? extends U> paramz1)
  {
    this.a = paramz;
    this.b = paramz1;
  }
  
  public U b(T paramT)
  {
    return this.b.b(this.a.b(paramT));
  }
  
  db(z paramz1, z paramz2, gb paramgb)
  {
    this(paramz1, paramz2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.db
 * JD-Core Version:    0.7.0.1
 */