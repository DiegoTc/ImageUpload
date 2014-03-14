package com.jscape.inet.sftp.v2;

import com.jscape.inet.file.JFile;
import com.jscape.inet.sftp.SftpClient;
import com.jscape.inet.sftp.SftpConfiguration;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.packets.SftpFileAttributes;
import com.jscape.inet.sftp.v2.packets.SshFxpRename;
import com.jscape.inet.util.a.a;
import com.jscape.util.u;
import java.io.IOException;

public class SftpClient2
  extends SftpClient
{
  public static final int VERSION = 2;
  public static boolean c;
  private static final String z = -1;
  
  public SftpClient2(a parama, SftpConfiguration paramSftpConfiguration)
    throws IOException
  {
    super(2, parama, paramSftpConfiguration);
    setupReader();
    initProtocol();
  }
  
  protected SftpClient2(int paramInt, a parama, SftpConfiguration paramSftpConfiguration)
    throws IOException
  {
    super(paramInt, parama, paramSftpConfiguration);
  }
  
  public JFile getFile(String paramString)
  {
    u.a(paramString);
    return new SftpFile2(paramString, this);
  }
  
  public JFile getFile(JFile paramJFile, String paramString)
  {
    u.a(paramJFile);
    u.a(paramString);
    u.a(paramJFile instanceof SftpFile2, z);
    return new SftpFile2((SftpFile2)paramJFile, paramString, this);
  }
  
  public JFile getFile(JFile paramJFile, String paramString, SftpFileAttributes paramSftpFileAttributes)
  {
    boolean bool = c;
    u.a(paramJFile);
    u.a(paramString);
    u.a(paramJFile instanceof SftpFile2, z);
    if (u.a) {
      c = !bool;
    }
    return new SftpFile2((SftpFile2)paramJFile, paramString, paramSftpFileAttributes, this);
  }
  
  public void rename(String paramString1, String paramString2)
    throws SftpException
  {
    sendStatusRequest(new SshFxpRename(paramString1, paramString2));
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v2.SftpClient2
 * JD-Core Version:    0.7.0.1
 */