package com.jscape.util.k;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
  implements g
{
  private final Pattern a;
  private static final String z = -1;
  
  public f(Pattern paramPattern)
  {
    this.a = paramPattern;
  }
  
  public boolean a(String paramString)
  {
    return this.a.matcher(paramString).matches();
  }
  
  public String toString()
  {
    return z + this.a + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.k.f
 * JD-Core Version:    0.7.0.1
 */