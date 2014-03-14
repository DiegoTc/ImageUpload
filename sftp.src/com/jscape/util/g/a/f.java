package com.jscape.util.g.a;

import com.jscape.util.ec;
import com.jscape.util.g.hb;
import com.jscape.util.g.m;
import com.jscape.util.t;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class f
  implements hb<String>
{
  private final byte[] a;
  private final String b;
  private static final String z = -1;
  
  public static void a(String paramString1, byte[] paramArrayOfByte, String paramString2, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = ec.b(paramString1, paramString2);
    paramOutputStream.write(arrayOfByte);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString, InputStream paramInputStream)
    throws IOException
  {
    int j = d.b;
    m localm = new m();
    int i;
    while (!a(i = paramInputStream.read()))
    {
      localm.write(i);
      if (a(localm, paramArrayOfByte)) {
        break;
      }
    }
    if (j == 0) {
      if (!a(i)) {
        localm.a(localm.c() - paramArrayOfByte.length);
      }
    }
    if (j == 0)
    {
      if (!a(i)) {
        break label96;
      }
      if (j != 0) {
        break label97;
      }
    }
    label96:
    label97:
    if (u.a) {
      d.b = ++j;
    }
    return localm.f() ? null : ec.a(localm.b(), 0, localm.c(), paramString);
  }
  
  public static String a(String paramString, InputStream paramInputStream)
    throws IOException
  {
    int j = d.b;
    if (!paramInputStream.markSupported()) {
      throw new IOException(z);
    }
    m localm = new m();
    int i;
    while (!a(i = paramInputStream.read()))
    {
      localm.write(i);
      if (a(localm))
      {
        a(localm, paramInputStream);
        if (j != 0) {
          break label90;
        }
      }
    }
    if (j == 0) {
      if (!a(i)) {
        localm.a(localm.c() - 1);
      }
    }
    label90:
    if (j == 0)
    {
      if (!a(i)) {
        break label118;
      }
      if (j != 0) {
        break label119;
      }
    }
    label118:
    label119:
    if (j != 0) {
      u.a = !u.a;
    }
    return localm.f() ? null : ec.a(localm.b(), 0, localm.c(), paramString);
  }
  
  private static boolean a(int paramInt)
  {
    if (d.b == 0) {}
    return paramInt == -1;
  }
  
  private static boolean a(m paramm, byte[] paramArrayOfByte)
  {
    int i = d.b;
    if ((i != 0) || (paramm.c() >= paramArrayOfByte.length)) {
      if (i != 0) {}
    }
    return t.b(paramm.b(), paramArrayOfByte, paramm.c());
  }
  
  private static boolean a(m paramm)
  {
    int j = d.b;
    int i = paramm.b()[(paramm.c() - 1)];
    if (j == 0) {
      if (i != 13) {
        if (j != 0) {
          break label37;
        }
      }
    }
    label37:
    return i == 10;
  }
  
  private static void a(m paramm, InputStream paramInputStream)
    throws IOException
  {
    int k = d.b;
    int i = paramm.b()[(paramm.c() - 1)];
    if (k == 0)
    {
      if (i != 13) {
        return;
      }
      paramInputStream.mark(1);
    }
    int j = paramInputStream.read();
    if (((k != 0) || (!a(j))) && (j != 10)) {
      paramInputStream.reset();
    }
  }
  
  public f(byte[] paramArrayOfByte, String paramString)
  {
    u.a(paramArrayOfByte);
    this.a = paramArrayOfByte;
    u.a(paramString);
    this.b = paramString;
  }
  
  public String a(InputStream paramInputStream)
    throws IOException
  {
    return a(this.a, this.b, paramInputStream);
  }
  
  public void a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramString, this.a, this.b, paramOutputStream);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.f
 * JD-Core Version:    0.7.0.1
 */