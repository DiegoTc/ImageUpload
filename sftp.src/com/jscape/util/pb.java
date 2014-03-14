package com.jscape.util;

public final class pb
  implements w
{
  public static final String a = ":";
  private final String b;
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, ":");
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramString);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    return new pb(paramString).b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static byte[] a(String paramString)
  {
    return a(paramString, ":");
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    return new pb(paramString2).parse(paramString1);
  }
  
  public pb(String paramString)
  {
    u.a(paramString);
    this.b = paramString;
  }
  
  public pb()
  {
    this(":");
  }
  
  public String format(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = bc.a;
    u.a(paramArrayOfByte, paramInt1, paramInt2);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    do
    {
      if (i >= paramInt2) {
        break;
      }
      if (!bool) {
        if (i > 0) {
          localStringBuffer.append(this.b);
        }
      }
      if ((paramArrayOfByte[(paramInt1 + i)] & 0xFF) <= 15) {
        localStringBuffer.append('0');
      }
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[(paramInt1 + i)] & 0xFF));
      i++;
    } while (!bool);
    return localStringBuffer.toString();
  }
  
  public byte[] parse(String paramString)
  {
    boolean bool = bc.a;
    u.a(paramString);
    if (!bool) {
      if (this.b.length() == 0) {
        return b(paramString);
      }
    }
    String[] arrayOfString = ec.a(paramString, this.b, false);
    byte[] arrayOfByte = new byte[arrayOfString.length];
    int i = 0;
    do
    {
      if (i >= arrayOfString.length) {
        break;
      }
      if (bool) {
        break label83;
      }
      arrayOfByte[i] = ((byte)Integer.parseInt(arrayOfString[i], 16));
      i++;
    } while (!bool);
    label83:
    return arrayOfByte;
  }
  
  private byte[] b(String paramString)
  {
    boolean bool = bc.a;
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    int j = 0;
    do
    {
      if (i >= paramString.length()) {
        break;
      }
      String str = paramString.substring(i, (bool) || (i + 2 <= paramString.length()) ? i + 2 : paramString.length());
      arrayOfByte[j] = ((byte)Integer.parseInt(str, 16));
      i += 2;
      j++;
    } while (!bool);
    return arrayOfByte;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.pb
 * JD-Core Version:    0.7.0.1
 */