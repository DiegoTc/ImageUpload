package com.jscape.inet.ftp;

import java.util.EventListener;

public abstract interface FxpListener
  extends EventListener
{
  public abstract void fxpStart(FxpStartEvent paramFxpStartEvent);
  
  public abstract void fxpEnd(FxpEndEvent paramFxpEndEvent);
  
  public abstract void fxpFailed(FxpFailedEvent paramFxpFailedEvent);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FxpListener
 * JD-Core Version:    0.7.0.1
 */