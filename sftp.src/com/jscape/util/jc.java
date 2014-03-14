package com.jscape.util;

import java.io.PrintStream;

class jc
  extends Thread
{
  private volatile boolean a;
  private char b = '*';
  
  public jc(String paramString)
  {
    System.out.print(paramString);
  }
  
  public void run()
  {
    boolean bool = bc.a;
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    try
    {
      this.a = true;
      while (this.a)
      {
        System.out.print("\b" + this.b);
        try
        {
          Thread.currentThread();
          Thread.sleep(1L);
          if (bool) {}
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
          return;
        }
      }
    }
    finally
    {
      Thread.currentThread().setPriority(i);
    }
  }
  
  public void b()
  {
    this.a = false;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.jc
 * JD-Core Version:    0.7.0.1
 */