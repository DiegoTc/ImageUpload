package com.jscape.inet.sftp.requests;

public final class RequestFactory4
  implements RequestFactory
{
  private static final int a = 4;
  
  public int getProtocolVersion()
  {
    return 4;
  }
  
  public RealPathRequest getRealPathRequest()
  {
    return new RealPathRequest4();
  }
  
  public AttributesRequest getAttributesRequest()
  {
    return new AttributesRequest4();
  }
  
  public SetAttributesRequest getSetAttributesRequest()
  {
    return new SetAttributesRequest4();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.RequestFactory4
 * JD-Core Version:    0.7.0.1
 */