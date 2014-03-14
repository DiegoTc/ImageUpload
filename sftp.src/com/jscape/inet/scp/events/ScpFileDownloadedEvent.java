package com.jscape.inet.scp.events;

import com.jscape.inet.scp.Scp;

public final class ScpFileDownloadedEvent
  extends ScpTransferCompletedEvent
{
  public ScpFileDownloadedEvent(Scp paramScp, String paramString, long paramLong1, long paramLong2)
  {
    super(paramScp, paramString, paramLong1, paramLong2);
  }
  
  public void accept(ScpEventListener paramScpEventListener)
  {
    paramScpEventListener.download(this);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.events.ScpFileDownloadedEvent
 * JD-Core Version:    0.7.0.1
 */