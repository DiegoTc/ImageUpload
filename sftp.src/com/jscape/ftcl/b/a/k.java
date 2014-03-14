package com.jscape.ftcl.b.a;

import com.jscape.filetransfer.AftpSecurityMode;
import com.jscape.ftcl.b.d;

 enum k
{
  k(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void b(d paramd, cf paramcf)
  {
    if (paramd.g() != null) {
      paramcf.a(this.u, paramd.g().name);
    }
  }
  
  public void a(cf paramcf, d paramd)
  {
    if (paramcf.c(this.u)) {
      paramd.a(AftpSecurityMode.modeFor((String)paramcf.d(this.u)));
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.k
 * JD-Core Version:    0.7.0.1
 */