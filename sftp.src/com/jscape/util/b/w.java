package com.jscape.util.b;

import com.jscape.util.f.hb;
import com.jscape.util.f.z;
import java.util.Iterator;

public class w<T>
  extends z<Iterator<T>, T>
{
  private final hb<? super T> a;
  private final T b;
  
  public w(hb<? super T> paramhb, T paramT)
  {
    this.a = paramhb;
    this.b = paramT;
  }
  
  public w(hb<? super T> paramhb)
  {
    this(paramhb, null);
  }
  
  public T a(Iterator<T> paramIterator)
  {
    return a.a(paramIterator, this.a, this.b);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.w
 * JD-Core Version:    0.7.0.1
 */