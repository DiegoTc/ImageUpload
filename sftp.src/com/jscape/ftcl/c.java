package com.jscape.ftcl;

import com.jscape.util.ExceptionWrapper;

public class c
  extends Exception
  implements ExceptionWrapper
{
  private Exception a;
  public static boolean b;
  
  public c(String paramString)
  {
    super(paramString);
  }
  
  public c(String paramString, Exception paramException)
  {
    super(paramString);
    this.a = paramException;
  }
  
  public Exception getException()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.c
 * JD-Core Version:    0.7.0.1
 */