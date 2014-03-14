package com.jscape.util.g.a;

import com.jscape.util.cb;
import com.jscape.util.g.hb;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h
  implements hb<Map<String, String>>
{
  private final String a;
  private final String b;
  private final l c;
  private final i d;
  private final j e;
  
  public h(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = new l(this);
    this.d = new i(this);
    this.e = new j();
  }
  
  public void a(Map<String, String> paramMap, OutputStream paramOutputStream)
    throws IOException
  {
    int i = d.b;
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, this.a);
    Iterator localIterator = paramMap.entrySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localOutputStreamWriter.write((String)localEntry.getKey());
      localOutputStreamWriter.write(this.b);
      if (i != 0) {
        break label126;
      }
      localOutputStreamWriter.write((i != 0) || (localEntry.getValue() != null) ? (String)localEntry.getValue() : "");
      localOutputStreamWriter.write(10);
    } while (i == 0);
    label126:
    localOutputStreamWriter.flush();
  }
  
  public Map<String, String> a(InputStream paramInputStream)
    throws IOException
  {
    int j = d.b;
    InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream, this.a);
    Map localMap = cb.f();
    StringBuffer localStringBuffer = new StringBuffer();
    label117:
    do
    {
      String str;
      do
      {
        if ((str = a(localInputStreamReader, localStringBuffer)) == null) {
          break;
        }
      } while ((j == 0) && (str.length() == 0));
      int i = str.indexOf(this.b);
      if (j == 0)
      {
        if (i != -1)
        {
          if (j != 0) {
            break label117;
          }
          if (i != str.length() - 1) {}
        }
        else
        {
          localMap.put(str, "");
        }
      }
      else {
        if (j == 0) {
          continue;
        }
      }
      if (i == 0)
      {
        localMap.put("", str.trim());
        if (j == 0) {}
      }
      else
      {
        localMap.put(str.substring(0, i), str.substring(i + 1).trim());
      }
    } while (j == 0);
    return localMap;
  }
  
  private String a(Reader paramReader, StringBuffer paramStringBuffer)
    throws IOException
  {
    int j = d.b;
    Object localObject = new l(this);
    int i;
    while ((i = paramReader.read()) != -1)
    {
      localObject = ((k)localObject).a((char)i, paramStringBuffer);
      if (!((k)localObject).b()) {
        break;
      }
    }
    if (j == 0)
    {
      if (i == -1) {
        if (j != 0) {
          break label75;
        }
      }
    }
    else if (paramStringBuffer.length() == 0) {
      return null;
    }
    label75:
    String str = paramStringBuffer.toString();
    paramStringBuffer.setLength(0);
    return str;
  }
  
  static i a(h paramh)
  {
    return paramh.d;
  }
  
  static j b(h paramh)
  {
    return paramh.e;
  }
  
  static l c(h paramh)
  {
    return paramh.c;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.a.h
 * JD-Core Version:    0.7.0.1
 */