package com.jscape.util;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

class wb
{
  private static final wb a = new wb(System.out);
  private static final Map b = new HashMap();
  private final PrintStream c;
  private int d;
  
  public static synchronized wb a(PrintStream paramPrintStream)
  {
    u.a(paramPrintStream);
    if (paramPrintStream == System.out) {
      return a;
    }
    if ((bc.a) || (b.containsKey(paramPrintStream)))
    {
      localwb = (wb)b.get(paramPrintStream);
      localwb.b();
      return localwb;
    }
    wb localwb = new wb(paramPrintStream);
    b.put(paramPrintStream, localwb);
    return localwb;
  }
  
  private wb(PrintStream paramPrintStream)
  {
    this.c = paramPrintStream;
    this.d = 1;
  }
  
  private synchronized void b()
  {
    this.d += 1;
  }
  
  private synchronized void c()
  {
    this.d -= 1;
  }
  
  public synchronized void a(String paramString)
  {
    if (!bc.a) {
      if (e()) {
        return;
      }
    }
    this.c.println(paramString);
  }
  
  public synchronized void d()
  {
    boolean bool = bc.a;
    if (!bool)
    {
      if (this == a) {
        return;
      }
      c();
    }
    if ((bool) || (this.d == 0)) {
      this.c.close();
    }
  }
  
  public synchronized boolean e()
  {
    if (!bc.a) {}
    return this.d == 0;
  }
  
  public PrintStream f()
  {
    return this.c;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.wb
 * JD-Core Version:    0.7.0.1
 */