package com.jscape.ftcl.b.a;

import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class yc
{
  public static final boolean a = false;
  int b;
  int c;
  int d;
  public int e = -1;
  protected int[] f;
  protected int[] g;
  protected int h = 0;
  protected int i = 1;
  protected boolean j = false;
  protected boolean k = false;
  protected Reader l;
  protected char[] m;
  protected int n = 0;
  protected int o = 0;
  protected int p = 8;
  
  protected void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  protected int b(int paramInt)
  {
    return this.p;
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1 = zc.a;
    char[] arrayOfChar = new char[this.b + 2048];
    int[] arrayOfInt1 = new int[this.b + 2048];
    int[] arrayOfInt2 = new int[this.b + 2048];
    try
    {
      if (i1 == 0)
      {
        if (paramBoolean)
        {
          System.arraycopy(this.m, this.d, arrayOfChar, 0, this.b - this.d);
          System.arraycopy(this.m, 0, arrayOfChar, this.b - this.d, this.e);
          this.m = arrayOfChar;
          System.arraycopy(this.f, this.d, arrayOfInt1, 0, this.b - this.d);
          System.arraycopy(this.f, 0, arrayOfInt1, this.b - this.d, this.e);
          this.f = arrayOfInt1;
          System.arraycopy(this.g, this.d, arrayOfInt2, 0, this.b - this.d);
          System.arraycopy(this.g, 0, arrayOfInt2, this.b - this.d, this.e);
          this.g = arrayOfInt2;
          this.e += this.b - this.d;
          this.n = this.e;
          if (i1 != 0) {
            u.a = !u.a;
          }
        }
        else
        {
          System.arraycopy(this.m, this.d, arrayOfChar, 0, this.b - this.d);
          this.m = arrayOfChar;
          System.arraycopy(this.f, this.d, arrayOfInt1, 0, this.b - this.d);
          this.f = arrayOfInt1;
          System.arraycopy(this.g, this.d, arrayOfInt2, 0, this.b - this.d);
          this.g = arrayOfInt2;
          this.e -= this.d;
        }
      }
      else {
        this.n = this.e;
      }
    }
    catch (Throwable localThrowable)
    {
      throw new Error(localThrowable.getMessage());
    }
    this.b += 2048;
    this.c = this.b;
    this.d = 0;
  }
  
  protected void b()
    throws IOException
  {
    int i2 = zc.a;
    if (i2 == 0) {
      if (this.n == this.c)
      {
        if (i2 == 0) {
          if (this.c == this.b)
          {
            if (i2 == 0)
            {
              if (this.d > 2048)
              {
                this.e = (this.n = 0);
                this.c = this.d;
                if (i2 == 0) {
                  break label167;
                }
              }
              if (i2 != 0) {}
            }
            else if (this.d < 0)
            {
              this.e = (this.n = 0);
              if (i2 == 0) {
                break label167;
              }
            }
            a(false);
            if (i2 == 0) {
              break label167;
            }
          }
        }
        if (i2 == 0)
        {
          if (this.c > this.d)
          {
            this.c = this.b;
            if (i2 == 0) {
              break label167;
            }
          }
          if (i2 != 0) {}
        }
        else if (this.d - this.c < 2048)
        {
          a(true);
          if (i2 == 0) {
            break label167;
          }
        }
        this.c = this.d;
      }
    }
    try
    {
      label167:
      int i1;
      if ((i1 = this.l.read(this.m, this.n, this.c - this.n)) == -1)
      {
        this.l.close();
        throw new IOException();
      }
      this.n += i1;
      return;
    }
    catch (IOException localIOException)
    {
      this.e -= 1;
      c(0);
      if ((i2 != 0) || (this.d == -1)) {
        this.d = this.e;
      }
      throw localIOException;
    }
  }
  
  public char c()
    throws IOException
  {
    this.d = -1;
    char c1 = d();
    this.d = this.e;
    return c1;
  }
  
  protected void a(char paramChar)
  {
    int i1 = zc.a;
    this.h += 1;
    if (i1 == 0) {
      if (this.k)
      {
        this.k = false;
        this.i += (this.h = 1);
        if (i1 == 0) {
          break label99;
        }
      }
    }
    if (i1 == 0) {
      if (this.j)
      {
        if (i1 == 0)
        {
          this.j = false;
          if (paramChar == '\n')
          {
            this.k = true;
            if (i1 == 0) {
              break label99;
            }
          }
        }
        this.i += (this.h = 1);
      }
    }
    switch (paramChar)
    {
    case '\r': 
      this.j = true;
      if (i1 == 0) {
        break;
      }
    case '\n': 
      this.k = true;
      if (i1 == 0) {
        break;
      }
    case '\t': 
      label99:
      this.h -= 1;
      this.h += this.p - this.h % this.p;
      break;
    }
    this.f[this.e] = this.i;
    this.g[this.e] = this.h;
  }
  
  public char d()
    throws IOException
  {
    int i1 = zc.a;
    if (i1 == 0) {
      if (this.o > 0)
      {
        this.o -= 1;
        if (i1 == 0) {
          if (++this.e == this.b) {
            this.e = 0;
          }
        }
        return this.m[this.e];
      }
    }
    if (i1 == 0) {
      if (++this.e >= this.n) {
        b();
      }
    }
    char c1 = this.m[this.e];
    a(c1);
    return c1;
  }
  
  @Deprecated
  public int e()
  {
    return this.g[this.e];
  }
  
  @Deprecated
  public int f()
  {
    return this.f[this.e];
  }
  
  public int g()
  {
    return this.g[this.e];
  }
  
  public int h()
  {
    return this.f[this.e];
  }
  
  public int i()
  {
    return this.g[this.d];
  }
  
  public int j()
  {
    return this.f[this.d];
  }
  
  public void c(int paramInt)
  {
    this.o += paramInt;
    this.e -= paramInt;
    if ((zc.a != 0) || (this.e < 0)) {
      this.e += this.b;
    }
  }
  
  public yc(Reader paramReader, int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = paramReader;
    this.i = paramInt1;
    this.h = (paramInt2 - 1);
    this.c = (this.b = paramInt3);
    this.m = new char[paramInt3];
    this.f = new int[paramInt3];
    this.g = new int[paramInt3];
  }
  
  public yc(Reader paramReader, int paramInt1, int paramInt2)
  {
    this(paramReader, paramInt1, paramInt2, 4096);
  }
  
  public yc(Reader paramReader)
  {
    this(paramReader, 1, 1, 4096);
  }
  
  public void a(Reader paramReader, int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = paramReader;
    this.i = paramInt1;
    this.h = (paramInt2 - 1);
    if (zc.a == 0)
    {
      if ((this.m == null) || (paramInt3 != this.m.length))
      {
        this.c = (this.b = paramInt3);
        this.m = new char[paramInt3];
        this.f = new int[paramInt3];
      }
    }
    else {
      this.g = new int[paramInt3];
    }
    this.k = (this.j = 0);
    this.d = (this.o = this.n = 0);
    this.e = -1;
  }
  
  public void a(Reader paramReader, int paramInt1, int paramInt2)
  {
    a(paramReader, paramInt1, paramInt2, 4096);
  }
  
  public void a(Reader paramReader)
  {
    a(paramReader, 1, 1, 4096);
  }
  
  public yc(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws UnsupportedEncodingException
  {
    this(paramString == null ? new InputStreamReader(paramInputStream, Charset.defaultCharset()) : new InputStreamReader(paramInputStream, paramString), paramInt1, paramInt2, paramInt3);
  }
  
  public yc(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    this(new InputStreamReader(paramInputStream, Charset.defaultCharset()), paramInt1, paramInt2, paramInt3);
  }
  
  public yc(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2)
    throws UnsupportedEncodingException
  {
    this(paramInputStream, paramString, paramInt1, paramInt2, 4096);
  }
  
  public yc(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    this(paramInputStream, paramInt1, paramInt2, 4096);
  }
  
  public yc(InputStream paramInputStream, String paramString)
    throws UnsupportedEncodingException
  {
    this(paramInputStream, paramString, 1, 1, 4096);
  }
  
  public yc(InputStream paramInputStream)
  {
    this(paramInputStream, 1, 1, 4096);
  }
  
  public void a(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws UnsupportedEncodingException
  {
    a(paramString == null ? new InputStreamReader(paramInputStream, Charset.defaultCharset()) : new InputStreamReader(paramInputStream, paramString), paramInt1, paramInt2, paramInt3);
  }
  
  public void a(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    a(new InputStreamReader(paramInputStream, Charset.defaultCharset()), paramInt1, paramInt2, paramInt3);
  }
  
  public void a(InputStream paramInputStream, String paramString)
    throws UnsupportedEncodingException
  {
    a(paramInputStream, paramString, 1, 1, 4096);
  }
  
  public void a(InputStream paramInputStream)
  {
    a(paramInputStream, 1, 1, 4096);
  }
  
  public void a(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2)
    throws UnsupportedEncodingException
  {
    a(paramInputStream, paramString, paramInt1, paramInt2, 4096);
  }
  
  public void a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    a(paramInputStream, paramInt1, paramInt2, 4096);
  }
  
  public String k()
  {
    if (this.e >= this.d) {
      return new String(this.m, this.d, this.e - this.d + 1);
    }
    return new String(this.m, this.d, this.b - this.d) + new String(this.m, 0, this.e + 1);
  }
  
  public char[] d(int paramInt)
  {
    int i1 = zc.a;
    char[] arrayOfChar = new char[paramInt];
    if (i1 == 0)
    {
      if (this.e + 1 >= paramInt)
      {
        System.arraycopy(this.m, this.e - paramInt + 1, arrayOfChar, 0, paramInt);
        if (i1 == 0) {}
      }
      else
      {
        System.arraycopy(this.m, this.b - (paramInt - this.e - 1), arrayOfChar, 0, paramInt - this.e - 1);
      }
    }
    else {
      System.arraycopy(this.m, 0, arrayOfChar, paramInt - this.e - 1, this.e + 1);
    }
    return arrayOfChar;
  }
  
  public void l()
  {
    this.m = null;
    this.f = null;
    this.g = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i8 = zc.a;
    int i1 = this.d;
    if (i8 == 0) {
      if (this.e >= this.d)
      {
        i2 = this.e - this.d + this.o + 1;
        if (i8 == 0) {
          break label72;
        }
      }
    }
    int i2 = this.b - this.d + this.e + 1 + this.o;
    label72:
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    do
    {
      if (i3 >= i2) {
        break;
      }
      if ((i8 != 0) || (i8 != 0)) {
        break label193;
      }
      if (this.f[(i4 = i1 % this.b)] != this.f[(i5 = ++i1 % this.b)]) {
        break;
      }
      this.f[i4] = paramInt1;
      i6 = i7 + this.g[i5] - this.g[i4];
      this.g[i4] = (paramInt2 + i7);
      i7 = i6;
      i3++;
    } while (i8 == 0);
    if (i3 < i2)
    {
      label193:
      this.f[i4] = (paramInt1++);
      this.g[i4] = (paramInt2 + i7);
      label291:
      do
      {
        do
        {
          if (i3++ >= i2) {
            break label298;
          }
          if (i8 != 0) {
            break label310;
          }
          if (i8 != 0) {
            break label291;
          }
          if (this.f[(i4 = i1 % this.b)] == this.f[(++i1 % this.b)]) {
            break;
          }
          this.f[i4] = (paramInt1++);
        } while (i8 == 0);
        this.f[i4] = paramInt1;
      } while (i8 == 0);
    }
    label298:
    this.i = this.f[i4];
    label310:
    this.h = this.g[i4];
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.yc
 * JD-Core Version:    0.7.0.1
 */