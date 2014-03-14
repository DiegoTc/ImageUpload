package com.jscape.util.f.a;

import com.jscape.util.f.p;
import com.jscape.util.f.q;

public class f
  extends q
{
  private final p<Boolean> c;
  
  public static q a(p<Boolean> paramp)
  {
    return new f(paramp);
  }
  
  public f(p<Boolean> paramp)
  {
    this.c = paramp;
  }
  
  public boolean b()
  {
    return ((Boolean)this.c.b()).booleanValue();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.f
 * JD-Core Version:    0.7.0.1
 */