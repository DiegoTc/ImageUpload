package com.jscape.util.f;

import com.jscape.util.cb;
import java.util.Iterator;
import java.util.List;

public class t
  extends q
{
  private final List<q> c = cb.c();
  
  public t(q paramq1, q paramq2)
  {
    b(paramq1);
    b(paramq2);
  }
  
  public boolean b()
  {
    int i = hb.a;
    Iterator localIterator = this.c.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      q localq = (q)localIterator.next();
      if (i != 0) {
        break label55;
      }
      if ((i != 0) || (!localq.b())) {
        return false;
      }
    } while (i == 0);
    label55:
    return true;
  }
  
  private void b(q paramq)
  {
    int i = hb.a;
    if (i == 0) {
      if ((paramq instanceof t))
      {
        this.c.addAll(((t)paramq).c);
        if (i == 0) {
          return;
        }
      }
    }
    this.c.add(paramq);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.t
 * JD-Core Version:    0.7.0.1
 */