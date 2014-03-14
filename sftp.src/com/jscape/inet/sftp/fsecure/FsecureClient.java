package com.jscape.inet.sftp.fsecure;

import com.jscape.inet.sftp.BadVersionException;
import com.jscape.inet.sftp.SftpConfiguration;
import com.jscape.inet.sftp.v2.SftpClient2;
import com.jscape.inet.util.a.a;
import com.jscape.util.u;
import java.io.IOException;

public class FsecureClient
  extends SftpClient2
{
  public static boolean d;
  
  public FsecureClient(a parama, SftpConfiguration paramSftpConfiguration)
    throws IOException
  {
    super(2, parama, paramSftpConfiguration);
    setupReader();
    initProtocol();
    if (bool) {
      u.a = !u.a;
    }
  }
  
  protected void assertCompatibleVersion(int paramInt)
    throws BadVersionException
  {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.fsecure.FsecureClient
 * JD-Core Version:    0.7.0.1
 */