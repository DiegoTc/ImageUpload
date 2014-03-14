package com.jscape.b;

import java.io.File;

public class d
{
  private boolean a = false;
  private File b;
  private h c;
  private int d;
  
  public d(File paramFile, int paramInt)
  {
    this.b = paramFile;
    this.d = paramInt;
  }
  
  public void b()
  {
    synchronized (this)
    {
      if (l.c == 0) {
        if (!this.a)
        {
          this.c = new h(this);
          this.c.start();
        }
      }
    }
  }
  
  public void c()
  {
    this.a = false;
  }
  
  static boolean a(d paramd, boolean paramBoolean)
  {
    return paramd.a = paramBoolean;
  }
  
  static File a(d paramd)
  {
    return paramd.b;
  }
  
  static boolean b(d paramd)
  {
    return paramd.a;
  }
  
  static int c(d paramd)
  {
    return paramd.d;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.b.d
 * JD-Core Version:    0.7.0.1
 */