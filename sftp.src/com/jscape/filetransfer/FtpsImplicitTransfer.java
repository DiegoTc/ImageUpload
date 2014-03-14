package com.jscape.filetransfer;

import com.jscape.inet.ftps.Ftps;
import java.io.File;
import java.util.Collections;
import java.util.Set;

public class FtpsImplicitTransfer
  extends FtpsTransfer
{
  public FtpsImplicitTransfer(String paramString1, int paramInt, String paramString2, String paramString3, File paramFile, Set<FileTransferListener> paramSet)
  {
    super(paramString1, paramInt, paramString2, paramString3, paramFile, paramSet);
    this.ftps.setConnectionType(Ftps.IMPLICIT_SSL);
  }
  
  public FtpsImplicitTransfer(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    this(paramString1, 990, paramString2, paramString3, paramFile, Collections.emptySet());
  }
  
  public FtpsImplicitTransfer(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramInt, paramString2, paramString3, new File("."), Collections.emptySet());
  }
  
  public FtpsImplicitTransfer(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 990);
  }
  
  public FtpsImplicitTransfer(String paramString1, String paramString2, String paramString3, Integer paramInteger)
  {
    this(paramString1, paramString2, paramString3, paramInteger.intValue());
  }
  
  public FtpsImplicitTransfer()
  {
    this("", "", "");
  }
  
  public FileTransfer copy()
  {
    FtpsImplicitTransfer localFtpsImplicitTransfer = new FtpsImplicitTransfer(this.ftps.getHostname(), this.ftps.getPort(), this.ftps.getUsername(), this.ftps.getPassword(), this.ftps.getLocalDir(), this.listeners);
    localFtpsImplicitTransfer.setDebugStream(getDebugStream());
    localFtpsImplicitTransfer.setDebug(getDebug());
    return localFtpsImplicitTransfer;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FtpsImplicitTransfer
 * JD-Core Version:    0.7.0.1
 */