package com.jscape.inet.util;

import java.io.IOException;
import java.net.ServerSocket;
import javax.net.ServerSocketFactory;

public class l
{
  private static final String z = -1;
  
  public static ServerSocket a(int paramInt1, int paramInt2)
    throws Exception
  {
    boolean bool = ConnectionParameters.t;
    ServerSocket localServerSocket = null;
    int i = paramInt1;
    do
    {
      if ((i > paramInt2) || ((!bool) && (localServerSocket != null))) {
        break;
      }
      try
      {
        localServerSocket = new ServerSocket(i, 0);
        return localServerSocket;
      }
      catch (IOException localIOException)
      {
        i++;
      }
    } while (!bool);
    throw new Exception(z);
  }
  
  public static ServerSocket a(ServerSocketFactory paramServerSocketFactory, int paramInt1, int paramInt2)
    throws Exception
  {
    boolean bool = ConnectionParameters.t;
    ServerSocket localServerSocket = null;
    int i = paramInt1;
    do
    {
      if ((i > paramInt2) || ((!bool) && (localServerSocket != null))) {
        break;
      }
      try
      {
        localServerSocket = paramServerSocketFactory.createServerSocket(i, 0);
        return localServerSocket;
      }
      catch (IOException localIOException)
      {
        i++;
      }
    } while (!bool);
    throw new Exception(z);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.l
 * JD-Core Version:    0.7.0.1
 */