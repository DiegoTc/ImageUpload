package com.jscape.inet.a.a;

import com.jscape.inet.a.a.b.hb;
import com.jscape.inet.a.a.b.kb;
import com.jscape.inet.a.a.b.u;
import com.jscape.util.g.fc;
import com.jscape.util.g.yb;
import java.io.IOException;

 enum g
{
  g()
  {
    super(str, i, null);
  }
  
  public void a(k paramk, i parami)
    throws IOException
  {
    paramk.e();
    paramk.a(new hb());
    paramk.g();
    parami.a(paramk);
  }
  
  public fc a(k paramk, m paramm, String paramString, int paramInt)
    throws IOException
  {
    n localn = paramm.b();
    kb localkb = (kb)paramk.a(new u(paramString, paramInt, localn.a));
    byte[] arrayOfByte = paramm.a(localn, localkb.b, paramInt);
    return new yb(paramString, arrayOfByte);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.g
 * JD-Core Version:    0.7.0.1
 */