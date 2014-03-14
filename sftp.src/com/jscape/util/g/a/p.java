package com.jscape.util.g.a;

import com.jscape.util.g.hb;
import com.jscape.util.qb;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class p
  implements hb<String[]>
{
  public void a(String[] paramArrayOfString, OutputStream paramOutputStream)
    throws IOException
  {
    int k = d.b;
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    localDataOutputStream.writeInt(paramArrayOfString.length);
    String[] arrayOfString = paramArrayOfString;
    int i = arrayOfString.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      String str = arrayOfString[j];
      localDataOutputStream.writeUTF(str);
      j++;
      if (k != 0) {
        return;
      }
    } while (k == 0);
    localDataOutputStream.flush();
  }
  
  public String[] a(InputStream paramInputStream)
    throws IOException
  {
    int k = d.b;
    DataInputStream localDataInputStream = new DataInputStream(paramInputStream);
    try
    {
      int i = localDataInputStream.readInt();
      String[] arrayOfString = new String[i];
      int j = 0;
      do
      {
        if (j >= arrayOfString.length) {
          break;
        }
        if (k != 0) {
          break label60;
        }
        arrayOfString[j] = localDataInputStream.readUTF();
        j++;
      } while (k == 0);
      label60:
      return arrayOfString;
    }
    catch (Throwable localThrowable)
    {
      throw qb.a(localThrowable);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.p
 * JD-Core Version:    0.7.0.1
 */