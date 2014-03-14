package com.jscape.ftcl.a;

import com.jscape.ftcl.i;
import java.util.Comparator;

class kb
  implements Comparator
{
  final m a;
  
  private kb(m paramm) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return a((i)paramObject1, (i)paramObject2);
  }
  
  public int a(i parami1, i parami2)
  {
    return parami1.b().compareTo(parami2.b());
  }
  
  kb(m paramm, jb paramjb)
  {
    this(paramm);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.a.kb
 * JD-Core Version:    0.7.0.1
 */