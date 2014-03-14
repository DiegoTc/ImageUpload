package com.jscape.inet.a.a.c.a;

import java.util.concurrent.locks.LockSupport;

public class i
{
  private static final long a = 1000L;
  
  public static long b()
  {
    return System.nanoTime() / 1000L;
  }
  
  public static long a(long paramLong)
  {
    return b() - paramLong;
  }
  
  public static long b(long paramLong)
  {
    return b() + paramLong;
  }
  
  public static void c(long paramLong)
  {
    if ((u.r) || (paramLong > 0L)) {
      LockSupport.parkNanos(paramLong * 1000L);
    }
  }
  
  public static boolean d(long paramLong)
  {
    if (!u.r) {}
    return b() >= paramLong;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.i
 * JD-Core Version:    0.7.0.1
 */