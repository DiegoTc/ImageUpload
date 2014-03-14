package com.jscape.ftcl.b.a;

import com.jscape.filetransfer.Protocol;
import com.jscape.ftcl.b.d;

 enum n
{
  n(String paramString)
  {
    super(???, i, paramString, null);
  }
  
  public void b(d paramd, cf paramcf)
  {
    if (paramd.getProtocol() != null) {
      paramcf.a(this.u, Boolean.valueOf(paramd.getProtocol() == Protocol.SFTP));
    }
  }
  
  public void a(cf paramcf, d paramd)
  {
    if ((zc.a != 0) || ((paramcf.c(this.u)) && (((Boolean)paramcf.d(this.u)).booleanValue()))) {
      paramd.setProtocol(Protocol.SFTP);
    }
  }
  
  public Object c(String paramString)
  {
    return Boolean.valueOf(paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.n
 * JD-Core Version:    0.7.0.1
 */