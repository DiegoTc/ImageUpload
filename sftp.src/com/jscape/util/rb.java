package com.jscape.util;

import java.util.Enumeration;
import java.util.Iterator;

public class rb<T>
  implements Iterable<T>
{
  private final Enumeration<T> a;
  private static final String z = -1;
  
  public static <T> Iterable<T> a(Enumeration paramEnumeration)
  {
    return new rb(paramEnumeration);
  }
  
  public rb(Enumeration<T> paramEnumeration)
  {
    u.a(paramEnumeration);
    this.a = paramEnumeration;
  }
  
  public String toString()
  {
    return z + this.a + '}';
  }
  
  public Iterator<T> iterator()
  {
    return new sb(this);
  }
  
  static Enumeration a(rb paramrb)
  {
    return paramrb.a;
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.rb
 * JD-Core Version:    0.7.0.1
 */