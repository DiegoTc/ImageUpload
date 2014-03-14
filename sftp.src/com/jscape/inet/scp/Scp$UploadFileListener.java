package com.jscape.inet.scp;

import com.jscape.inet.scp.events.ScpFileDownloadedEvent;
import com.jscape.inet.scp.events.ScpTransferProgressEvent;
import com.jscape.inet.scp.protocol.OperationListener;
import com.jscape.util.hc;
import com.jscape.util.u;
import java.io.File;

class Scp$UploadFileListener
  implements OperationListener
{
  private final String a;
  private hc b;
  final Scp c;
  
  private Scp$UploadFileListener(Scp paramScp, String paramString)
  {
    u.a(paramString);
    this.a = paramString;
  }
  
  public void onTransferStarted(File paramFile)
  {
    this.b = new hc();
  }
  
  public void onTransferProgress(File paramFile, long paramLong1, long paramLong2)
  {
    Scp.a(this.c, new ScpTransferProgressEvent(this.c, this.a, paramLong1, paramLong2, 0));
  }
  
  public void onTransferCompleted(File paramFile, long paramLong)
  {
    Scp.a(this.c, new ScpFileDownloadedEvent(this.c, this.a, paramLong, this.b.b()));
  }
  
  public void onDirectoryCreated(File paramFile) {}
  
  Scp$UploadFileListener(Scp paramScp, String paramString, Scp.1 param1)
  {
    this(paramScp, paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.Scp.UploadFileListener
 * JD-Core Version:    0.7.0.1
 */