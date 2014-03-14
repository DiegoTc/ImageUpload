package com.jscape.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;

public class cc
{
  public static char[] a(InputStream paramInputStream, String paramString)
    throws IOException
  {
    boolean bool = bc.a;
    jc localjc = new jc(paramString);
    Thread localThread = new Thread(localjc);
    localThread.start();
    Object localObject;
    char[] arrayOfChar1 = localObject = new char[''];
    int i = arrayOfChar1.length;
    int j = 0;
    do
    {
      int k;
      switch (k = paramInputStream.read())
      {
      case -1: 
      case 10: 
        if (!bool) {
          break;
        }
      case 13: 
        int m = paramInputStream.read();
        if (bool) {
          break label229;
        }
        if (m == 10) {
          break;
        }
        if (bool) {
          break label229;
        }
        if (m == -1) {
          break;
        }
        if (!bool) {
          if (!(paramInputStream instanceof PushbackInputStream)) {
            paramInputStream = new PushbackInputStream(paramInputStream);
          }
        }
        ((PushbackInputStream)paramInputStream).unread(m);
      default: 
        i--;
        if (!bool)
        {
          if (i < 0)
          {
            arrayOfChar1 = new char[j + 128];
            i = arrayOfChar1.length - j - 1;
            System.arraycopy(localObject, 0, arrayOfChar1, 0, j);
            Arrays.fill((char[])localObject, ' ');
            localObject = arrayOfChar1;
          }
          arrayOfChar1[(j++)] = ((char)k);
        }
        break;
      }
    } while (!bool);
    localjc.b();
    label229:
    if (!bool) {
      if (j == 0) {
        return null;
      }
    }
    char[] arrayOfChar2 = new char[j];
    System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, j);
    Arrays.fill(arrayOfChar1, ' ');
    return arrayOfChar2;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.cc
 * JD-Core Version:    0.7.0.1
 */