package com.jscape.inet.ssh.util;

import com.jscape.util.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class ReadUtil
{
  public static int read(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    int i = paramInputStream.read();
    if (!SshParameters.h) {
      if (i == -1) {
        throw new EOFException();
      }
    }
    return i;
  }
  
  public static void read(byte[] paramArrayOfByte, int paramInt1, int paramInt2, InputStream paramInputStream)
    throws IOException
  {
    boolean bool = SshParameters.h;
    u.a(paramInputStream);
    int i = 0;
    do
    {
      if (i >= paramInt2) {
        break;
      }
      int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (!bool) {
        if (j < 0) {
          throw new EOFException();
        }
      }
      i += j;
    } while (!bool);
  }
  
  public static void read(byte[] paramArrayOfByte, InputStream paramInputStream)
    throws IOException
  {
    read(paramArrayOfByte, 0, paramArrayOfByte.length, paramInputStream);
  }
  
  public static byte[] read(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    byte[] arrayOfByte = new byte[paramInt];
    read(arrayOfByte, paramInputStream);
    return arrayOfByte;
  }
  
  public static String readLine(InputStream paramInputStream, String paramString)
    throws IOException
  {
    boolean bool = SshParameters.h;
    u.a(paramInputStream);
    u.a(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      do
      {
        int i = read(paramInputStream) & 0xFF;
        localStringBuffer.append((char)i);
        int j = localStringBuffer.toString().indexOf(paramString);
        if (j == 0)
        {
          localStringBuffer.delete(j, localStringBuffer.length());
          if ((bool) || (!bool)) {}
        }
        else if (j > 0)
        {
          localStringBuffer.delete(j, localStringBuffer.length());
          if (!bool) {
            break;
          }
        }
      } while (!bool);
    }
    catch (EOFException localEOFException) {}
    return (bool) || (localStringBuffer.length() > 0) ? localStringBuffer.toString() : null;
  }
  
  public static String readLine(InputStream paramInputStream)
    throws IOException
  {
    boolean bool = SshParameters.h;
    u.a(paramInputStream);
    StringBuffer localStringBuffer = new StringBuffer();
    label65:
    try
    {
      do
      {
        char c;
        for (;;)
        {
          c = (char)(read(paramInputStream) & 0xFF);
          if (c != '\r')
          {
            if ((!bool) && (c != '\n')) {
              break;
            }
            if (localStringBuffer.length() != 0) {
              break label65;
            }
          }
        }
        localStringBuffer.append(c);
      } while (!bool);
    }
    catch (EOFException localEOFException) {}
    return (bool) || (localStringBuffer.length() > 0) ? localStringBuffer.toString() : null;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.ReadUtil
 * JD-Core Version:    0.7.0.1
 */