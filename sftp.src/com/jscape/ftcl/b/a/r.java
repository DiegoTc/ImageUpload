package com.jscape.ftcl.b.a;

import com.jscape.ftcl.b.d;
import com.jscape.util.gc;

 enum r
{
  r(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void b(d paramd, cf paramcf)
  {
    if (paramd.getConnectionTimeout() != null) {
      paramcf.a(this.u, Integer.valueOf((int)paramd.getConnectionTimeout().e()));
    }
  }
  
  public void a(cf paramcf, d paramd)
  {
    if (paramcf.c(this.u)) {
      paramd.setConnectionTimeout(gc.d(((Integer)paramcf.d(this.u)).intValue()));
    }
  }
  
  public Object c(String paramString)
  {
    return Integer.valueOf(paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.r
 * JD-Core Version:    0.7.0.1
 */