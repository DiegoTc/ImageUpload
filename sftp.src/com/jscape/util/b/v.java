package com.jscape.util.b;

import com.jscape.util.f.hb;
import com.jscape.util.f.z;
import java.util.Collection;

public class v<T>
  extends z<Collection<T>, T>
{
  private final hb<? super T> a;
  private final T b;
  
  public v(hb<? super T> paramhb, T paramT)
  {
    this.a = paramhb;
    this.b = paramT;
  }
  
  public v(hb<? super T> paramhb)
  {
    this(paramhb, null);
  }
  
  public T a(Collection<T> paramCollection)
  {
    return a.a(paramCollection, this.a, this.b);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.v
 * JD-Core Version:    0.7.0.1
 */