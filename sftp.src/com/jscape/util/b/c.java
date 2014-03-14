package com.jscape.util.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterator<T>
{
  private final T[] a;
  private int b;
  private static final String z = -1;
  
  public static <T> Iterator<T> a(T[] paramArrayOfT)
  {
    return new c(paramArrayOfT);
  }
  
  public c(T[] paramArrayOfT)
  {
    this.a = paramArrayOfT;
    this.b = -1;
  }
  
  public boolean hasNext()
  {
    if (!a.a) {}
    return this.b < this.a.length - 1;
  }
  
  public T next()
  {
    if (!a.a) {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
    }
    return this.a[(++this.b)];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException(z);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.c
 * JD-Core Version:    0.7.0.1
 */