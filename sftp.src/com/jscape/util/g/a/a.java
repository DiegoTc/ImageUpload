package com.jscape.util.g.a;

import com.jscape.util.g.hb;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a
  implements hb<Boolean>
{
  public static void a(boolean paramBoolean, OutputStream paramOutputStream)
    throws IOException
  {
    if (d.b == 0) {}
    paramOutputStream.write(paramBoolean ? 1 : 0);
  }
  
  public static boolean a(InputStream paramInputStream)
    throws IOException
  {
    if (d.b == 0) {}
    return qb.b(paramInputStream) != 0;
  }
  
  public void a(Boolean paramBoolean, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramBoolean.booleanValue(), paramOutputStream);
  }
  
  public Boolean b(InputStream paramInputStream)
    throws IOException
  {
    return a(paramInputStream) ? Boolean.TRUE : Boolean.FALSE;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.a
 * JD-Core Version:    0.7.0.1
 */