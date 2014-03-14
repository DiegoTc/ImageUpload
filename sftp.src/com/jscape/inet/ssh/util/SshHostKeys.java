package com.jscape.inet.ssh.util;

import com.jscape.util.u;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SshHostKeys
  implements Serializable
{
  private Map<InetAddress, Set<String>> a;
  private static final String z = -1;
  
  public SshHostKeys(Map<InetAddress, Set<String>> paramMap)
  {
    u.a(paramMap);
    this.a = paramMap;
  }
  
  public SshHostKeys()
  {
    this(new HashMap());
  }
  
  public SshHostKeys(SshHostKeys paramSshHostKeys)
  {
    this(new HashMap(paramSshHostKeys.a));
  }
  
  public void addKey(InetAddress paramInetAddress, String paramString)
  {
    Object localObject = (Set)this.a.get(paramInetAddress);
    if (!SshParameters.h) {
      if (localObject == null)
      {
        localObject = new HashSet();
        this.a.put(paramInetAddress, localObject);
      }
    }
    ((Set)localObject).add(paramString);
  }
  
  public void removeKey(InetAddress paramInetAddress, String paramString)
  {
    boolean bool = SshParameters.h;
    Set localSet = (Set)this.a.get(paramInetAddress);
    if (!bool)
    {
      if (localSet != null) {
        localSet.remove(paramString);
      }
    }
    else if ((bool) || (localSet.isEmpty())) {
      this.a.remove(paramInetAddress);
    }
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public Iterator getHosts()
  {
    return this.a.keySet().iterator();
  }
  
  public Iterator<String> getKeys(InetAddress paramInetAddress)
  {
    Set localSet = (Set)this.a.get(paramInetAddress);
    if (!SshParameters.h) {}
    return localSet != null ? localSet.iterator() : Collections.emptySet().iterator();
  }
  
  public boolean isKnownKey(InetAddress paramInetAddress, String paramString)
  {
    boolean bool = SshParameters.h;
    Set localSet = (Set)this.a.get(paramInetAddress);
    if ((bool) || (localSet != null)) {
      if (bool) {}
    }
    return localSet.contains(paramString);
  }
  
  public String toString()
  {
    return z + this.a + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.SshHostKeys
 * JD-Core Version:    0.7.0.1
 */