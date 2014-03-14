package com.jscape.util.f;

public abstract class z<V, R>
{
  public static <T, U> eb<T, U> a(U paramU)
  {
    return new eb(paramU);
  }
  
  public abstract R b(V paramV);
  
  public <U> z<V, U> a(z<? super R, ? extends U> paramz)
  {
    return new db(this, paramz, null);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.z
 * JD-Core Version:    0.7.0.1
 */