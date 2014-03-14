package com.jscape.util.b;

import com.jscape.util.f.a.k;
import com.jscape.util.f.e;
import com.jscape.util.f.hb;
import java.util.Collection;

public class z<T, U>
  extends hb<T>
{
  private final Collection<U> b;
  private final e<? super T, ? super U> c;
  
  private z(Collection<U> paramCollection, e<? super T, ? super U> parame)
  {
    this.b = paramCollection;
    this.c = parame;
  }
  
  public boolean a(T paramT)
  {
    return a.c(this.b, new k(this.c, paramT)) != null;
  }
  
  z(Collection paramCollection, e parame, b paramb)
  {
    this(paramCollection, parame);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.z
 * JD-Core Version:    0.7.0.1
 */