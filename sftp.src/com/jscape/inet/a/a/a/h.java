package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.lb;
import com.jscape.inet.a.a.b.o;
import com.jscape.inet.a.a.b.yb;
import com.jscape.util.cb;
import com.jscape.util.g.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class h
  extends a
{
  private final jb c = new jb();
  
  public o a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    List localList = a(paramInputStream, i);
    return new lb(localList);
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    lb locallb = (lb)paramo;
    d.a(locallb.b.size(), paramOutputStream);
    a(locallb.b, paramOutputStream);
  }
  
  private List<yb> a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = a.b;
    List localList = cb.c();
    do
    {
      if (paramInt-- <= 0) {
        break;
      }
      yb localyb = this.c.a(paramInputStream);
      if (i != 0) {
        break label46;
      }
      localList.add(localyb);
    } while (i == 0);
    label46:
    return localList;
  }
  
  private void a(List<yb> paramList, OutputStream paramOutputStream)
    throws IOException
  {
    int i = a.b;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      yb localyb = (yb)localIterator.next();
      this.c.a(localyb, paramOutputStream);
    } while (i == 0);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */