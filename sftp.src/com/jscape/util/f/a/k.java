package com.jscape.util.f.a;

import com.jscape.util.f.e;
import com.jscape.util.f.hb;

public class k<F, S>
  extends hb<S>
{
  private final e<? super F, ? super S> b;
  private final F c;
  
  public k(e<? super F, ? super S> parame, F paramF)
  {
    this.b = parame;
    this.c = paramF;
  }
  
  public boolean a(S paramS)
  {
    return this.b.a(this.c, paramS);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.k
 * JD-Core Version:    0.7.0.1
 */