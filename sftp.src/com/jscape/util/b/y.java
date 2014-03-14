package com.jscape.util.b;

import com.jscape.util.f.ob;
import com.jscape.util.f.q;
import com.jscape.util.f.z;
import java.util.Iterator;

public class y<T, U extends ob<? super T>>
  extends z<Iterator<T>, U>
{
  private final U a;
  private final q b;
  
  public y(U paramU, q paramq)
  {
    this.a = paramU;
    this.b = paramq;
  }
  
  public y(U paramU)
  {
    this(paramU, q.a);
  }
  
  public U a(Iterator<T> paramIterator)
  {
    return a.a(paramIterator, this.a, this.b);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.y
 * JD-Core Version:    0.7.0.1
 */