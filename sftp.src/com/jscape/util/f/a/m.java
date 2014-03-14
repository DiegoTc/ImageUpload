package com.jscape.util.f.a;

import com.jscape.util.f.e;
import com.jscape.util.f.hb;

public class m<F, S>
  extends hb<F>
{
  private final e<? super F, ? super S> b;
  private final S c;
  public static int d;
  
  public m(e<? super F, ? super S> parame, S paramS)
  {
    this.b = parame;
    this.c = paramS;
  }
  
  public boolean a(F paramF)
  {
    return this.b.a(paramF, this.c);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.m
 * JD-Core Version:    0.7.0.1
 */