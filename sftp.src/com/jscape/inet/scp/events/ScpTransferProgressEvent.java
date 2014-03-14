package com.jscape.inet.scp.events;

import com.jscape.inet.scp.Scp;
import com.jscape.util.u;

public final class ScpTransferProgressEvent
  extends ScpEvent
{
  public static final int UPLOAD = 0;
  public static final int DOWNLOAD = 1;
  private final String c;
  private final long d;
  private final long e;
  private final int f;
  private static final String z = -1;
  
  public ScpTransferProgressEvent(Scp paramScp, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramScp);
    u.a(paramString);
    u.a(paramInt, 0L, 1L, z);
    this.c = paramString;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramInt;
    if (bool) {
      u.a = !u.a;
    }
  }
  
  public String getFilename()
  {
    return this.c;
  }
  
  public long getTransferredBytes()
  {
    return this.d;
  }
  
  public long getSize()
  {
    return this.e;
  }
  
  public int getMode()
  {
    return this.f;
  }
  
  public void accept(ScpEventListener paramScpEventListener)
  {
    paramScpEventListener.progress(this);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.events.ScpTransferProgressEvent
 * JD-Core Version:    0.7.0.1
 */