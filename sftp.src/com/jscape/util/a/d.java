package com.jscape.util.a;

import com.jscape.util.u;
import com.jscape.util.ub;

public class d
  extends b
{
  private String j;
  private static final String z = -1;
  
  public d(String paramString, boolean paramBoolean, int paramInt)
  {
    this(paramString, "", paramBoolean, paramInt);
  }
  
  public d(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    super(paramString1, paramBoolean, paramInt);
    u.a(paramString2);
    this.j = paramString2;
  }
  
  public String g()
  {
    return this.j;
  }
  
  protected String f()
  {
    return this.f + " " + "<" + this.j + ">";
  }
  
  protected String a(h paramh, ub paramub)
  {
    super.a(paramh, paramub);
    h localh = (h)paramub.next();
    u.b(localh.b, z);
    localh.b = true;
    return localh.a;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.a.d
 * JD-Core Version:    0.7.0.1
 */