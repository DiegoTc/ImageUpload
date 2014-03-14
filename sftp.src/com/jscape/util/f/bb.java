package com.jscape.util.f;

import com.jscape.util.u;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class bb
  extends z<String, String>
{
  private final String a;
  private final String b;
  
  public static z<String, String> a(Map<String, String> paramMap)
  {
    int i = hb.a;
    z localz = ab.b();
    Iterator localIterator = paramMap.entrySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (i != 0) {
        break label81;
      }
      localz = localz.a(new bb((String)localEntry.getKey(), (String)localEntry.getValue()));
    } while (i == 0);
    label81:
    return localz;
  }
  
  public bb(String paramString1, String paramString2)
  {
    u.a(paramString1);
    b(paramString1);
    this.a = paramString1;
    u.a(paramString2);
    this.b = paramString2;
  }
  
  public String a(String paramString)
  {
    return paramString.replaceAll(this.a, this.b);
  }
  
  private void b(String paramString)
  {
    Pattern.compile(paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.bb
 * JD-Core Version:    0.7.0.1
 */