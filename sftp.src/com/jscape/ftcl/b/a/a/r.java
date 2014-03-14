package com.jscape.ftcl.b.a.a;

import com.jscape.util.bc;
import com.jscape.util.e.a;
import com.jscape.util.e.d;
import com.jscape.util.e.e;
import com.jscape.util.e.k;
import com.jscape.util.e.l;
import java.util.LinkedList;
import java.util.List;

public class r
  extends d
{
  private final List<f> e;
  private static final String z = -1;
  
  public static r a(String paramString)
  {
    boolean bool = f.a;
    LinkedList localLinkedList = new LinkedList();
    ab localab = new ab('$', localLinkedList);
    cb localcb = new cb('}', localLinkedList);
    bb localbb1 = new bb(z);
    bb localbb2 = new bb("}");
    k localk = new k();
    e locale = new e(new com.jscape.util.e.f[] { new com.jscape.util.e.f(localab, s.class, localab), new com.jscape.util.e.f(localab, u.class, localab), new com.jscape.util.e.f(localab, t.class, localk), new com.jscape.util.e.f(localab, y.class, localbb1), new com.jscape.util.e.f(localab, z.class, localcb), new com.jscape.util.e.f(localbb1, s.class, localbb1), new com.jscape.util.e.f(localbb1, u.class, localbb1), new com.jscape.util.e.f(localbb1, v.class, localab), new com.jscape.util.e.f(localbb1, w.class, localab), new com.jscape.util.e.f(localcb, s.class, localcb), new com.jscape.util.e.f(localcb, u.class, localcb), new com.jscape.util.e.f(localcb, t.class, localk), new com.jscape.util.e.f(localcb, x.class, localab), new com.jscape.util.e.f(localcb, y.class, localbb2), new com.jscape.util.e.f(localbb2, s.class, localbb2), new com.jscape.util.e.f(localbb2, u.class, localbb2), new com.jscape.util.e.f(localbb2, v.class, localcb), new com.jscape.util.e.f(localbb2, w.class, localcb) });
    q localq = new q(paramString);
    if (bool) {
      com.jscape.util.u.a = !com.jscape.util.u.a;
    }
    return new r(locale, localq, localab, localk, localLinkedList);
  }
  
  private r(l paraml, com.jscape.util.e.i parami, com.jscape.util.e.j paramj1, com.jscape.util.e.j paramj2, List<f> paramList)
  {
    super(paraml, parami, paramj1, paramj2);
    bc.a(paramList);
    this.e = paramList;
  }
  
  public void c()
    throws a
  {
    b();
  }
  
  public List<f> d()
  {
    return this.e;
  }
  
  public j e()
  {
    return new j(this.e);
  }
  
  public g f()
  {
    return new g(this.e);
  }
  
  public i g()
  {
    return new i(this.e);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.a.r
 * JD-Core Version:    0.7.0.1
 */