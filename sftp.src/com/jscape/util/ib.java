package com.jscape.util;

import java.io.File;
import java.io.PrintStream;
import java.util.Enumeration;

public class ib
  implements Enumeration
{
  public static final boolean a = false;
  public static final int b = 100;
  public static final int c = 1000;
  String d = null;
  String e = null;
  int f = 0;
  int[] g = new int[100];
  boolean h;
  boolean i;
  boolean j;
  String k;
  boolean l = false;
  File m = null;
  boolean n = true;
  String[] o = null;
  private static final String z = -1;
  
  public ib(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    File localFile1 = new File(paramString1);
    try
    {
      this.d = localFile1.getCanonicalPath();
    }
    catch (Exception localException)
    {
      System.err.println(z);
      this.d = localFile1.getAbsolutePath();
    }
    this.e = this.d;
    int i1 = 0;
    do
    {
      if (i1 >= 100) {
        break;
      }
      this.g[i1] = 0;
      i1++;
      if (bool) {
        break label155;
      }
    } while (!bool);
    this.k = paramString2;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramBoolean3;
    label155:
    File localFile2 = new File(this.d);
    this.o = localFile2.list();
  }
  
  public Object nextElement()
  {
    if (!bc.a)
    {
      if (this.n) {
        b();
      }
      this.n = true;
    }
    return this.m;
  }
  
  public boolean hasMoreElements()
  {
    if (!bc.a) {
      if (this.n) {
        b();
      }
    }
    return this.l;
  }
  
  private void b()
  {
    boolean bool2 = bc.a;
    label170:
    label474:
    label612:
    do
    {
      do
      {
        File localFile;
        do
        {
          do
          {
            do
            {
              if (this.f == -1) {
                break label682;
              }
              if ((bool2) || (bool2)) {
                break label692;
              }
              if (this.n != true) {
                break label682;
              }
              if (bool2) {
                break label170;
              }
              if (this.g[this.f] != this.o.length) {
                break;
              }
              this.f -= 1;
              if (!bool2)
              {
                if (this.f < 0) {
                  break label682;
                }
                if (bool2) {}
              }
              else if (this.e.endsWith(File.separator))
              {
                this.e = this.e.substring(0, this.e.length() - File.separator.length());
              }
              this.e = this.e.substring(0, this.e.lastIndexOf(File.separator));
              localObject = new File(this.e);
              this.o = ((File)localObject).list();
            } while (!bool2);
            Object localObject = this.o[this.g[this.f]];
            localFile = new File(this.e + File.separator + this.o[this.g[this.f]]);
            if (bool2) {
              break label568;
            }
            if (!localFile.isDirectory()) {
              break label567;
            }
            if (bool2) {
              break label297;
            }
            if (this.h) {
              break;
            }
            if (bool2) {
              break label297;
            }
            if (this.i) {
              break;
            }
            this.g[this.f] += 1;
          } while (!bool2);
          if (bool2) {
            break label418;
          }
          if (!this.h) {
            break;
          }
          if (bool2) {
            break label418;
          }
          if (this.i) {
            break;
          }
          try
          {
            this.e = localFile.getCanonicalPath();
          }
          catch (Exception localException1)
          {
            System.err.println(z);
            this.e = localFile.getAbsolutePath();
          }
          this.g[this.f] += 1;
          this.f += 1;
          this.g[this.f] = 0;
          this.o = new File(this.e).list();
        } while (!bool2);
        if (!bool2) {
          if (!this.h)
          {
            if (bool2) {
              break label474;
            }
            if (this.i)
            {
              this.g[this.f] += 1;
              this.m = localFile;
              this.n = false;
              this.l = true;
              if (!bool2) {
                break;
              }
            }
          }
        }
        try
        {
          this.e = localFile.getCanonicalPath();
        }
        catch (Exception localException2)
        {
          this.e = localFile.getAbsolutePath();
        }
        this.g[this.f] += 1;
        this.m = localFile;
        this.n = false;
        this.l = true;
        this.f += 1;
        this.g[this.f] = 0;
        this.o = new File(this.e).list();
        return;
        boolean bool1 = false;
        if (!bool2) {
          if (this.j)
          {
            bool1 = a(this.k, localFile.getPath());
            if (!bool2) {
              break label612;
            }
          }
        }
        bool1 = a(this.k, localFile.getName());
        if (bool1)
        {
          this.g[this.f] += 1;
          this.m = localFile;
          this.n = false;
          this.l = true;
          return;
        }
        this.g[this.f] += 1;
      } while (!bool2);
    } while (!bool2);
    label297:
    label567:
    label568:
    if (!bool2)
    {
      if (this.f == -1)
      {
        this.m = null;
        this.l = false;
      }
    }
    else {
      this.n = false;
    }
    label418:
    label682:
    label692:
    return;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = bc.a;
    int i1 = 0;
    for (;;)
    {
      int i2 = 0;
      label60:
      label90:
      do
      {
        if (i2 >= paramString2.length()) {}
        int i3 = !bool ? 1 : 0;
        if (!bool) {
          if (i1 < paramString1.length()) {
            if (bool) {
              break label60;
            }
          }
        }
        int i4 = paramString1.charAt(i1) == '|' ? 1 : 0;
        if (!bool) {
          if (i3 != 0)
          {
            if (bool) {
              break label90;
            }
            if (i4 != 0) {
              return true;
            }
          }
        }
        if (bool) {
          break label240;
        }
        if ((i3 != 0) || ((!bool) && (i4 != 0))) {
          break;
        }
        if ((bool) || (paramString1.charAt(i1) != '?'))
        {
          if (!bool) {
            if (paramString1.charAt(i1) == '*')
            {
              i1++;
              int i5 = paramString2.length();
              do
              {
                if (i5 < i2) {
                  break;
                }
                if (bool) {
                  break label240;
                }
                if ((bool) || (a(paramString1.substring(i1), paramString2.substring(i5)))) {
                  return true;
                }
                i5--;
              } while (!bool);
            }
          }
          if (paramString1.charAt(i1) != paramString2.charAt(i2)) {
            break;
          }
        }
        i1++;
        i2++;
      } while (!bool);
      i1 = paramString1.indexOf('|', i1);
      if (!bool)
      {
        label240:
        if (i1 == -1) {
          return false;
        }
        i1++;
      }
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.ib
 * JD-Core Version:    0.7.0.1
 */