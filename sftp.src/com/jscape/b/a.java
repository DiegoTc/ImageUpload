package com.jscape.b;

import java.io.File;

public class a
{
  private boolean a = false;
  private g b;
  private File[] c;
  private int d;
  
  public a(File[] paramArrayOfFile, int paramInt)
  {
    this.c = paramArrayOfFile;
    this.d = paramInt;
  }
  
  public void b()
  {
    synchronized (this)
    {
      if (l.c == 0) {
        if (!this.a)
        {
          this.b = new g(this);
          this.b.start();
        }
      }
    }
  }
  
  public void c()
  {
    this.a = false;
  }
  
  static File[] a(a parama)
  {
    return parama.c;
  }
  
  static boolean a(a parama, boolean paramBoolean)
  {
    return parama.a = paramBoolean;
  }
  
  static int b(a parama)
  {
    return parama.d;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.b.a
 * JD-Core Version:    0.7.0.1
 */