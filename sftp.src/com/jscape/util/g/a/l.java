package com.jscape.util.g.a;

public class l
  implements k
{
  final h a;
  
  public l(h paramh) {}
  
  public k a(char paramChar, StringBuffer paramStringBuffer)
  {
    switch (paramChar)
    {
    case '\r': 
      return this;
    case '\\': 
      return h.a(this.a);
    case '\n': 
      return h.b(this.a);
    }
    paramStringBuffer.append(paramChar);
    return this;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.l
 * JD-Core Version:    0.7.0.1
 */