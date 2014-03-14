package com.jscape.util.g;

import com.jscape.util.u;

public class tb
  implements nb<String>
{
  private final nb<String> a;
  private final String b;
  
  public tb(nb<String> paramnb, String paramString)
  {
    u.a(paramnb);
    this.a = paramnb;
    u.a(paramString);
    this.b = paramString;
  }
  
  public mb a(String paramString)
    throws s
  {
    return rb.a(this.a.a(paramString), this.b);
  }
  
  public void b() {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.tb
 * JD-Core Version:    0.7.0.1
 */