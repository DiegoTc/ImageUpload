package com.jscape.util.f.a;

import com.jscape.util.f.b;
import com.jscape.util.f.z;

public class h<F, S, R>
  extends z<F, R>
{
  private final b<? super F, ? super S, ? extends R> a;
  private final S b;
  
  public h(b<? super F, ? super S, ? extends R> paramb, S paramS)
  {
    this.a = paramb;
    this.b = paramS;
  }
  
  public R b(F paramF)
  {
    return this.a.a(paramF, this.b);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.h
 * JD-Core Version:    0.7.0.1
 */