package com.jscape.util.f.a;

import com.jscape.util.f.p;
import com.jscape.util.f.q;

public class a
  implements p<Boolean>
{
  private final q a;
  
  public static p<Boolean> a(q paramq)
  {
    return new a(paramq);
  }
  
  public a(q paramq)
  {
    this.a = paramq;
  }
  
  public Boolean c()
  {
    return Boolean.valueOf(this.a.b());
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.a.a
 * JD-Core Version:    0.7.0.1
 */