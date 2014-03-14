package com.jscape.util.j.b;

import com.jscape.util.qb;
import java.net.Socket;

class d
  implements Runnable
{
  final Socket a;
  final k b;
  
  d(k paramk, Socket paramSocket) {}
  
  public void run()
  {
    try
    {
      this.b.b(this.a);
      i locali = new i(this.a);
      ((com.jscape.util.j.a.k)k.a(this.b)).a(this.b, locali);
    }
    catch (Exception localException)
    {
      qb.a(this.a);
      ((com.jscape.util.j.a.k)k.b(this.b)).a(this.b, localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.b.d
 * JD-Core Version:    0.7.0.1
 */