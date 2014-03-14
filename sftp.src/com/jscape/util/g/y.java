package com.jscape.util.g;

import com.jscape.util.c.c;
import com.jscape.util.f.ob;
import java.util.Properties;

class y
  extends ob<Object>
{
  private final Properties a;
  final dc b;
  
  private y(dc paramdc, Properties paramProperties)
  {
    this.a = paramProperties;
  }
  
  public void a(Object paramObject)
  {
    String str = paramObject.toString();
    this.a.setProperty(str, this.b.c.c(this.a.getProperty(str)));
  }
  
  y(dc paramdc, Properties paramProperties, ec paramec)
  {
    this(paramdc, paramProperties);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.y
 * JD-Core Version:    0.7.0.1
 */