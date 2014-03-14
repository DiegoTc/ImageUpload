package com.jscape.util.g;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class ib
{
  public static <T> T a(lb<T> paramlb, InputStream paramInputStream)
    throws IOException
  {
    try
    {
      return paramlb.read(paramInputStream);
    }
    catch (EOFException localEOFException) {}
    return null;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.ib
 * JD-Core Version:    0.7.0.1
 */