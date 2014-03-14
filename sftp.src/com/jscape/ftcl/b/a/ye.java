package com.jscape.ftcl.b.a;

import java.io.Serializable;

public class ye
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public String f;
  public ye g;
  public ye h;
  
  public Object b()
  {
    return null;
  }
  
  public ye() {}
  
  public ye(int paramInt)
  {
    this(paramInt, null);
  }
  
  public ye(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.f = paramString;
  }
  
  public String toString()
  {
    return this.f;
  }
  
  public static ye a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    return new ye(paramInt, paramString);
  }
  
  public static ye a(int paramInt)
  {
    return a(paramInt, null);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.b.a.ye
 * JD-Core Version:    0.7.0.1
 */