package com.jscape.util.k;

import java.util.regex.Pattern;

public class e
  implements h
{
  private int a;
  public static int b;
  
  public e(int paramInt)
  {
    this.a = paramInt;
  }
  
  public e()
  {
    this(0);
  }
  
  public g a(String paramString)
    throws b
  {
    try
    {
      return new f(Pattern.compile(paramString, this.a));
    }
    catch (Exception localException)
    {
      throw new b(localException);
    }
  }
  
  public e b()
  {
    this.a = 2;
    return this;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.k.e
 * JD-Core Version:    0.7.0.1
 */