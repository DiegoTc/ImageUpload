package com.jscape.util.g;

import java.io.IOException;

public abstract interface jb<T>
{
  public abstract boolean writeAllowed();
  
  public abstract boolean readAllowed();
  
  public abstract void write(T paramT)
    throws IOException;
  
  public abstract T read()
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.jb
 * JD-Core Version:    0.7.0.1
 */