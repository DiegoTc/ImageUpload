package com.jscape.inet.util;

import java.net.Socket;

final class p
  implements Runnable
{
  final Socket[] a;
  final String b;
  final int c;
  final Exception[] d;
  
  p(Socket[] paramArrayOfSocket, String paramString, int paramInt, Exception[] paramArrayOfException) {}
  
  public void run()
  {
    this.a[0] = null;
    try
    {
      this.a[0] = new Socket(this.b, this.c);
    }
    catch (Exception localException1)
    {
      this.d[0] = localException1;
      if (!ConnectionParameters.t) {
        if (this.a[0] != null) {
          try
          {
            this.a[0].close();
          }
          catch (Exception localException2) {}
        }
      }
      this.a[0] = null;
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.p
 * JD-Core Version:    0.7.0.1
 */