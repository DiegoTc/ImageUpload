package com.jscape.ftcl.b.a;

import com.jscape.ftcl.b.d;
import com.jscape.util.x;

 enum j
{
  j(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void b(d paramd, cf paramcf)
  {
    if (paramd.h() != null) {
      paramcf.a(this.u, Integer.valueOf((int)paramd.h().a));
    }
  }
  
  public void a(cf paramcf, d paramd)
  {
    if (paramcf.c(this.u)) {
      paramd.a(x.b(((Integer)paramcf.d(this.u)).intValue()));
    }
  }
  
  public Object c(String paramString)
  {
    return Integer.valueOf(paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.j
 * JD-Core Version:    0.7.0.1
 */