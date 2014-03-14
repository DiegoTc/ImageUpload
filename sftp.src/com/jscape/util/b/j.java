package com.jscape.util.b;

import com.jscape.util.f.hb;
import com.jscape.util.u;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class j<T>
  implements Iterator<T>
{
  private final Iterator<? extends T> a;
  private final hb<? super T> b;
  private T c;
  private boolean d;
  private boolean e;
  private static final String z = -1;
  
  public static <T> Iterator<T> a(Iterator<? extends T> paramIterator, hb<? super T> paramhb)
  {
    return new j(paramIterator, paramhb);
  }
  
  public static <T> Iterator<T> a(Collection<? extends T> paramCollection, hb<? super T> paramhb)
  {
    return a(paramCollection.iterator(), paramhb);
  }
  
  public static <T> Iterator<T> a(Enumeration<T> paramEnumeration, hb<? super T> paramhb)
  {
    return a(h.a(paramEnumeration), paramhb);
  }
  
  public static <T> Iterator<T> a(T[] paramArrayOfT, hb<? super T> paramhb)
  {
    return a(c.a(paramArrayOfT), paramhb);
  }
  
  public j(Iterator<? extends T> paramIterator, hb<? super T> paramhb)
  {
    this.a = paramIterator;
    this.b = paramhb;
  }
  
  public boolean hasNext()
  {
    boolean bool = a.a;
    if (!bool) {
      if (!this.d) {
        if (bool) {
          break label27;
        }
      }
    }
    label27:
    return c();
  }
  
  public T next()
  {
    if (!a.a)
    {
      if (hasNext())
      {
        this.d = false;
        this.e = true;
      }
    }
    else {
      return b();
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    u.c(this.e, z);
    this.a.remove();
    this.e = false;
  }
  
  private T b()
  {
    Object localObject = this.c;
    this.c = null;
    return localObject;
  }
  
  private boolean c()
  {
    boolean bool = a.a;
    do
    {
      if (!this.a.hasNext()) {
        break;
      }
      if ((bool) || (bool)) {
        break label72;
      }
      if (this.d) {
        break;
      }
      this.c = this.a.next();
      this.d = this.b.a(this.c);
    } while (!bool);
    this.e = false;
    label72:
    if (!bool) {
      if (!this.d) {
        this.c = null;
      }
    }
    return this.d;
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.j
 * JD-Core Version:    0.7.0.1
 */