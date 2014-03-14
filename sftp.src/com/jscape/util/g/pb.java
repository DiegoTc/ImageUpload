package com.jscape.util.g;

import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;

public class pb
{
  private static final String z = -1;
  
  public static <T> T a(mb parammb, lb<T>... paramVarArgs)
    throws IOException
  {
    lb<T>[] arrayOflb = paramVarArgs;
    int i = arrayOflb.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      lb<T> locallb = arrayOflb[j];
      try
      {
        return a(parammb, locallb);
      }
      catch (Exception localException)
      {
        j++;
      }
    } while (m.d == 0);
    throw new IOException(z);
  }
  
  private static <T> T a(mb parammb, lb<T> paramlb)
    throws Exception
  {
    InputStream localInputStream = parammb.getInputStream();
    try
    {
      Object localObject1 = paramlb.read(localInputStream);
      return localObject1;
    }
    finally
    {
      qb.a(localInputStream);
    }
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.pb
 * JD-Core Version:    0.7.0.1
 */