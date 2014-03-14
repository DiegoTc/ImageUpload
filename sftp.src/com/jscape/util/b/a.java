package com.jscape.util.b;

import com.jscape.util.cb;
import com.jscape.util.db;
import com.jscape.util.f.ab;
import com.jscape.util.f.e;
import com.jscape.util.f.hb;
import com.jscape.util.f.nb;
import com.jscape.util.f.ob;
import com.jscape.util.f.q;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static boolean a;
  
  public static <T> List<T> a(Iterator<T> paramIterator, hb<? super T> paramhb)
  {
    boolean bool = a;
    List localList = cb.c();
    Iterator localIterator = j.a(paramIterator, paramhb);
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      if (bool) {
        break label48;
      }
      localList.add(localIterator.next());
    } while (!bool);
    label48:
    return localList;
  }
  
  public static <T> List<T> a(Collection<T> paramCollection, hb<? super T> paramhb)
  {
    return a(paramCollection.iterator(), paramhb);
  }
  
  public static <T> List<T> a(T[] paramArrayOfT, hb<? super T> paramhb)
  {
    return a(c.a(paramArrayOfT), paramhb);
  }
  
  public static <T> int b(Iterator<T> paramIterator, hb<? super T> paramhb)
  {
    boolean bool = a;
    int i = 0;
    Iterator localIterator = j.a(paramIterator, paramhb);
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i++;
    } while (!bool);
    return i;
  }
  
  public static <T> int b(Collection<T> paramCollection, hb<? super T> paramhb)
  {
    return b(paramCollection.iterator(), paramhb);
  }
  
  public static <T> int b(T[] paramArrayOfT, hb<? super T> paramhb)
  {
    return b(c.a(paramArrayOfT), paramhb);
  }
  
  public static <T> T a(Iterator<T> paramIterator, hb<? super T> paramhb, T paramT)
  {
    Iterator localIterator = j.a(paramIterator, paramhb);
    if (!a) {}
    return localIterator.hasNext() ? localIterator.next() : paramT;
  }
  
  public static <T> T a(Collection<T> paramCollection, hb<? super T> paramhb, T paramT)
  {
    return a(paramCollection.iterator(), paramhb, paramT);
  }
  
  public static <T> T a(T[] paramArrayOfT, hb<? super T> paramhb, T paramT)
  {
    return a(c.a(paramArrayOfT), paramhb, paramT);
  }
  
  public static <T> T c(Iterator<T> paramIterator, hb<? super T> paramhb)
  {
    return a(paramIterator, paramhb, null);
  }
  
  public static <T> T c(Collection<T> paramCollection, hb<? super T> paramhb)
  {
    return c(paramCollection.iterator(), paramhb);
  }
  
  public static <T> T c(T[] paramArrayOfT, hb<? super T> paramhb)
  {
    return c(c.a(paramArrayOfT), paramhb);
  }
  
  public static <T, U extends ob<? super T>> U a(Iterator<T> paramIterator, U paramU, q paramq)
  {
    boolean bool = a;
    do
    {
      if ((!paramq.b()) || (!paramIterator.hasNext())) {
        break;
      }
      paramU.a(paramIterator.next());
    } while (!bool);
    return paramU;
  }
  
  public static <T, U extends ob<? super T>> U a(Collection<T> paramCollection, U paramU, q paramq)
  {
    return a(paramCollection.iterator(), paramU, paramq);
  }
  
  public static <T, U extends ob<? super T>> U a(T[] paramArrayOfT, U paramU, q paramq)
  {
    return a(c.a(paramArrayOfT), paramU, paramq);
  }
  
  public static <T, U extends ob<? super T>> U a(Iterator<T> paramIterator, U paramU)
  {
    return a(paramIterator, paramU, q.a);
  }
  
  public static <T, U extends ob<? super T>> U a(Collection<T> paramCollection, U paramU)
  {
    return a(paramCollection.iterator(), paramU);
  }
  
  public static <T, U extends ob<? super T>> U a(T[] paramArrayOfT, U paramU)
  {
    return a(c.a(paramArrayOfT), paramU);
  }
  
  public static <T, U extends ob<? super T>> U a(Iterator<T> paramIterator, U paramU, hb<? super T> paramhb)
  {
    boolean bool = a;
    do
    {
      if (!paramIterator.hasNext()) {
        break;
      }
      Object localObject = paramIterator.next();
      if (paramhb.a(localObject)) {
        paramU.a(localObject);
      }
    } while (!bool);
    return paramU;
  }
  
  public static <T, U extends ob<? super T>> U a(Collection<T> paramCollection, U paramU, hb<? super T> paramhb)
  {
    return a(paramCollection.iterator(), paramU, paramhb);
  }
  
  public static <T, U extends ob<? super T>> U a(T[] paramArrayOfT, U paramU, hb<? super T> paramhb)
  {
    return a(c.a(paramArrayOfT), paramU, paramhb);
  }
  
  public static <T, U> List<U> a(Iterator<T> paramIterator)
  {
    return a(r.a(paramIterator, new ab()), new nb());
  }
  
  public static <T, U> List<U> a(Collection<T> paramCollection)
  {
    return a(paramCollection.iterator());
  }
  
  public static <T, U> List<U> a(T[] paramArrayOfT)
  {
    return a(c.a(paramArrayOfT));
  }
  
  public static <T, R> R[] a(Iterator<T> paramIterator, Class<R> paramClass, com.jscape.util.f.z<? super T, ? extends R> paramz)
  {
    List localList = a(r.a(paramIterator, paramz));
    return localList.toArray((Object[])Array.newInstance(paramClass, localList.size()));
  }
  
  public static <T, R> R[] a(Collection<T> paramCollection, Class<R> paramClass, com.jscape.util.f.z<? super T, ? extends R> paramz)
  {
    return a(paramCollection.iterator(), paramClass, paramz);
  }
  
  public static <T, R> R[] a(Collection<T> paramCollection, Class<R> paramClass)
  {
    return a(paramCollection, paramClass, new ab());
  }
  
  public static <T, R> R[] a(Iterator<T> paramIterator, Class<R> paramClass)
  {
    return a(paramIterator, paramClass, new ab());
  }
  
  public static <T, R> R[] a(T[] paramArrayOfT, Class<R> paramClass)
  {
    return a(c.a(paramArrayOfT), paramClass);
  }
  
  public static <T, U> Collection<T> a(Iterator<T> paramIterator, Collection<U> paramCollection, e<? super T, ? super U> parame)
  {
    return a(paramIterator, hb.a(new z(paramCollection, parame, null)));
  }
  
  public static <T, U> Collection<T> a(Collection<T> paramCollection, Collection<U> paramCollection1, e<? super T, ? super U> parame)
  {
    return a(paramCollection.iterator(), paramCollection1, parame);
  }
  
  public static <T, U> Collection<T> b(Iterator<T> paramIterator, Collection<U> paramCollection, e<? super T, ? super U> parame)
  {
    return a(paramIterator, new z(paramCollection, parame, null));
  }
  
  public static <T, U> Collection<T> b(Collection<T> paramCollection, Collection<U> paramCollection1, e<? super T, ? super U> parame)
  {
    return b(paramCollection.iterator(), paramCollection1, parame);
  }
  
  public static <T> T b(Iterator<T> paramIterator)
  {
    boolean bool = a;
    Object localObject = null;
    do
    {
      if (!paramIterator.hasNext()) {
        break;
      }
      if (bool) {
        break label31;
      }
      localObject = paramIterator.next();
    } while (!bool);
    label31:
    return localObject;
  }
  
  public static <T> T b(Collection<T> paramCollection)
  {
    return b(paramCollection.iterator());
  }
  
  public static <T extends db<T>> List<T> c(Iterator<T> paramIterator)
  {
    boolean bool = a;
    List localList = cb.c();
    do
    {
      if (!paramIterator.hasNext()) {
        break;
      }
      if (bool) {
        break label47;
      }
      localList.add(((db)paramIterator.next()).b());
    } while (!bool);
    label47:
    return localList;
  }
  
  public static <T extends db<T>> List<T> c(Collection<T> paramCollection)
  {
    return c(paramCollection.iterator());
  }
  
  public static <T extends db<T>> List<T> a(T[] paramArrayOfT)
  {
    return c(c.a(paramArrayOfT));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.a
 * JD-Core Version:    0.7.0.1
 */