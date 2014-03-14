package com.jscape.util.b;

import com.jscape.util.f.hb;
import com.jscape.util.f.nb;
import com.jscape.util.f.z;
import java.util.Collection;
import java.util.List;

public class t<T>
  extends z<Collection<T>, List<T>>
{
  private final hb<? super T> a;
  
  public t(hb<? super T> paramhb)
  {
    this.a = paramhb;
  }
  
  public t()
  {
    this(new nb());
  }
  
  public List<T> a(Collection<T> paramCollection)
  {
    return a.a(paramCollection, this.a);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.t
 * JD-Core Version:    0.7.0.1
 */