package com.jscape.ftcl.b.a;

import com.jscape.ftcl.b.d;
import com.jscape.util.ec;

 enum m
{
  m(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void b(d paramd, cf paramcf)
  {
    if (paramd.l() != null) {
      paramcf.a(this.u, ec.a(",", paramd.l()));
    }
  }
  
  public void a(cf paramcf, d paramd)
  {
    if (paramcf.c(this.u)) {
      paramd.a(((String)paramcf.d(this.u)).split(","));
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.m
 * JD-Core Version:    0.7.0.1
 */