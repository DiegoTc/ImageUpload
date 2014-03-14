package com.jscape.util;

public class fb
{
  private static gb a = new hb();
  
  public static gb b()
  {
    return a;
  }
  
  public static void a(gb paramgb)
  {
    a = paramgb;
  }
  
  public static long c()
  {
    return a.b();
  }
  
  public static boolean a(long paramLong)
  {
    if (!bc.a) {}
    return c() <= paramLong;
  }
  
  public static boolean b(long paramLong)
  {
    if (!bc.a) {}
    return paramLong <= c();
  }
  
  public static long c(long paramLong)
  {
    return c() + paramLong;
  }
  
  public static long d(long paramLong)
  {
    return c() - paramLong;
  }
  
  public static long e(long paramLong)
  {
    return c() - paramLong;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.fb
 * JD-Core Version:    0.7.0.1
 */