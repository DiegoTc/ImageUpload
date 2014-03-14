package com.jscape.util.a.a;

import com.jscape.util.ub;

public class t
  implements o
{
  private static final String z = -1;
  
  public void a(n paramn, ub<i> paramub)
    throws f
  {
    int i = p.e;
    s locals = (s)paramn;
    String str = locals.d();
    paramub.d();
    do
    {
      if (!paramub.hasNext()) {
        break;
      }
      i locali = (i)paramub.next();
      if (i != 0) {
        return;
      }
      if ((i != 0) || ((!locali.c()) && (str.equals(locali.b()))))
      {
        locals.f();
        locali.d();
        return;
      }
    } while (i == 0);
    a(locals);
  }
  
  private void a(s params)
    throws f
  {
    if (params.e()) {
      throw new f(String.format(z, new Object[] { params.d() }));
    }
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.a.a.t
 * JD-Core Version:    0.7.0.1
 */