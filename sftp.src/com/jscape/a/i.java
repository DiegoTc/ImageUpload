package com.jscape.a;

import com.jscape.util.qb;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class i
{
  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    boolean bool = f.e;
    try
    {
      paramInputStream = new BufferedInputStream(paramInputStream);
      f localf = f.e();
      byte[] arrayOfByte1 = new byte[64];
      do
      {
        int i;
        if ((i = paramInputStream.read(arrayOfByte1)) == -1) {
          break;
        }
        if (bool) {
          break label53;
        }
        localf.a(arrayOfByte1, 0, i);
      } while (!bool);
      label53:
      byte[] arrayOfByte2 = localf.d();
      return arrayOfByte2;
    }
    finally
    {
      qb.a(paramInputStream);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.a.i
 * JD-Core Version:    0.7.0.1
 */