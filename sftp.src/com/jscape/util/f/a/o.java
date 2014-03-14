package com.jscape.util.f.a;

import com.jscape.util.f.hb;
import com.jscape.util.f.z;

public class o<V>
  extends hb<V>
{
  private final z<? super V, Boolean> b;
  
  public static <V> hb<V> a(z<? super V, Boolean> paramz)
  {
    return new o(paramz);
  }
  
  public o(z<? super V, Boolean> paramz)
  {
    this.b = paramz;
  }
  
  public boolean a(V paramV)
  {
    return ((Boolean)this.b.b(paramV)).booleanValue();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.o
 * JD-Core Version:    0.7.0.1
 */