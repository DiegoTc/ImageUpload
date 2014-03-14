package com.jscape.util.g;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class bc
  implements hb<Properties>
{
  public Properties a(InputStream paramInputStream)
    throws IOException
  {
    Properties localProperties = new Properties();
    localProperties.load(paramInputStream);
    return localProperties;
  }
  
  public void a(Properties paramProperties, OutputStream paramOutputStream)
    throws IOException
  {
    paramProperties.store(paramOutputStream, "");
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.bc
 * JD-Core Version:    0.7.0.1
 */