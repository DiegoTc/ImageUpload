package com.jscape.ftcl.b.a;

import com.jscape.filetransfer.TransferMode;
import com.jscape.ftcl.b.d;

 enum v
{
  v(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void b(d paramd, cf paramcf)
  {
    if (paramd.d() != null) {
      paramcf.a(this.u, paramd.d().name);
    }
  }
  
  public void a(cf paramcf, d paramd)
  {
    if (paramcf.c(this.u)) {
      paramd.a(TransferMode.modeFor((String)paramcf.d(this.u)));
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.v
 * JD-Core Version:    0.7.0.1
 */