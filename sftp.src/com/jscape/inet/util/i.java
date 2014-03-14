package com.jscape.inet.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public abstract interface i
{
  public abstract void a(m paramm, String paramString, int paramInt, long paramLong)
    throws Exception;
  
  public abstract InputStream b();
  
  public abstract OutputStream c();
  
  public abstract Socket d();
  
  public abstract void e();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.i
 * JD-Core Version:    0.7.0.1
 */