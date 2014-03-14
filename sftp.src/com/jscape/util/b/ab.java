package com.jscape.util.b;

import com.jscape.util.f.ob;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class ab<T>
  extends ob<T>
{
  private final Collection<T> a;
  
  public static <T> ab<T> b()
  {
    return new ab(new LinkedList());
  }
  
  public static <T> ab<T> c()
  {
    return new ab(new LinkedHashSet());
  }
  
  public ab(Collection<T> paramCollection)
  {
    this.a = paramCollection;
  }
  
  public void a(T paramT)
  {
    this.a.add(paramT);
  }
  
  public Collection<T> d()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.ab
 * JD-Core Version:    0.7.0.1
 */