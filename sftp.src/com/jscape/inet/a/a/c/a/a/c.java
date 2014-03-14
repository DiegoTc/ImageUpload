package com.jscape.inet.a.a.c.a.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.inet.a.a.c.a.b.m;
import com.jscape.util.g.a.d;
import com.jscape.util.g.a.n;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c
  implements hb<j>
{
  public j a(InputStream paramInputStream)
    throws IOException
  {
    int i = d.a(paramInputStream);
    int j = d.a(paramInputStream);
    int k = d.a(paramInputStream);
    int[] arrayOfInt = b(paramInputStream);
    return new m(i, j, k, arrayOfInt);
  }
  
  public void a(j paramj, OutputStream paramOutputStream)
    throws IOException
  {
    m localm = (m)paramj;
    d.a(localm.a, paramOutputStream);
    d.a(localm.e, paramOutputStream);
    d.a(localm.f, paramOutputStream);
    a(localm.g, paramOutputStream);
  }
  
  private int[] b(InputStream paramInputStream)
    throws IOException
  {
    int k = k.d;
    int i = n.a(paramInputStream) & 0xFFFF;
    int[] arrayOfInt = new int[i];
    int j = 0;
    do
    {
      if (j >= arrayOfInt.length) {
        break;
      }
      if (k != 0) {
        break label52;
      }
      arrayOfInt[j] = (n.a(paramInputStream) & 0xFFFF);
      j++;
    } while (k == 0);
    label52:
    return arrayOfInt;
  }
  
  private void a(int[] paramArrayOfInt, OutputStream paramOutputStream)
    throws IOException
  {
    int j = k.d;
    n.a((short)paramArrayOfInt.length, paramOutputStream);
    int i = 0;
    do
    {
      if (i >= paramArrayOfInt.length) {
        break;
      }
      n.a((short)paramArrayOfInt[i], paramOutputStream);
      i++;
    } while (j == 0);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */