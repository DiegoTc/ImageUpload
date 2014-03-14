package com.jscape.util.g;

import com.jscape.util.u;

public class sb
  implements nb<String>
{
  private final nb<String> a;
  private final byte[] b;
  private final byte[] c;
  
  public sb(nb<String> paramnb, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    u.a(paramnb);
    this.a = paramnb;
    u.a(paramArrayOfByte1);
    this.b = paramArrayOfByte1;
    u.a(paramArrayOfByte2);
    this.c = paramArrayOfByte2;
  }
  
  public mb a(String paramString)
    throws s
  {
    return rb.a(this.a.a(paramString), this.b, this.c);
  }
  
  public void b() {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.sb
 * JD-Core Version:    0.7.0.1
 */