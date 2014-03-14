package com.jscape.util.b;

import java.util.Enumeration;
import java.util.Iterator;

public class h<T>
  implements Iterator<T>
{
  private final Enumeration<T> a;
  private static final String z = -1;
  
  public static <T> Iterator<T> a(Enumeration<T> paramEnumeration)
  {
    return new h(paramEnumeration);
  }
  
  public static <T> Iterable<T> b(Enumeration paramEnumeration)
  {
    return new i(paramEnumeration);
  }
  
  public h(Enumeration<T> paramEnumeration)
  {
    this.a = paramEnumeration;
  }
  
  public boolean hasNext()
  {
    return this.a.hasMoreElements();
  }
  
  public T next()
  {
    return this.a.nextElement();
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
 * Qualified Name:     com.jscape.util.b.h
 * JD-Core Version:    0.7.0.1
 */