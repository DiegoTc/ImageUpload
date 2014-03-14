package com.jscape.util;

import java.util.Enumeration;
import java.util.Iterator;

class sb
  implements Iterator<T>
{
  final rb a;
  
  sb(rb paramrb) {}
  
  public boolean hasNext()
  {
    return rb.a(this.a).hasMoreElements();
  }
  
  public T next()
  {
    return rb.a(this.a).nextElement();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.sb
 * JD-Core Version:    0.7.0.1
 */