package com.jscape.util.g;

import com.jscape.util.u;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class vb
  implements qb<List<xb>>
{
  private final Manifest a;
  
  public vb(Manifest paramManifest)
  {
    u.a(paramManifest);
    this.a = paramManifest;
  }
  
  public void a(List<xb> paramList, OutputStream paramOutputStream)
    throws IOException
  {
    int i = m.d;
    JarOutputStream localJarOutputStream = new JarOutputStream(paramOutputStream, this.a);
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      xb localxb = (xb)localIterator.next();
      localxb.a(localJarOutputStream);
      if (i != 0) {
        return;
      }
    } while (i == 0);
    com.jscape.util.qb.a(localJarOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.vb
 * JD-Core Version:    0.7.0.1
 */