package com.jscape.util.b;

import com.jscape.util.f.z;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class r<A, R>
  implements Iterator<R>
{
  private final Iterator<? extends A> a;
  private final z<? super A, ? extends R> b;
  
  public static <A, R> Iterator<R> a(Iterator<? extends A> paramIterator, z<? super A, ? extends R> paramz)
  {
    return new r(paramIterator, paramz);
  }
  
  public static <A, R> Iterator<R> a(Collection<? extends A> paramCollection, z<? super A, ? extends R> paramz)
  {
    return a(paramCollection.iterator(), paramz);
  }
  
  public static <A, R> Iterator<R> a(Enumeration<A> paramEnumeration, z<? super A, ? extends R> paramz)
  {
    return a(h.a(paramEnumeration), paramz);
  }
  
  public static <A, R> Iterator<R> a(A[] paramArrayOfA, z<? super A, ? extends R> paramz)
  {
    return a(c.a(paramArrayOfA), paramz);
  }
  
  public r(Iterator<? extends A> paramIterator, z<? super A, ? extends R> paramz)
  {
    this.a = paramIterator;
    this.b = paramz;
  }
  
  public boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public R next()
  {
    return this.b.b(this.a.next());
  }
  
  public void remove()
  {
    this.a.remove();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.r
 * JD-Core Version:    0.7.0.1
 */