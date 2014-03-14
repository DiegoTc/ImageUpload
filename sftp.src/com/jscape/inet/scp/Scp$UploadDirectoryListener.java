package com.jscape.inet.scp;

import com.jscape.inet.scp.events.ScpFileDownloadedEvent;
import com.jscape.inet.scp.events.ScpTransferProgressEvent;
import com.jscape.inet.scp.protocol.OperationListener;
import com.jscape.util.hc;
import java.io.File;

class Scp$UploadDirectoryListener
  implements OperationListener
{
  private hc a;
  final Scp b;
  
  private Scp$UploadDirectoryListener(Scp paramScp) {}
  
  public void onTransferStarted(File paramFile)
  {
    this.a = new hc();
  }
  
  public void onTransferProgress(File paramFile, long paramLong1, long paramLong2)
  {
    Scp.a(this.b, new ScpTransferProgressEvent(this.b, paramFile.getName(), paramLong1, paramLong2, 0));
  }
  
  public void onTransferCompleted(File paramFile, long paramLong)
  {
    Scp.a(this.b, new ScpFileDownloadedEvent(this.b, paramFile.getName(), paramLong, this.a.b()));
  }
  
  public void onDirectoryCreated(File paramFile) {}
  
  Scp$UploadDirectoryListener(Scp paramScp, Scp.1 param1)
  {
    this(paramScp);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.Scp.UploadDirectoryListener
 * JD-Core Version:    0.7.0.1
 */