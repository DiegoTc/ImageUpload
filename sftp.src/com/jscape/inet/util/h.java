package com.jscape.inet.util;

import com.jscape.util.u;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class h
{
  private final OutputStreamWriter a;
  private final String b;
  private long c = 0L;
  
  public h(OutputStream paramOutputStream, String paramString)
  {
    u.a(paramOutputStream);
    u.a(paramString);
    this.a = new OutputStreamWriter(paramOutputStream);
    this.b = paramString;
  }
  
  public synchronized void a(String paramString)
    throws IOException
  {
    this.a.write(paramString);
    this.a.write(this.b);
    this.c += 1L;
  }
  
  public synchronized void b(String paramString)
    throws IOException
  {
    this.a.write(paramString);
    this.c += 1L;
  }
  
  public synchronized long b()
  {
    return this.c;
  }
  
  public synchronized void c()
    throws IOException
  {
    this.a.close();
  }
  
  public synchronized void d()
  {
    try
    {
      c();
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.h
 * JD-Core Version:    0.7.0.1
 */