package com.jscape.util.f.a;

import com.jscape.util.f.b;
import com.jscape.util.f.m;

public class e<F, S>
  extends m<F, S>
{
  private final b<? super F, ? super S, Boolean> a;
  
  public static <F, S> m<F, S> a(b<? super F, ? super S, Boolean> paramb)
  {
    return new e(paramb);
  }
  
  public e(b<? super F, ? super S, Boolean> paramb)
  {
    this.a = paramb;
  }
  
  public void a(F paramF, S paramS)
  {
    this.a.a(paramF, paramS);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.e
 * JD-Core Version:    0.7.0.1
 */