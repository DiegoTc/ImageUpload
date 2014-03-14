package com.jscape.inet.a;

import com.jscape.inet.a.a.c.a.hb;
import com.jscape.inet.a.a.c.a.ib;
import com.jscape.util.bc;

class m
  implements ib
{
  private final o a;
  
  private m(o paramo)
  {
    bc.a(paramo);
    this.a = paramo;
  }
  
  public void a(hb paramhb, long paramLong)
  {
    this.a.onTransferFileProgress(paramLong);
  }
  
  m(o paramo, l paraml)
  {
    this(paramo);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.m
 * JD-Core Version:    0.7.0.1
 */