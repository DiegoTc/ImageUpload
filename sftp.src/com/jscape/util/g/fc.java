package com.jscape.util.g;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface fc
{
  public abstract InputStream a(InputStream paramInputStream)
    throws IOException;
  
  public abstract InputStream b(InputStream paramInputStream)
    throws IOException;
  
  public abstract OutputStream a(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract OutputStream b(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.fc
 * JD-Core Version:    0.7.0.1
 */