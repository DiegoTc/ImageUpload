package com.jscape.ftcl.b.a.a;

import com.jscape.ftcl.b.a.cf;
import com.jscape.util.bc;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class j
  extends f
{
  private final Collection<f> b;
  private static final String z = -1;
  
  public j(Collection<f> paramCollection)
  {
    bc.a(paramCollection);
    this.b = paramCollection;
  }
  
  public j(f... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
  }
  
  public String b(cf paramcf)
    throws a
  {
    boolean bool = f.a;
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      f localf = (f)localIterator.next();
      if (bool) {
        break label65;
      }
      localStringBuilder.append(localf.a(paramcf));
    } while (!bool);
    label65:
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return z + this.b + '}';
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */