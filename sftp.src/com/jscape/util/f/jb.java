package com.jscape.util.f;

import com.jscape.util.cb;
import java.util.Iterator;
import java.util.List;

public class jb<T>
  extends hb<T>
{
  private final List<hb<? super T>> b = cb.c();
  
  public jb(hb<? super T> paramhb1, hb<? super T> paramhb2)
  {
    b(paramhb1);
    b(paramhb2);
  }
  
  public boolean a(T paramT)
  {
    int i = hb.a;
    Iterator localIterator = this.b.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      hb localhb = (hb)localIterator.next();
      if (i != 0) {
        break label60;
      }
      if ((i != 0) || (!localhb.a(paramT))) {
        return false;
      }
    } while (i == 0);
    label60:
    return true;
  }
  
  private void b(hb<? super T> paramhb)
  {
    int i = hb.a;
    if (i == 0) {
      if ((paramhb instanceof jb))
      {
        this.b.addAll(((jb)paramhb).b);
        if (i == 0) {
          return;
        }
      }
    }
    this.b.add(paramhb);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.jb
 * JD-Core Version:    0.7.0.1
 */