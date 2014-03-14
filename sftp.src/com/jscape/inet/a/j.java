package com.jscape.inet.a;

import com.jscape.inet.a.a.c.a.hb;
import com.jscape.inet.a.a.c.a.ib;
import com.jscape.util.bc;

class j
  implements ib
{
  private final o a;
  
  private j(o paramo)
  {
    bc.a(paramo);
    this.a = paramo;
  }
  
  public void a(hb paramhb, long paramLong)
  {
    this.a.onTransferFileProgress(paramLong);
  }
  
  j(o paramo, i parami)
  {
    this(paramo);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.j
 * JD-Core Version:    0.7.0.1
 */