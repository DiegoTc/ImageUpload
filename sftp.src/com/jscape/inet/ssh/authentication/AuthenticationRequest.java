package com.jscape.inet.ssh.authentication;

import com.jscape.inet.ssh.transport.TransportClient;
import com.jscape.inet.ssh.util.User;
import com.jscape.util.m.d;

public abstract interface AuthenticationRequest
  extends d, Cloneable
{
  public abstract User getUser();
  
  public abstract void setUser(User paramUser);
  
  public abstract String getServiceName();
  
  public abstract void setServiceName(String paramString);
  
  public abstract TransportClient getTransportSession();
  
  public abstract void setTransportSession(TransportClient paramTransportClient);
  
  public abstract boolean isSuccessful();
  
  public abstract boolean isValid();
  
  public abstract String getBanner();
  
  public abstract Throwable getError();
  
  public abstract Object clone();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.AuthenticationRequest
 * JD-Core Version:    0.7.0.1
 */