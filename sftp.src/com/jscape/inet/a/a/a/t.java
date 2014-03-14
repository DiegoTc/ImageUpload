package com.jscape.inet.a.a.a;

import com.jscape.inet.a.a.b.o;
import com.jscape.inet.a.a.b.pb;
import com.jscape.inet.a.a.b.yb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class t
  extends a
{
  private final jb c = new jb();
  
  public o a(InputStream paramInputStream)
    throws IOException
  {
    yb localyb = this.c.a(paramInputStream);
    return new pb(localyb);
  }
  
  public void a(o paramo, OutputStream paramOutputStream)
    throws IOException
  {
    pb localpb = (pb)paramo;
    this.c.a(localpb.b, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.a.t
 * JD-Core Version:    0.7.0.1
 */