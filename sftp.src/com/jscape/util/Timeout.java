package com.jscape.util;

public class Timeout
{
  private final long a;
  private final long b;
  private volatile boolean c;
  private Thread d;
  private static final String z = -1;
  
  public static void waitUntilExceeded(long paramLong)
  {
    new Timeout(paramLong).waitUntilExceeded();
  }
  
  public Timeout(long paramLong)
  {
    u.a(paramLong, 0L, z);
    this.a = paramLong;
    this.b = (fb.c() + this.a);
  }
  
  public long getValue()
  {
    return this.a;
  }
  
  public long remainedTime()
  {
    return this.b - fb.c();
  }
  
  public boolean isExceeded()
  {
    if (!bc.a) {}
    return fb.c() > this.b;
  }
  
  public void cancel()
  {
    this.c = true;
    if ((bc.a) || (this.d != null)) {
      this.d.interrupt();
    }
  }
  
  public synchronized void waitUntilExceeded()
  {
    boolean bool = bc.a;
    this.d = Thread.currentThread();
    do
    {
      if ((isExceeded()) || ((!bool) && (this.c))) {
        break;
      }
      long l = remainedTime();
      try
      {
        if (!bool) {}
        Thread.sleep(l > 0L ? l : 0L);
      }
      catch (InterruptedException localInterruptedException) {}
    } while (!bool);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.Timeout
 * JD-Core Version:    0.7.0.1
 */