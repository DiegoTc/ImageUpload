package com.jscape.inet.ssh.authentication.requests;

import com.jscape.util.k.e;
import com.jscape.util.k.g;
import com.jscape.util.u;

final class RegexKBIRequest$RegexResponse
{
  private final String a;
  private final g b;
  private final String c;
  
  public RegexKBIRequest$RegexResponse(String paramString1, String paramString2)
  {
    try
    {
      this.a = paramString1;
      this.b = new e().a(this.a);
      u.a(paramString2);
      this.c = paramString2;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(localException.getMessage());
    }
  }
  
  public String getPattern()
  {
    return this.a;
  }
  
  public String getResponse()
  {
    return this.c;
  }
  
  public boolean matches(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = AbstractAuthenticationRequest.g;
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
    RegexResponse localRegexResponse = (RegexResponse)paramObject;
    return this.a.equals(localRegexResponse.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.RegexKBIRequest.RegexResponse
 * JD-Core Version:    0.7.0.1
 */