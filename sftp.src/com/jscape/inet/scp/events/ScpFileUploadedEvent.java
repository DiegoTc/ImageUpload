package com.jscape.inet.scp.events;

import com.jscape.inet.scp.Scp;

public final class ScpFileUploadedEvent
  extends ScpTransferCompletedEvent
{
  public ScpFileUploadedEvent(Scp paramScp, String paramString, long paramLong1, long paramLong2)
  {
    super(paramScp, paramString, paramLong1, paramLong2);
  }
  
  public void accept(ScpEventListener paramScpEventListener)
  {
    paramScpEventListener.upload(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.events.ScpFileUploadedEvent
 * JD-Core Version:    0.7.0.1
 */