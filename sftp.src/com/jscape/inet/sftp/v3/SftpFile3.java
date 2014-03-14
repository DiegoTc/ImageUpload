package com.jscape.inet.sftp.v3;

import com.jscape.inet.file.JFile;
import com.jscape.inet.sftp.SftpClient;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.packets.SftpFileAttributes;
import com.jscape.inet.sftp.v2.SftpFile2;
import com.jscape.util.u;

public class SftpFile3
  extends SftpFile2
{
  public SftpFile3(String paramString, SftpClient3 paramSftpClient3)
  {
    super(paramString, paramSftpClient3);
  }
  
  public SftpFile3(SftpFile3 paramSftpFile3, String paramString, SftpClient3 paramSftpClient3)
  {
    super(paramSftpFile3, paramString, paramSftpClient3);
  }
  
  protected SftpFile3(SftpFile3 paramSftpFile3, String paramString, SftpFileAttributes paramSftpFileAttributes, SftpClient3 paramSftpClient3)
  {
    super(paramSftpFile3, paramString, paramSftpFileAttributes, paramSftpClient3);
  }
  
  public JFile getLinkTarget()
    throws SftpException
  {
    String str = ((SftpClient3)this.client).readLink(this.path);
    return this.client.getFile(str);
  }
  
  public void createNewLink(String paramString)
    throws SftpException
  {
    u.a(paramString);
    if (!SftpClient3.d)
    {
      if (exists()) {
        return;
      }
      ((SftpClient3)this.client).symlink(this.path, paramString);
    }
    initAbsolutePath();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v3.SftpFile3
 * JD-Core Version:    0.7.0.1
 */