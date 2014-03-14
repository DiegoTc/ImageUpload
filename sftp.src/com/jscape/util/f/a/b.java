package com.jscape.util.f.a;

import com.jscape.util.f.e;

public class b<F, S>
  extends com.jscape.util.f.b<F, S, Boolean>
{
  private final e<? super F, ? super S> a;
  
  public static <F, S> com.jscape.util.f.b<F, S, Boolean> a(e<? super F, ? super S> parame)
  {
    return new b(parame);
  }
  
  public b(e<? super F, ? super S> parame)
  {
    this.a = parame;
  }
  
  public Boolean b(F paramF, S paramS)
  {
    return Boolean.valueOf(this.a.a(paramF, paramS));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.b
 * JD-Core Version:    0.7.0.1
 */