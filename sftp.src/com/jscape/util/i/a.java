package com.jscape.util.i;

import com.jscape.util.g.mb;
import com.jscape.util.qb;
import java.io.InputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class a
{
  private static final String z = -1;
  
  public static void a(mb parammb)
  {
    LogManager localLogManager = LogManager.getLogManager();
    InputStream localInputStream = null;
    try
    {
      localInputStream = parammb.getInputStream();
      localLogManager.readConfiguration(localInputStream);
    }
    catch (Exception localException)
    {
      Logger.getLogger("").log(Level.WARNING, z, localException);
    }
    finally
    {
      qb.a(localInputStream);
    }
  }
  
  public static void a(Logger paramLogger, Level paramLevel)
  {
    int k = SimpleFormatter.a;
    paramLogger.setLevel(paramLevel);
    Handler[] arrayOfHandler = paramLogger.getHandlers();
    int i = arrayOfHandler.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      Handler localHandler = arrayOfHandler[j];
      localHandler.setLevel(paramLevel);
      j++;
    } while (k == 0);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.i.a
 * JD-Core Version:    0.7.0.1
 */