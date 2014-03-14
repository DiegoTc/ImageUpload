package com.jscape.ftcl.b.a.a;

import com.jscape.ftcl.b.a.cf;
import com.jscape.util.bc;

public class k
  extends f
{
  public final String b;
  private static final String z = -1;
  
  public k(String paramString)
  {
    bc.a(paramString);
    this.b = paramString;
  }
  
  public Object a(cf paramcf)
    throws a
  {
    try
    {
      return paramcf.d(this.b);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new b(this.b);
    }
    catch (Exception localException)
    {
      throw new a();
    }
  }
  
  public String toString()
  {
    return z + this.b + '\'' + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */