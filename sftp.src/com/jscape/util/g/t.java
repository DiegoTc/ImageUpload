package com.jscape.util.g;

import com.jscape.util.f.hb;
import java.util.List;

public class t
  extends hb<Object>
{
  private final List<String> b;
  private static final String z = -1;
  
  public t(List<String> paramList)
  {
    this.b = paramList;
  }
  
  public boolean a(Object paramObject)
  {
    return this.b.contains(paramObject.toString());
  }
  
  public String toString()
  {
    return z + this.b + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.t
 * JD-Core Version:    0.7.0.1
 */