package com.jscape.util.e;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class e
  implements l
{
  private final Map<Integer, j> a = new HashMap();
  private static final String z = -1;
  
  public e(Collection<f> paramCollection)
  {
    a(paramCollection);
  }
  
  public e(f... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
  }
  
  public j a(j paramj, g paramg)
    throws b
  {
    Integer localInteger = b(paramj, paramg);
    j localj = (j)this.a.get(localInteger);
    a(paramj, paramg, localj);
    return localj;
  }
  
  public String toString()
  {
    return z + this.a + '}';
  }
  
  private void a(Collection<f> paramCollection)
  {
    int i = g.a;
    Iterator localIterator = paramCollection.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      f localf = (f)localIterator.next();
      Integer localInteger = a(localf.a, localf.b);
      this.a.put(localInteger, localf.c);
    } while (i == 0);
  }
  
  private Integer b(j paramj, g paramg)
  {
    return a(paramj, paramg.getClass());
  }
  
  private Integer a(j paramj, Class paramClass)
  {
    return Integer.valueOf(31 * paramj.hashCode() + paramClass.hashCode());
  }
  
  private void a(j paramj1, g paramg, j paramj2)
    throws b
  {
    if (paramj2 == null) {
      throw new b(paramj1, paramg);
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.e.e
 * JD-Core Version:    0.7.0.1
 */