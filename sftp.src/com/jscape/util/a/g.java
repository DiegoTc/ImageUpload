package com.jscape.util.a;

import com.jscape.util.u;

public class g
  extends f
{
  private static final String z = -1;
  
  public g(String paramString, int paramInt)
  {
    super(paramString, true, paramInt);
  }
  
  protected boolean a(String paramString)
  {
    boolean bool = b.i;
    int i = 0;
    do
    {
      if (i >= paramString.length()) {
        break;
      }
      if (bool) {
        break label56;
      }
      if (!bool) {}
      u.a(this.f.indexOf(paramString.charAt(i)) >= 0, z);
      i++;
    } while (!bool);
    label56:
    return true;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.a.g
 * JD-Core Version:    0.7.0.1
 */