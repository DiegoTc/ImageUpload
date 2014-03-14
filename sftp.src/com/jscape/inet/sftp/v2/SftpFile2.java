package com.jscape.inet.sftp.v2;

import com.jscape.inet.file.JFile;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.SftpFile;
import com.jscape.inet.sftp.packets.SftpFileAttributes;
import com.jscape.util.u;

public class SftpFile2
  extends SftpFile
{
  private static final String z = -1;
  
  public SftpFile2(String paramString, SftpClient2 paramSftpClient2)
  {
    super(paramString, paramSftpClient2);
  }
  
  public SftpFile2(SftpFile2 paramSftpFile2, String paramString, SftpClient2 paramSftpClient2)
  {
    super(paramSftpFile2, paramString, paramSftpClient2);
  }
  
  protected SftpFile2(SftpFile2 paramSftpFile2, String paramString, SftpFileAttributes paramSftpFileAttributes, SftpClient2 paramSftpClient2)
  {
    super(paramSftpFile2, paramString, paramSftpFileAttributes, paramSftpClient2);
  }
  
  public void renameTo(JFile paramJFile)
    throws SftpException
  {
    boolean bool = SftpClient2.c;
    u.a(paramJFile);
    u.a(paramJFile instanceof SftpFile, z);
    String str = paramJFile.getPath();
    ((SftpClient2)this.client).rename(this.path, str);
    this.path = str;
    if (bool) {
      u.a = !u.a;
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v2.SftpFile2
 * JD-Core Version:    0.7.0.1
 */