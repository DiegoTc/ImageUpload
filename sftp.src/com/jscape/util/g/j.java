package com.jscape.util.g;

import java.io.IOException;

public class j
  extends IOException
{
  public j() {}
  
  public j(String paramString)
  {
    super(paramString);
  }
  
  public j(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
  
  public j(Throwable paramThrowable)
  {
    initCause(paramThrowable);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.j
 * JD-Core Version:    0.7.0.1
 */