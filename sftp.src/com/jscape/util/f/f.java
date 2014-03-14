package com.jscape.util.f;

import com.jscape.util.cb;
import java.util.Iterator;
import java.util.List;

public class f<T, U>
  extends e<T, U>
{
  private final List<e<? super T, ? super U>> a = cb.c();
  
  public f(e<? super T, ? super U> parame1, e<? super T, ? super U> parame2)
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
      if ((i != 0) || (!locale.a(paramT, paramU))) {
        return false;
      }
    } while (i == 0);
    label63:
    return true;
  }
  
  private void b(e<? super T, ? super U> parame)
  {
    int i = hb.a;
    if (i == 0) {
      if ((parame instanceof f))
      {
        this.a.addAll(((f)parame).a);
        if (i == 0) {
          return;
        }
      }
    }
    this.a.add(parame);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.f
 * JD-Core Version:    0.7.0.1
 */