package com.jscape.inet.util;

class q
  extends Thread
{
  private boolean a;
  private long b;
  
  q(boolean paramBoolean, long paramLong)
  {
    this.a = paramBoolean;
    this.b = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if ((ConnectionParameters.t) || (paramBoolean)) {
      try
      {
        interrupt();
      }
      catch (Exception localException) {}
    }
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void run()
  {
    try
    {
      sleep(this.b);
      this.a = true;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.a = true;
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.q
 * JD-Core Version:    0.7.0.1
 */