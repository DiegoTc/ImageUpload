package com.jscape.util.f;

import com.jscape.util.cb;
import java.util.Iterator;
import java.util.List;

public class mb<T>
  extends hb<T>
{
  private final List<hb<? super T>> b = cb.c();
  
  public mb(hb<? super T> paramhb1, hb<? super T> paramhb2)
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
      if ((i != 0) || (localhb.a(paramT))) {
        return true;
      }
    } while (i == 0);
    label60:
    return false;
  }
  
  private void b(hb<? super T> paramhb)
  {
    int i = hb.a;
    if (i == 0) {
      if ((paramhb instanceof mb))
      {
        this.b.addAll(((mb)paramhb).b);
        if (i == 0) {
          return;
        }
      }
    }
    this.b.add(paramhb);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.mb
 * JD-Core Version:    0.7.0.1
 */