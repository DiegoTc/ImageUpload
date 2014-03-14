package com.jscape.inet.sftp.requests;

public final class RequestFactory3
  implements RequestFactory
{
  private static final int a = 3;
  
  public int getProtocolVersion()
  {
    return 3;
  }
  
  public RealPathRequest getRealPathRequest()
  {
    return new RealPathRequest3();
  }
  
  public AttributesRequest getAttributesRequest()
  {
    return new AttributesRequest3();
  }
  
  public SetAttributesRequest getSetAttributesRequest()
  {
    return new SetAttributesRequest3();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.RequestFactory3
 * JD-Core Version:    0.7.0.1
 */