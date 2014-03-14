package com.jscape.ftcl.b;

import com.jscape.filetransfer.ComponentFileTransferFactory;
import com.jscape.filetransfer.FileTransferFactory;
import com.jscape.ftcl.b.a.cf;
import com.jscape.ftcl.b.a.tb;
import com.jscape.ftcl.b.a.y;
import com.jscape.ftcl.b.a.zc;
import com.jscape.util.a.j;
import com.jscape.util.bc;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class e
  implements f
{
  private static final String a = -1;
  private final FileTransferFactory b;
  private final j c;
  
  public static f b()
  {
    return new e(ComponentFileTransferFactory.defaultFactory(), j.b());
  }
  
  public e(FileTransferFactory paramFileTransferFactory, j paramj)
  {
    bc.a(paramFileTransferFactory);
    this.b = paramFileTransferFactory;
    bc.a(paramj);
    this.c = paramj;
  }
  
  public void a(InputStream paramInputStream, d paramd, cf paramcf)
    throws b
  {
    int i = d.m;
    g localg = new g(paramd, this.b, paramcf, this.c);
    try
    {
      tb localtb = new tb(paramInputStream, a);
      localtb.a(paramcf);
      Iterator localIterator = localtb.b().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        zc localzc = (zc)localIterator.next();
        localg.a(localzc);
        if (i != 0) {
          return;
        }
      } while (i == 0);
    }
    catch (y localy)
    {
      throw new c(localy.getMessage());
    }
    catch (Exception localException)
    {
      throw new b(localException);
    }
    finally
    {
      localg.b();
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.e
 * JD-Core Version:    0.7.0.1
 */