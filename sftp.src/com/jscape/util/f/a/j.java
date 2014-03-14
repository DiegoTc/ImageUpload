package com.jscape.util.f.a;

import com.jscape.util.f.ob;
import com.jscape.util.f.z;

public class j<V, R>
  extends z<V, R>
{
  private final ob<? super V> a;
  
  public static <V, R> z<V, R> a(ob<? super V> paramob)
  {
    return new j(paramob);
  }
  
  public j(ob<? super V> paramob)
  {
    this.a = paramob;
  }
  
  public R b(V paramV)
  {
    this.a.a(paramV);
    return null;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.j
 * JD-Core Version:    0.7.0.1
 */