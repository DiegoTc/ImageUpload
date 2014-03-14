package com.jscape.util.b;

import com.jscape.util.f.ob;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class bb<T>
  extends ob<Collection<T>>
{
  private final Collection<T> a;
  
  public static <T> bb<T> b()
  {
    return new bb(new LinkedList());
  }
  
  public static <T> bb<T> c()
  {
    return new bb(new LinkedHashSet());
  }
  
  public bb(Collection<T> paramCollection)
  {
    this.a = paramCollection;
  }
  
  public void a(Collection<T> paramCollection)
  {
    this.a.addAll(paramCollection);
  }
  
  public Collection<T> d()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.bb
 * JD-Core Version:    0.7.0.1
 */