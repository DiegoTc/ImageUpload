package com.jscape.util.f;

import com.jscape.util.cb;
import java.util.Iterator;
import java.util.List;

public class i<T, U>
  extends e<T, U>
{
  private final List<e<? super T, ? super U>> a = cb.c();
  
  public i(e<? super T, ? super U> parame1, e<? super T, ? super U> parame2)
  {
    b(parame1);
    b(parame2);
  }
  
  public boolean a(T paramT, U paramU)
  {
    int i = hb.a;
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      e locale = (e)localIterator.next();
      if (i != 0) {
        break label63;
      }
      if ((i != 0) || (locale.a(paramT, paramU))) {
        return true;
      }
    } while (i == 0);
    label63:
    return false;
  }
  
  private void b(e<? super T, ? super U> parame)
  {
    int i = hb.a;
    if (i == 0) {
      if ((parame instanceof i))
      {
        this.a.addAll(((i)parame).a);
        if (i == 0) {
          return;
        }
      }
    }
    this.a.add(parame);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.i
 * JD-Core Version:    0.7.0.1
 */