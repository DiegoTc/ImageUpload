package com.jscape.util.g;

import com.jscape.util.b.a;
import com.jscape.util.b.j;
import com.jscape.util.c.c;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class cc
  extends bc
{
  private final c a;
  private final t b;
  
  public cc(c paramc, List<String> paramList)
  {
    this.a = paramc;
    this.b = new t(paramList);
  }
  
  public cc(c paramc, String... paramVarArgs)
  {
    this(paramc, Arrays.asList(paramVarArgs));
  }
  
  public cc()
  {
    this(null, new String[0]);
  }
  
  public Properties a(InputStream paramInputStream)
    throws IOException
  {
    return b(super.a(paramInputStream));
  }
  
  public void a(Properties paramProperties, OutputStream paramOutputStream)
    throws IOException
  {
    super.a(a(paramProperties), paramOutputStream);
  }
  
  private Properties a(Properties paramProperties)
    throws IOException
  {
    if (m.d == 0) {
      if (this.a == null) {
        return paramProperties;
      }
    }
    try
    {
      Properties localProperties = (Properties)paramProperties.clone();
      a.a(j.a(paramProperties.keySet().iterator(), this.b), new w(this.a, localProperties));
      return localProperties;
    }
    catch (Exception localException)
    {
      throw qb.a(localException);
    }
  }
  
  private Properties b(Properties paramProperties)
    throws IOException
  {
    if (m.d == 0) {
      if (this.a == null) {
        return paramProperties;
      }
    }
    try
    {
      Properties localProperties = (Properties)paramProperties.clone();
      a.a(j.a(paramProperties.keySet().iterator(), this.b), new v(this.a, localProperties));
      return localProperties;
    }
    catch (Exception localException)
    {
      throw qb.a(localException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.cc
 * JD-Core Version:    0.7.0.1
 */