package com.jscape.util.h;

import com.jscape.util.b.h;
import com.jscape.util.ec;
import com.jscape.util.qb;
import com.jscape.util.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchProviderException;
import java.security.cert.Certificate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class b
{
  public static boolean a;
  private static final String z = -1;
  
  public static KeyStore a(String paramString1, String paramString2)
    throws KeyStoreException, NoSuchProviderException
  {
    if (!a) {}
    return ec.a(paramString2) ? KeyStore.getInstance(paramString1, paramString2) : KeyStore.getInstance(paramString1);
  }
  
  public static KeyStore a(String paramString1, String paramString2, String paramString3)
    throws a
  {
    try
    {
      KeyStore localKeyStore = a(paramString1, paramString3);
      localKeyStore.load(null, paramString2.toCharArray());
      return localKeyStore;
    }
    catch (Exception localException)
    {
      throw new a(localException);
    }
  }
  
  public static KeyStore a(InputStream paramInputStream, String paramString1, String paramString2, String paramString3)
    throws a
  {
    try
    {
      KeyStore localKeyStore = a(paramString2, paramString3);
      localKeyStore.load(paramInputStream, paramString1.toCharArray());
      return localKeyStore;
    }
    catch (Exception localException)
    {
      throw new a(localException);
    }
  }
  
  public static KeyStore a(File paramFile, String paramString1, String paramString2, String paramString3)
    throws a
  {
    FileInputStream localFileInputStream = null;
    try
    {
      localFileInputStream = new FileInputStream(paramFile);
      KeyStore localKeyStore = a(localFileInputStream, paramString1, paramString2, paramString3);
      return localKeyStore;
    }
    catch (IOException localIOException)
    {
      throw new a(localIOException);
    }
    finally
    {
      qb.a(localFileInputStream);
    }
  }
  
  public static KeyStore a(File paramFile, String paramString)
    throws a
  {
    return a(paramFile, paramString, z, null);
  }
  
  public static String[] a(KeyStore paramKeyStore)
    throws a
  {
    try
    {
      return (String[])com.jscape.util.b.a.a(h.a(paramKeyStore.aliases()), String.class);
    }
    catch (Exception localException)
    {
      throw new a(localException);
    }
  }
  
  public static String[] b(KeyStore paramKeyStore)
    throws a
  {
    boolean bool = a;
    try
    {
      LinkedList localLinkedList = new LinkedList();
      String[] arrayOfString = a(paramKeyStore);
      int i = arrayOfString.length;
      int j = 0;
      do
      {
        if (j >= i) {
          break;
        }
        if (bool) {
          break label90;
        }
        String str = arrayOfString[j];
        if (!bool)
        {
          if (paramKeyStore.isKeyEntry(str)) {
            localLinkedList.add(str);
          }
          j++;
        }
      } while (!bool);
      label90:
      if (u.a) {
        a = !bool;
      }
      return (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
    }
    catch (Exception localException)
    {
      throw new a(localException);
    }
  }
  
  public static String[] c(KeyStore paramKeyStore)
    throws a
  {
    boolean bool = a;
    try
    {
      LinkedList localLinkedList = new LinkedList();
      String[] arrayOfString = a(paramKeyStore);
      int i = arrayOfString.length;
      int j = 0;
      while (j < i)
      {
        if (bool) {
          break label104;
        }
        String str = arrayOfString[j];
        if (!bool)
        {
          if (paramKeyStore.isCertificateEntry(str)) {
            localLinkedList.add(str);
          }
          j++;
        }
        if (bool) {
          u.a = !u.a;
        }
      }
      label104:
      return (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
    }
    catch (Exception localException)
    {
      throw new a(localException);
    }
  }
  
  public static boolean d(KeyStore paramKeyStore)
    throws a
  {
    if (!a) {}
    return b(paramKeyStore).length > 0;
  }
  
  public static boolean e(KeyStore paramKeyStore)
    throws a
  {
    if (!a) {}
    return c(paramKeyStore).length > 0;
  }
  
  public static KeyStore a(KeyStore paramKeyStore, Certificate... paramVarArgs)
    throws a
  {
    boolean bool = a;
    if (!bool) {
      if (paramVarArgs == null) {
        return paramKeyStore;
      }
    }
    try
    {
      Certificate[] arrayOfCertificate = paramVarArgs;
      int i = arrayOfCertificate.length;
      int j = 0;
      do
      {
        if (j >= i) {
          break;
        }
        Certificate localCertificate = arrayOfCertificate[j];
        String str = UUID.randomUUID().toString();
        if (bool) {
          break label66;
        }
        paramKeyStore.setCertificateEntry(str, localCertificate);
        j++;
      } while (!bool);
      label66:
      return paramKeyStore;
    }
    catch (KeyStoreException localKeyStoreException)
    {
      throw new a(localKeyStoreException);
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.h.b
 * JD-Core Version:    0.7.0.1
 */