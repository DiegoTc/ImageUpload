package com.jscape.util.a;

import com.jscape.util.bc;
import java.io.PrintStream;

public class k
  implements Runnable
{
  private static final String a = "\b";
  private static final String b = -1;
  private final PrintStream c;
  private final String d;
  private Thread e;
  private int f;
  private volatile boolean g;
  
  public k(PrintStream paramPrintStream, String paramString)
  {
    bc.a(paramPrintStream);
    this.c = paramPrintStream;
    this.d = ("\b" + paramString);
  }
  
  public void b()
  {
    this.e = new Thread(this, b);
    this.e.start();
  }
  
  public void c()
  {
    this.g = true;
  }
  
  public void run()
  {
    boolean bool = b.i;
    this.g = false;
    d();
    try
    {
      do
      {
        if (this.g) {
          break;
        }
        f();
        g();
        if (bool) {
          return;
        }
      } while (!bool);
    }
    finally
    {
      e();
      h();
    }
  }
  
  private void d()
  {
    this.f = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
  }
  
  private void e()
  {
    Thread.currentThread().setPriority(this.f);
  }
  
  private void f()
  {
    this.c.print(this.d);
  }
  
  private void g()
  {
    try
    {
      Thread.sleep(1L);
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      this.g = true;
    }
  }
  
  private void h()
  {
    this.e = null;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.a.k
 * JD-Core Version:    0.7.0.1
 */