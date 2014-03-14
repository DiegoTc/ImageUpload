package com.jscape.util.a;

import java.util.Arrays;
import java.util.List;

public class c
  extends b
{
  protected static final String j = "|";
  private List k;
  
  public c(String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    super(paramArrayOfString[0], paramBoolean, paramInt);
    this.k = Arrays.asList(paramArrayOfString);
  }
  
  public String[] g()
  {
    return (String[])this.k.toArray(new String[this.k.size()]);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = b.i;
    if (!bool) {
      if (this == paramObject) {
        return true;
      }
    }
    if (paramObject != null)
    {
      if (bool) {
        break label37;
      }
      if (getClass() == paramObject.getClass()) {}
    }
    else
    {
      return false;
    }
    label37:
    if (!bool) {
      if (!super.equals(paramObject)) {
        return false;
      }
    }
    c localc = (c)paramObject;
    return this.k.equals(localc.k);
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    i = 31 * i + this.k.hashCode();
    return i;
  }
  
  protected boolean a(String paramString)
  {
    return this.k.contains(paramString);
  }
  
  protected String f()
  {
    boolean bool = b.i;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int m = this.k.size();
    do
    {
      if (i >= m) {
        break;
      }
      if (i > 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(this.k.get(i));
      i++;
    } while (!bool);
    return localStringBuffer.toString();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.a.c
 * JD-Core Version:    0.7.0.1
 */