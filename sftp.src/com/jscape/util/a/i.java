package com.jscape.util.a;

import com.jscape.util.bc;
import com.jscape.util.u;
import com.jscape.util.ub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class i
{
  private final Map<l, String> a = new HashMap();
  
  public i(l... paramVarArgs)
  {
    l[] arrayOfl = paramVarArgs;
    int i = arrayOfl.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      l locall = arrayOfl[j];
      this.a.put(locall, null);
      j++;
    } while (!bool);
  }
  
  public i(Collection<l> paramCollection)
  {
    this((l[])paramCollection.toArray(new l[paramCollection.size()]));
  }
  
  public void a(String[] paramArrayOfString)
  {
    bc.a(paramArrayOfString);
    b(paramArrayOfString);
  }
  
  public l[] b()
  {
    Set localSet = this.a.keySet();
    return (l[])localSet.toArray(new l[localSet.size()]);
  }
  
  public String a(l paraml)
  {
    return (String)this.a.get(paraml);
  }
  
  public boolean b(l paraml)
  {
    return a(paraml) != null;
  }
  
  public String toString()
  {
    boolean bool = b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    l[] arrayOfl = b();
    Arrays.sort(arrayOfl);
    int i = 0;
    do
    {
      if (i >= arrayOfl.length) {
        break;
      }
      if (i > 0) {
        localStringBuilder.append(" ");
      }
      localStringBuilder.append(arrayOfl[i]);
      i++;
    } while (!bool);
    if (u.a) {
      b.i = !bool;
    }
    return localStringBuilder.toString();
  }
  
  private void b(String[] paramArrayOfString)
  {
    boolean bool = b.i;
    ub localub = c(paramArrayOfString);
    Set localSet = this.a.keySet();
    Iterator localIterator = localSet.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      l locall = (l)localIterator.next();
      String str = locall.a(localub);
      this.a.put(locall, str);
    } while (!bool);
  }
  
  private ub<h> c(String[] paramArrayOfString)
  {
    boolean bool = b.i;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramArrayOfString;
    int i = arrayOfString.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      String str = arrayOfString[j];
      localArrayList.add(new h(str));
      j++;
    } while (!bool);
    return new ub(localArrayList);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.a.i
 * JD-Core Version:    0.7.0.1
 */