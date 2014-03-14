package com.jscape.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ec
{
  private static final String z = -1;
  
  public static String[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = bc.a;
    u.a(paramString1);
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramString1.length();
    label92:
    label97:
    do
    {
      if (i >= j) {
        break;
      }
      do
      {
        if (i >= j) {
          break label92;
        }
        if (bool) {
          break label97;
        }
        if (bool) {
          break;
        }
        if (paramString2.indexOf(paramString1.charAt(i)) >= 0) {
          break label92;
        }
        localStringBuffer.append(paramString1.charAt(i));
        i++;
      } while (!bool);
      String str = localStringBuffer.toString();
      localStringBuffer.setLength(0);
      if ((bool) || ((str.length() > 0) || ((bool) || (paramBoolean)))) {
        localArrayList.add(str);
      }
      i++;
    } while (!bool);
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] a(String paramString1, String paramString2, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    boolean bool = bc.a;
    if ((bool) || (paramString2.indexOf(paramChar1) < 0)) {
      if (bool) {}
    }
    u.a(paramString2.indexOf(paramChar2) < 0, z);
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = 0;
    int k = paramString1.length();
    label165:
    label198:
    label237:
    do
    {
      if (j >= k) {
        break;
      }
      if (bool) {
        break label250;
      }
      if (!bool) {
        if (paramString2.indexOf(paramString1.charAt(j)) >= 0)
        {
          if (bool) {
            break label165;
          }
          if (i == 0)
          {
            if ((bool) || ((localStringBuffer.length() > 0) || ((bool) || (paramBoolean)))) {
              localArrayList.add(localStringBuffer.toString());
            }
            localStringBuffer.setLength(0);
            if (!bool) {
              break label237;
            }
          }
        }
      }
      if (!bool) {
        if (paramString1.charAt(j) == paramChar1)
        {
          if (bool) {
            break label198;
          }
          if (i == 0)
          {
            i = 1;
            if (!bool) {
              break label237;
            }
          }
        }
      }
      if ((bool) || (paramString1.charAt(j) == paramChar2)) {
        if ((bool) || (i != 0))
        {
          i = 0;
          if (!bool) {
            break label237;
          }
        }
      }
      localStringBuffer.append(paramString1.charAt(j));
      j++;
    } while (!bool);
    label250:
    if ((bool) || ((localStringBuffer.length() > 0) || ((bool) || (paramBoolean)))) {
      localArrayList.add(localStringBuffer.toString());
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = bc.a;
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramString1.length();
    label79:
    label253:
    do
    {
      if (i >= j) {
        break;
      }
      do
      {
        if (i >= j) {
          break;
        }
        if ((bool) || (bool)) {
          break label79;
        }
        if (paramString2.indexOf(paramString1.charAt(i)) < 0) {
          break;
        }
        i++;
      } while (!bool);
      if ((!bool) && (i >= j)) {
        break;
      }
      if (!bool) {
        if (paramString3.indexOf(paramString1.charAt(i)) != -1)
        {
          i++;
          do
          {
            if (i >= j) {
              break label253;
            }
            if (bool) {
              break;
            }
            if (!bool)
            {
              if (paramString4.indexOf(paramString1.charAt(i)) != -1) {
                if (bool) {
                  break label265;
                }
              }
            }
            else
            {
              if (i >= j - 1) {
                break label253;
              }
              if (bool) {
                break label265;
              }
              if (paramString4.indexOf(paramString1.charAt(i + 1)) == -1) {
                break label253;
              }
              i++;
            }
            localStringBuffer.append(paramString1.charAt(i));
            i++;
          } while (!bool);
        }
      }
      do
      {
        if (i >= j) {
          break;
        }
        if ((bool) || (bool)) {
          break label265;
        }
        if (paramString2.indexOf(paramString1.charAt(i)) >= 0) {
          break;
        }
        localStringBuffer.append(paramString1.charAt(i));
        i++;
      } while (!bool);
      localArrayList.add(localStringBuffer.toString());
      localStringBuffer.setLength(0);
      i++;
    } while (!bool);
    label265:
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    boolean bool = bc.a;
    if (paramVarArgs == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    do
    {
      if (i >= paramVarArgs.length) {
        break;
      }
      if (i > 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(paramVarArgs[i]);
      i++;
    } while (!bool);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, Collection paramCollection)
  {
    boolean bool = bc.a;
    if (paramCollection == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      if (i > 0) {
        localStringBuffer.append(paramString);
      }
      localStringBuffer.append(localIterator.next());
      i++;
    } while (!bool);
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    boolean bool = bc.a;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    do
    {
      if (i >= paramString1.length()) {
        break;
      }
      if ((bool) || (bool)) {
        break label67;
      }
      if (paramString2.indexOf(paramString1.charAt(i)) >= 0) {
        break;
      }
      localStringBuffer.append(paramString1.charAt(i));
      i++;
    } while (!bool);
    label67:
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, char paramChar)
  {
    int i = paramString.indexOf(paramChar);
    return i >= 0 ? paramString.substring(0, i) : paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = bc.a;
    u.a(paramString1);
    if (!bool)
    {
      if (paramString1.startsWith(paramString2)) {
        paramString1 = paramString1.substring(paramString2.length());
      }
      if (bool) {}
    }
    else if (paramString1.endsWith(paramString3))
    {
      paramString1 = paramString1.substring(0, paramString1.length() - paramString3.length());
    }
    return paramString1;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = bc.a;
    StringBuffer localStringBuffer = new StringBuffer();
    do
    {
      int i;
      if ((i = paramString1.indexOf(paramString2)) < 0) {
        break;
      }
      localStringBuffer.append(paramString1.substring(0, i));
      localStringBuffer.append(paramString3);
      int j = i + paramString2.length();
      if (bool) {
        break label88;
      }
      paramString1 = j < paramString1.length() ? paramString1.substring(j) : "";
    } while (!bool);
    localStringBuffer.append(paramString1);
    label88:
    return localStringBuffer.toString();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = bc.a;
    if ((bool) || (paramString != null)) {
      if (bool) {}
    }
    return paramString.trim().length() != 0;
  }
  
  public static byte[] b(String paramString1, String paramString2)
  {
    try
    {
      return paramString1.getBytes(paramString2);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  public static byte[] a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    boolean bool = bc.a;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    do
    {
      if (i >= paramArrayOfString.length) {
        break;
      }
      if (i > 0) {
        localStringBuffer.append(paramString1);
      }
      localStringBuffer.append(paramArrayOfString[i]);
      i++;
    } while (!bool);
    return b(localStringBuffer.toString(), paramString2);
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      return new String(paramArrayOfByte, paramString);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalArgumentException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      return new String(paramArrayOfByte, paramInt1, paramInt2, paramString);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalArgumentException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = bc.a;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    do
    {
      if (i >= paramString1.length()) {
        break;
      }
      localStringBuffer.append(paramString1.charAt(i));
      if (bool) {
        break label78;
      }
      if (!bool)
      {
        if ((i > 0) && (i % paramInt == 0)) {
          localStringBuffer.append(paramString2);
        }
        i++;
      }
    } while (!bool);
    localStringBuffer.append(paramString2);
    label78:
    return localStringBuffer.toString();
  }
  
  public static Integer a(String paramString, Integer paramInteger)
  {
    try
    {
      return Integer.valueOf(paramString);
    }
    catch (Exception localException) {}
    return paramInteger;
  }
  
  public static Long a(String paramString, Long paramLong)
  {
    try
    {
      return Long.valueOf(paramString);
    }
    catch (Exception localException) {}
    return paramLong;
  }
  
  public static Boolean a(String paramString, Boolean paramBoolean)
  {
    try
    {
      return Boolean.valueOf(paramString);
    }
    catch (Exception localException) {}
    return paramBoolean;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.ec
 * JD-Core Version:    0.7.0.1
 */