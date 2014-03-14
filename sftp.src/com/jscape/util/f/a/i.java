package com.jscape.util.f.a;

import com.jscape.util.f.hb;
import com.jscape.util.f.z;

public class i<V>
  extends z<V, Boolean>
{
  private final hb<? super V> a;
  
  public static <V> z<V, Boolean> a(hb<? super V> paramhb)
  {
    return new i(paramhb);
  }
  
  public i(hb<? super V> paramhb)
  {
    this.a = paramhb;
  }
  
  public Boolean c(V paramV)
  {
    return Boolean.valueOf(this.a.a(paramV));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.i
 * JD-Core Version:    0.7.0.1
 */