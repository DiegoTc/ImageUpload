package com.jscape.util.g;

import com.jscape.util.c.c;
import com.jscape.util.f.ob;
import java.util.Properties;

public class v
  extends ob<Object>
{
  private final c a;
  private final Properties b;
  
  public v(c paramc, Properties paramProperties)
  {
    this.a = paramc;
    this.b = paramProperties;
  }
  
  public void a(Object paramObject)
  {
    String str = paramObject.toString();
    this.b.setProperty(str, this.a.d(this.b.getProperty(str)));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.v
 * JD-Core Version:    0.7.0.1
 */