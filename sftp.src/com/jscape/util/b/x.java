package com.jscape.util.b;

import com.jscape.util.f.ob;
import com.jscape.util.f.q;
import com.jscape.util.f.z;
import java.util.Collection;

public class x<T, U extends ob<? super T>>
  extends z<Collection<T>, U>
{
  private final U a;
  private final q b;
  
  public x(U paramU, q paramq)
  {
    this.a = paramU;
    this.b = paramq;
  }
  
  public x(U paramU)
  {
    this(paramU, q.a);
  }
  
  public U a(Collection<T> paramCollection)
  {
    return a.a(paramCollection, this.a, this.b);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.b.x
 * JD-Core Version:    0.7.0.1
 */