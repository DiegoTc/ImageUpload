package com.jscape.ftcl.b.a.a;

import com.jscape.util.bc;
import com.jscape.util.e.a;
import com.jscape.util.e.i;
import com.jscape.util.e.j;

public class bb
  extends j
  implements o, c, e
{
  private final String a;
  private int b;
  
  public bb(String paramString)
  {
    bc.a(paramString);
    this.a = paramString;
  }
  
  public void a(y paramy, i parami)
    throws a
  {
    this.b = 0;
  }
  
  public void a(s params, i parami)
    throws a
  {
    boolean bool = f.a;
    if ((bool) || (params.b == this.a.charAt(this.b)))
    {
      if (++this.b == this.a.length())
      {
        parami.a(new v());
        if (!bool) {}
      }
    }
    else
    {
      parami.a(new w(this.a.substring(0, this.b)));
      parami.a(params);
    }
  }
  
  public void a(u paramu, i parami)
    throws a
  {
    parami.a(new w(this.a.substring(0, this.b)));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.a.bb
 * JD-Core Version:    0.7.0.1
 */