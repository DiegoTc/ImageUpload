package com.jscape.util.i;

import java.io.OutputStream;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class c
  extends StreamHandler
{
  private final OutputStream a;
  
  public c(OutputStream paramOutputStream, Formatter paramFormatter)
  {
    super(paramOutputStream, paramFormatter);
    this.a = paramOutputStream;
  }
  
  public c(OutputStream paramOutputStream)
  {
    this(paramOutputStream, new b());
  }
  
  public void publish(LogRecord paramLogRecord)
  {
    if ((SimpleFormatter.a != 0) || (isLoggable(paramLogRecord)))
    {
      super.publish(paramLogRecord);
      flush();
    }
  }
  
  public OutputStream b()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.i.c
 * JD-Core Version:    0.7.0.1
 */