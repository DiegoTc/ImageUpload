package com.jscape.util.a;

import com.jscape.util.bc;
import com.jscape.util.qb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

public class j
{
  private static final String a = "";
  private static volatile j b;
  private final BufferedReader c;
  private final PrintStream d;
  
  public static j b()
  {
    boolean bool = b.i;
    j localj = b;
    if (!bool) {
      if (localj == null) {
        synchronized (j.class)
        {
          localj = b;
          if (!bool) {
            if (localj == null) {
              b = localj = new j(new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset())), System.out);
            }
          }
        }
      }
    }
    return localj;
  }
  
  public j(Reader paramReader, PrintStream paramPrintStream)
  {
    bc.a(paramReader);
    this.c = new BufferedReader(paramReader);
    bc.a(paramPrintStream);
    this.d = paramPrintStream;
  }
  
  public void a(String paramString)
  {
    this.d.print(paramString);
  }
  
  public void b(String paramString)
  {
    this.d.println(paramString);
  }
  
  public void c()
  {
    this.d.println();
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    this.d.printf(paramString, paramVarArgs);
  }
  
  public void a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace(this.d);
  }
  
  public String c(String paramString)
    throws IOException
  {
    return a(paramString, false);
  }
  
  public String a(String paramString, boolean paramBoolean)
    throws IOException
  {
    if (!b.i)
    {
      a(paramString);
      if (paramBoolean) {
        c();
      }
    }
    return d();
  }
  
  public String d(String paramString)
    throws IOException
  {
    return a(paramString, "", false);
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean)
    throws IOException
  {
    k localk = new k(this.d, paramString2);
    try
    {
      localk.b();
      String str = a(paramString1, paramBoolean);
      return str;
    }
    finally
    {
      localk.c();
    }
  }
  
  public String a(String paramString, String... paramVarArgs)
    throws IOException
  {
    boolean bool = b.i;
    String str;
    do
    {
      List localList = a(paramVarArgs);
      do
      {
        str = c(paramString);
      } while (!localList.contains(str.toUpperCase()));
    } while (bool);
    return str;
  }
  
  public String d()
    throws IOException
  {
    return this.c.readLine();
  }
  
  public void e()
  {
    if (!b.i)
    {
      if (this != b) {
        qb.a(this.c);
      }
    }
    else {
      qb.a(this.d);
    }
  }
  
  private List<String> a(String[] paramArrayOfString)
  {
    boolean bool = b.i;
    LinkedList localLinkedList = new LinkedList();
    String[] arrayOfString = paramArrayOfString;
    int i = arrayOfString.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      String str = arrayOfString[j];
      if (bool) {
        break label61;
      }
      localLinkedList.add(str.toUpperCase());
      j++;
    } while (!bool);
    label61:
    return localLinkedList;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.a.j
 * JD-Core Version:    0.7.0.1
 */