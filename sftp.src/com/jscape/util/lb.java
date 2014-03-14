package com.jscape.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class lb
{
  public static String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static IOException b(Throwable paramThrowable)
  {
    return (bc.a) || ((paramThrowable instanceof IOException)) ? (IOException)paramThrowable : new IOException(paramThrowable);
  }
  
  public static String c(Throwable paramThrowable)
  {
    if (!bc.a) {}
    return paramThrowable.getMessage() != null ? paramThrowable.getMessage() : paramThrowable.toString();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.lb
 * JD-Core Version:    0.7.0.1
 */