package com.jscape.inet.sftp.requests;

public abstract interface RequestFactory
{
  public abstract int getProtocolVersion();
  
  public abstract RealPathRequest getRealPathRequest();
  
  public abstract AttributesRequest getAttributesRequest();
  
  public abstract SetAttributesRequest getSetAttributesRequest();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.RequestFactory
 * JD-Core Version:    0.7.0.1
 */