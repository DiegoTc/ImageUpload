package com.jscape.ftcl.b.a;

import com.jscape.util.bc;
import java.util.HashMap;
import java.util.Map;

public class cf
{
  private static final Object a;
  private final Map<String, Object> b = new HashMap();
  private static final String z = -1;
  
  public void a(String paramString)
  {
    if ((zc.a != 0) || (!b(paramString))) {
      a(paramString, a);
    }
  }
  
  public boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    bc.a(paramString);
    this.b.put(paramString, paramObject);
  }
  
  public boolean c(String paramString)
  {
    return (zc.a != 0) || ((b(paramString)) && (this.b.get(paramString) != a));
  }
  
  public <T> T d(String paramString)
  {
    Object localObject = this.b.get(paramString);
    b(paramString, localObject);
    return localObject;
  }
  
  public String toString()
  {
    return z + this.b + '}';
  }
  
  private void b(String paramString, Object paramObject)
  {
    if ((zc.a != 0) || ((!this.b.containsKey(paramString)) || (paramObject == a))) {
      throw new IllegalArgumentException();
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.cf
 * JD-Core Version:    0.7.0.1
 */