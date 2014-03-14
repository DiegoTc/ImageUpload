package com.jscape.ftcl.b.a;

import com.jscape.filetransfer.Protocol;
import com.jscape.ftcl.b.d;

 enum c
{
  c(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void b(d paramd, cf paramcf)
  {
    if (paramd.getProtocol() != null) {
      paramcf.a(this.u, paramd.getProtocol().name);
    }
  }
  
  public void a(cf paramcf, d paramd)
  {
    if (paramcf.c(this.u)) {
      paramd.setProtocol(Protocol.protocolFor((String)paramcf.d(this.u)));
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.c
 * JD-Core Version:    0.7.0.1
 */