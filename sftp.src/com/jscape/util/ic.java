package com.jscape.util;

import java.io.Serializable;

public class ic
  implements Serializable
{
  public static final char a = '*';
  public static final String b = "*";
  public static final char c = '?';
  public static final String d = "?";
  private String e;
  private static final String z = -1;
  
  public static boolean a(String paramString)
  {
    boolean bool = bc.a;
    if (!bool) {
      if (paramString.indexOf("*") <= -1) {
        if (bool) {
          break label33;
        }
      }
    }
    label33:
    return paramString.indexOf("?") > -1;
  }
  
  public static String b(String paramString)
  {
    boolean bool = bc.a;
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    localStringBuffer.append('^');
    int i = 0;
    int j = paramString.length();
    do
    {
      if (i >= j) {
        break;
      }
      char c1 = paramString.charAt(i);
      if (bool) {
        break label234;
      }
      if (!bool) {}
      switch (c1)
      {
      case '*': 
        localStringBuffer.append(z);
        if (!bool) {
          break;
        }
      case '?': 
        localStringBuffer.append(".");
        if (!bool) {
          break;
        }
      case '$': 
      case '(': 
      case ')': 
      case '.': 
      case '[': 
      case '\\': 
      case ']': 
      case '^': 
      case '{': 
      case '|': 
      case '}': 
        localStringBuffer.append("\\");
        localStringBuffer.append(c1);
        if (!bool) {
          break;
        }
      default: 
        localStringBuffer.append(c1);
      }
      i++;
    } while (!bool);
    localStringBuffer.append('$');
    label234:
    return localStringBuffer.toString();
  }
  
  public ic(String paramString)
  {
    u.a(paramString);
    this.e = paramString;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public boolean c(String paramString)
  {
    u.a(paramString);
    return a(paramString, 0, this.e, 0);
  }
  
  private boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    boolean bool = bc.a;
    if (!bool)
    {
      if (paramInt2 >= paramString2.length())
      {
        if (!bool) {}
        return paramInt1 >= paramString1.length();
      }
      if (bool) {}
    }
    else if (paramInt1 >= paramString1.length())
    {
      if (!bool) {}
      return paramString2.charAt(paramInt2) == '*';
    }
    int i = paramString2.charAt(paramInt2);
    if (!bool) {
      switch (i)
      {
      case 42: 
        paramInt2++;
        if (!bool) {
          if (paramInt2 >= paramString2.length()) {
            return true;
          }
        }
        int j = paramString2.charAt(paramInt2);
        int k = paramString1.indexOf(j, paramInt1);
        do
        {
          if (k == -1) {
            break;
          }
          if (bool) {
            break label201;
          }
          if (!bool) {
            if (a(paramString1, k, paramString2, paramInt2)) {
              return true;
            }
          }
          k = paramString1.indexOf(j, k + 1);
        } while (!bool);
        return false;
      case 63: 
        label201:
        return a(paramString1, ++paramInt1, paramString2, ++paramInt2);
      }
    }
    if ((bool) || (i == paramString1.charAt(paramInt1))) {
      if (bool) {}
    }
    return a(paramString1, ++paramInt1, paramString2, ++paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = bc.a;
    if (!bool) {
      if (this == paramObject) {
        return true;
      }
    }
    if (paramObject != null)
    {
      if (bool) {
        break label37;
      }
      if (getClass() == paramObject.getClass()) {}
    }
    else
    {
      return false;
    }
    label37:
    ic localic = (ic)paramObject;
    return this.e.equals(localic.e);
  }
  
  public int hashCode()
  {
    return this.e.hashCode();
  }
  
  public String toString()
  {
    return this.e;
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.ic
 * JD-Core Version:    0.7.0.1
 */