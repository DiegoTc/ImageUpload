package com.jscape.util.e;

import com.jscape.util.bc;
import com.jscape.util.u;

public abstract class d
{
  protected final l a;
  protected final i b;
  protected final j c;
  protected j d;
  
  protected d(l paraml, i parami, j paramj1, j paramj2)
  {
    bc.a(paraml);
    this.a = paraml;
    bc.a(parami);
    this.b = parami;
    bc.a(paramj2);
    this.c = paramj2;
    bc.a(paramj1);
    this.d = paramj1;
    if (i != 0) {
      u.a = !u.a;
    }
  }
  
  protected void b()
    throws a
  {
    int i = g.a;
    do
    {
      if (this.d == this.c) {
        break;
      }
      g localg = this.b.b();
      this.d = this.a.a(this.d, localg);
      this.d.a(localg, this.b);
    } while (i == 0);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.e.d
 * JD-Core Version:    0.7.0.1
 */