package com.jscape.util.j.c;

import com.jscape.util.t;
import javax.net.ssl.SSLEngine;

public class j
{
  public final String[] a;
  private static final String z = -1;
  
  public j(String... paramVarArgs)
  {
    this.a = paramVarArgs;
  }
  
  public void a(SSLEngine paramSSLEngine)
  {
    paramSSLEngine.setUseClientMode(true);
    if (((l.g) || (this.a != null)) && (this.a.length > 0)) {
      paramSSLEngine.setEnabledCipherSuites(this.a);
    }
  }
  
  public String toString()
  {
    return z + t.a(this.a) + '}';
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.j
 * JD-Core Version:    0.7.0.1
 */