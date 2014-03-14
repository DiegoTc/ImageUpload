package com.jscape.util.b;

import com.jscape.util.f.hb;
import com.jscape.util.f.nb;
import com.jscape.util.f.z;
import java.util.Iterator;
import java.util.List;

public class u<T>
  extends z<Iterator<T>, List<T>>
{
  private final hb<? super T> a;
  
  public u(hb<? super T> paramhb)
  {
    this.a = paramhb;
  }
  
  public u()
  {
    this(new nb());
  }
  
  public List<T> a(Iterator<T> paramIterator)
  {
    return a.a(paramIterator, this.a);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.u
 * JD-Core Version:    0.7.0.1
 */