package com.jscape.inet.util;

import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class g
{
  private final InputStreamReader a;
  private final String b;
  private int c = 0;
  private boolean d;
  private boolean e = false;
  
  public g(InputStream paramInputStream, String paramString)
  {
    u.a(paramInputStream);
    u.a(paramString);
    this.a = new InputStreamReader(paramInputStream);
    this.b = paramString;
  }
  
  public synchronized String b()
    throws IOException
  {
    boolean bool = ConnectionParameters.t;
    this.e = false;
    if (this.d) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    i = this.a.read();
    do
    {
      if (i <= -1) {
        break;
      }
      localStringBuffer.append((char)i);
      int j = localStringBuffer.toString().indexOf(this.b);
      if (bool) {
        break label138;
      }
      if (!bool) {
        if (j == 0)
        {
          localStringBuffer.delete(j, localStringBuffer.length());
          this.e = true;
          if (!bool) {
            break;
          }
        }
      }
      if (!bool) {
        if (j > 0)
        {
          localStringBuffer.delete(j, localStringBuffer.length());
          this.e = true;
          if (!bool) {
            break;
          }
        }
      }
      i = this.a.read();
    } while (!bool);
    label138:
    if (!bool)
    {
      if (i == -1) {
        this.d = true;
      }
      if (bool) {}
    }
    else if (this.d)
    {
      if (bool) {
        break label189;
      }
      if (localStringBuffer.length() == 0) {
        return null;
      }
    }
    this.c += 1;
    label189:
    return localStringBuffer.toString();
  }
  
  public synchronized long c()
  {
    return this.c;
  }
  
  public synchronized void d()
    throws IOException
  {
    this.a.close();
  }
  
  public synchronized void e()
  {
    try
    {
      d();
    }
    catch (IOException localIOException) {}
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.g
 * JD-Core Version:    0.7.0.1
 */