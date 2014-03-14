package com.jscape.util.f.a;

import com.jscape.util.f.b;
import com.jscape.util.f.z;

public class g<F, S, R>
  extends z<S, R>
{
  private final b<? super F, ? super S, ? extends R> a;
  private final F b;
  
  public g(b<? super F, ? super S, ? extends R> paramb, F paramF)
  {
    this.a = paramb;
    this.b = paramF;
  }
  
  public R b(S paramS)
  {
    return this.a.a(this.b, paramS);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.g
 * JD-Core Version:    0.7.0.1
 */