package com.jscape.ftcl.b.a.a;

import com.jscape.util.bc;
import com.jscape.util.e.a;
import com.jscape.util.e.i;
import com.jscape.util.e.j;
import java.util.List;

public class ab
  extends j
  implements c, n, l, m, e
{
  private final char a;
  private final List<f> b;
  private final StringBuilder c;
  
  public ab(char paramChar, List<f> paramList)
  {
    this.a = paramChar;
    bc.a(paramList);
    this.b = paramList;
    this.c = new StringBuilder();
  }
  
  public void a(s params, i parami)
    throws a
  {
    boolean bool = f.a;
    char c1 = params.b;
    if (!bool)
    {
      if (c1 == this.a)
      {
        parami.a(new y());
        parami.a(params);
      }
    }
    else if (!bool) {
      return;
    }
    this.c.append(c1);
  }
  
  public void a(x paramx, i parami)
    throws a
  {}
  
  public void a(v paramv, i parami)
    throws a
  {
    b();
    parami.a(new z());
  }
  
  public void a(w paramw, i parami)
    throws a
  {
    this.c.append(paramw.b);
  }
  
  public void a(u paramu, i parami)
    throws a
  {
    b();
    parami.a(new t());
  }
  
  private void b()
  {
    String str = this.c.toString();
    if (!f.a)
    {
      if (str.length() > 0)
      {
        h localh = new h(str);
        this.b.add(localh);
      }
      this.c.setLength(0);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.a.ab
 * JD-Core Version:    0.7.0.1
 */