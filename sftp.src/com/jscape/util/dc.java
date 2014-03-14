package com.jscape.util;

import java.io.Serializable;

public class dc
  implements Serializable
{
  private eb a;
  
  public dc(long paramLong1, long paramLong2)
  {
    this.a = new eb(paramLong1, paramLong2, true);
  }
  
  public dc(dc paramdc)
  {
    this(paramdc.b(), paramdc.c());
  }
  
  public long b()
  {
    return this.a.b();
  }
  
  public long c()
  {
    return this.a.c();
  }
  
  public synchronized long d()
  {
    long l = this.a.e();
    this.a.h();
    return l;
  }
  
  public synchronized long e()
  {
    long l = this.a.e();
    this.a.i();
    return l;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = bc.a;
    if (!bool) {
      if (this == paramObject) {
        return true;
      }
    }
    if (paramObject != null)
    {
      if (bool) {
        break label40;
      }
      if (getClass().equals(paramObject.getClass())) {}
    }
    else
    {
      return false;
    }
    label40:
    dc localdc = (dc)paramObject;
    if (!bool) {
      if (!this.a.equals(localdc.a)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.dc
 * JD-Core Version:    0.7.0.1
 */