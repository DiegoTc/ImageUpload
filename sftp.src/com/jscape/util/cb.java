package com.jscape.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class cb
{
  public static <T> T[] a(T... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  public static <T> List<T> b()
  {
    return new ArrayList();
  }
  
  public static <T> List<T> c()
  {
    return new LinkedList();
  }
  
  public static <T, U extends T> List<T> b(U... paramVarArgs)
  {
    List localList = c();
    for (int i = 0; i < paramVarArgs.length; i++) {
      localList.add(paramVarArgs[i]);
    }
    return localList;
  }
  
  public static <T> Set<T> d()
  {
    return new HashSet();
  }
  
  public static <T> Set<T> e()
  {
    return new LinkedHashSet();
  }
  
  public static <T, U extends T> Set<T> c(U... paramVarArgs)
  {
    boolean bool = bc.a;
    Set localSet = e();
    int i = 0;
    do
    {
      if (i >= paramVarArgs.length) {
        break;
      }
      if (bool) {
        break label38;
      }
      localSet.add(paramVarArgs[i]);
      i++;
    } while (!bool);
    label38:
    return localSet;
  }
  
  public static <T, U extends T> Set<T> d(U... paramVarArgs)
  {
    boolean bool = bc.a;
    TreeSet localTreeSet = new TreeSet();
    int i = 0;
    do
    {
      if (i >= paramVarArgs.length) {
        break;
      }
      if (bool) {
        break label42;
      }
      localTreeSet.add(paramVarArgs[i]);
      i++;
    } while (!bool);
    label42:
    return localTreeSet;
  }
  
  public static <K, V> Map<K, V> f()
  {
    return new HashMap();
  }
  
  public static <K, V> Map<K, V> g()
  {
    return new LinkedHashMap();
  }
  
  public static <T> List<T> a(List<T> paramList)
  {
    return paramList != null ? new ArrayList(paramList) : b();
  }
  
  public static <T, U extends T> List<T> b(List<U> paramList)
  {
    return paramList != null ? new LinkedList(paramList) : c();
  }
  
  public static <T> Set<T> a(Set<T> paramSet)
  {
    return paramSet != null ? new HashSet(paramSet) : d();
  }
  
  public static <T> Set<T> b(Set<T> paramSet)
  {
    return paramSet != null ? new LinkedHashSet(paramSet) : e();
  }
  
  public static <K, V> Map<K, V> a(Map<K, V> paramMap)
  {
    return paramMap != null ? new HashMap(paramMap) : f();
  }
  
  public static <K, V> Map<K, V> b(Map<K, V> paramMap)
  {
    return paramMap != null ? new LinkedHashMap(paramMap) : g();
  }
  
  public static <K, V> Map<K, V> a(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    boolean bool = bc.a;
    Map localMap = g();
    int i = 0;
    do
    {
      if (i >= paramArrayOfK.length) {
        break;
      }
      if (bool) {
        break label44;
      }
      localMap.put(paramArrayOfK[i], paramArrayOfV[i]);
      i++;
    } while (!bool);
    label44:
    return localMap;
  }
  
  public static <K, V> Map<K, V> a(Collection<K> paramCollection, Collection<V> paramCollection1)
  {
    boolean bool = bc.a;
    Map localMap = g();
    Iterator localIterator1 = paramCollection.iterator();
    Iterator localIterator2 = paramCollection1.iterator();
    do
    {
      if ((!localIterator1.hasNext()) || ((!bool) && (!localIterator2.hasNext()))) {
        break;
      }
      localMap.put(localIterator1.next(), localIterator2.next());
    } while (!bool);
    return localMap;
  }
  
  public static <K, V> Map<K, V> a(ac<K, V>... paramVarArgs)
  {
    boolean bool = bc.a;
    Map localMap = g();
    int i = 0;
    do
    {
      if (i >= paramVarArgs.length) {
        break;
      }
      if (bool) {
        break label47;
      }
      localMap.put(paramVarArgs[i].b(), paramVarArgs[i].c());
      i++;
    } while (!bool);
    label47:
    return localMap;
  }
  
  public static <T> Collection<T> a(Collection<? extends T>... paramVarArgs)
  {
    boolean bool = bc.a;
    List localList = c();
    Collection<? extends T>[] arrayOfCollection = paramVarArgs;
    int i = arrayOfCollection.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      Collection<? extends T> localCollection = arrayOfCollection[j];
      if (bool) {
        break label52;
      }
      localList.addAll(localCollection);
      j++;
    } while (!bool);
    label52:
    return localList;
  }
  
  public static <T> Collection<T> a(Collection<T> paramCollection, T... paramVarArgs)
  {
    boolean bool = bc.a;
    int i = 0;
    do
    {
      if (i >= paramVarArgs.length) {
        break;
      }
      if (bool) {
        break label34;
      }
      paramCollection.add(paramVarArgs[i]);
      i++;
    } while (!bool);
    label34:
    return paramCollection;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.cb
 * JD-Core Version:    0.7.0.1
 */