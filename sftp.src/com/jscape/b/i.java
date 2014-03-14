package com.jscape.b;

import java.io.File;
import java.util.EventObject;

public class i
  extends EventObject
{
  private File a;
  private File b;
  
  public i(Object paramObject, File paramFile1, File paramFile2)
  {
    super(paramObject);
    this.a = paramFile1;
    this.b = paramFile2;
  }
  
  public File b()
  {
    return this.a;
  }
  
  public File c()
  {
    return this.b;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.b.i
 * JD-Core Version:    0.7.0.1
 */