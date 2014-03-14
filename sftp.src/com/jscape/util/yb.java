package com.jscape.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class yb
  implements ThreadFactory
{
  private final String a;
  private final q b;
  private final AtomicInteger c;
  
  public static ThreadFactory a(String paramString)
  {
    return new yb(paramString, q.b);
  }
  
  public static ThreadFactory b(String paramString)
  {
    return new yb(paramString, q.a);
  }
  
  public yb(String paramString, q paramq)
  {
    u.a(paramString);
    this.a = paramString;
    this.c = new AtomicInteger(0);
    u.a(paramq);
    this.b = paramq;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    String str = String.format(this.a, new Object[] { Integer.valueOf(this.c.getAndIncrement()) });
    Thread localThread = new Thread(paramRunnable, str);
    this.b.a(localThread);
    return localThread;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.yb
 * JD-Core Version:    0.7.0.1
 */