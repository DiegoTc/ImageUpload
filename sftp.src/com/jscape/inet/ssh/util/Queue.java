package com.jscape.inet.ssh.util;

import java.util.ArrayList;
import java.util.List;

public class Queue
{
  private final List a = new ArrayList();
  private boolean b;
  
  public synchronized Object get()
  {
    boolean bool = SshParameters.h;
    do
    {
      for (;;)
      {
        if (this.b) {
          break label43;
        }
        if ((bool) || (bool)) {
          break label56;
        }
        if (!this.a.isEmpty()) {
          break label43;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
    } while (!bool);
    label43:
    if (!bool) {}
    label56:
    return !this.a.isEmpty() ? this.a.remove(0) : null;
  }
  
  public synchronized void put(Object paramObject)
  {
    this.a.add(paramObject);
    notifyAll();
  }
  
  public synchronized void close()
  {
    this.b = true;
    notifyAll();
  }
  
  public boolean isClosed()
  {
    return this.b;
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.Queue
 * JD-Core Version:    0.7.0.1
 */