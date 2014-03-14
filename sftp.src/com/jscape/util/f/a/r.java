package com.jscape.util.f.a;

import com.jscape.util.f.ob;
import com.jscape.util.f.z;

public class r<V>
  extends ob<V>
{
  private final z<? super V, Boolean> a;
  
  public static <V> ob<V> a(z<? super V, Boolean> paramz)
  {
    return new r(paramz);
  }
  
  public r(z<? super V, Boolean> paramz)
  {
    this.a = paramz;
  }
  
  public void a(V paramV)
  {
    this.a.b(paramV);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.r
 * JD-Core Version:    0.7.0.1
 */