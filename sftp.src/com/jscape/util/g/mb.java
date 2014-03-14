package com.jscape.util.g;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface mb
{
  public abstract boolean writeAllowed();
  
  public abstract boolean readAllowed();
  
  public abstract InputStream getInputStream()
    throws IOException;
  
  public abstract OutputStream getOutputStream()
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.mb
 * JD-Core Version:    0.7.0.1
 */