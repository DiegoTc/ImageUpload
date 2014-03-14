package com.jscape.ftcl.b.a;

import com.jscape.filetransfer.Protocol;
import com.jscape.ftcl.b.a.a.a;
import com.jscape.ftcl.b.a.a.j;
import com.jscape.util.bc;

public class ne
  extends zc<sc>
{
  public final j b;
  private static final String z = -1;
  
  public ne(j paramj)
  {
    bc.a(paramj);
    this.b = paramj;
  }
  
  public void a(sc paramsc)
    throws Exception
  {
    paramsc.a(this);
  }
  
  public Protocol a(cf paramcf)
    throws a
  {
    String str = this.b.b(paramcf);
    try
    {
      return Protocol.protocolFor(str);
    }
    catch (Exception localException)
    {
      throw new a(localException);
    }
  }
  
  public String toString()
  {
    return z + this.b + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.ne
 * JD-Core Version:    0.7.0.1
 */