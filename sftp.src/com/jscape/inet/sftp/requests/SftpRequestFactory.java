package com.jscape.inet.sftp.requests;

import com.jscape.util.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class SftpRequestFactory
{
  private Map a = new HashMap();
  private static final String z = -1;
  
  public SftpRequestFactory(RequestFactory[] paramArrayOfRequestFactory)
  {
    for (int i = 0; i < paramArrayOfRequestFactory.length; i++)
    {
      RequestFactory localRequestFactory = paramArrayOfRequestFactory[i];
      this.a.put(new Integer(localRequestFactory.getProtocolVersion()), localRequestFactory);
    }
  }
  
  public RequestFactory[] getFactories()
  {
    Collection localCollection = this.a.values();
    return (RequestFactory[])localCollection.toArray(new RequestFactory[localCollection.size()]);
  }
  
  public RealPathRequest getRealPathRequest(int paramInt)
  {
    return a(paramInt).getRealPathRequest();
  }
  
  public AttributesRequest getAttributesRequest(int paramInt)
  {
    return a(paramInt).getAttributesRequest();
  }
  
  public SetAttributesRequest getSetAttributesRequest(int paramInt)
  {
    return a(paramInt).getSetAttributesRequest();
  }
  
  private RequestFactory a(int paramInt)
  {
    RequestFactory localRequestFactory = (RequestFactory)this.a.get(new Integer(paramInt));
    u.a(localRequestFactory != null, z);
    return localRequestFactory;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.SftpRequestFactory
 * JD-Core Version:    0.7.0.1
 */