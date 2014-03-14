package com.jscape.util.f.a;

import com.jscape.util.f.b;
import com.jscape.util.f.e;

public class d<F, S>
  extends e<F, S>
{
  private final b<? super F, ? super S, Boolean> a;
  
  public static <F, S> e<F, S> a(b<? super F, ? super S, Boolean> paramb)
  {
    return new d(paramb);
  }
  
  public d(b<? super F, ? super S, Boolean> paramb)
  {
    this.a = paramb;
  }
  
  public boolean a(F paramF, S paramS)
  {
    return ((Boolean)this.a.a(paramF, paramS)).booleanValue();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.d
 * JD-Core Version:    0.7.0.1
 */