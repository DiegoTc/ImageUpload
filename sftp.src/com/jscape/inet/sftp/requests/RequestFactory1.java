package com.jscape.inet.sftp.requests;

public class RequestFactory1
  implements RequestFactory
{
  private static final int a = 1;
  
  public int getProtocolVersion()
  {
    return 1;
  }
  
  public RealPathRequest getRealPathRequest()
  {
    return new RealPathRequest();
  }
  
  public AttributesRequest getAttributesRequest()
  {
    return new AttributesRequest();
  }
  
  public SetAttributesRequest getSetAttributesRequest()
  {
    return new SetAttributesRequest();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.RequestFactory1
 * JD-Core Version:    0.7.0.1
 */