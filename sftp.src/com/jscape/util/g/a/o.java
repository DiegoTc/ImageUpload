package com.jscape.util.g.a;

import com.jscape.util.ec;
import com.jscape.util.g.hb;
import com.jscape.util.kb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class o
  implements hb<String>
{
  private final kb a;
  private final String b;
  
  public static void a(String paramString1, kb paramkb, String paramString2, OutputStream paramOutputStream)
    throws IOException
  {
    m.a(ec.b(paramString1, paramString2), paramkb, paramOutputStream);
  }
  
  public static void a(String paramString1, String paramString2, OutputStream paramOutputStream)
    throws IOException
  {
    m.a(ec.b(paramString1, paramString2), paramOutputStream);
  }
  
  public static void b(String paramString1, String paramString2, OutputStream paramOutputStream)
    throws IOException
  {
    m.b(ec.b(paramString1, paramString2), paramOutputStream);
  }
  
  public static String a(kb paramkb, String paramString, InputStream paramInputStream)
    throws IOException
  {
    return ec.a(m.a(paramkb, paramInputStream), paramString);
  }
  
  public static String a(String paramString, InputStream paramInputStream)
    throws IOException
  {
    return ec.a(m.a(paramInputStream), paramString);
  }
  
  public static String b(String paramString, InputStream paramInputStream)
    throws IOException
  {
    return ec.a(m.b(paramInputStream), paramString);
  }
  
  public o(kb paramkb, String paramString)
  {
    this.a = paramkb;
    this.b = paramString;
  }
  
  public void a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramString, this.a, this.b, paramOutputStream);
  }
  
  public String a(InputStream paramInputStream)
    throws IOException
  {
    return a(this.a, this.b, paramInputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.o
 * JD-Core Version:    0.7.0.1
 */