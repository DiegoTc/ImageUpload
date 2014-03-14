package com.jscape.inet.ssh.util.keyreader;

import java.io.IOException;

public class FormatException
  extends IOException
{
  public static int a;
  
  public FormatException() {}
  
  public FormatException(String paramString)
  {
    super(paramString);
  }
  
  public FormatException(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage());
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.FormatException
 * JD-Core Version:    0.7.0.1
 */