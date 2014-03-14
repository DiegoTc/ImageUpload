package com.jscape.inet.sftp.v4;

import com.jscape.inet.file.JAcl.Mask;
import com.jscape.inet.file.JFileOpenFlags;
import com.jscape.inet.file.JFileType;
import com.jscape.inet.sftp.SftpClient;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.SftpFile;
import com.jscape.inet.sftp.SftpRandomAccessFile;
import com.jscape.inet.sftp.v4.packets.SftpFileAttributes2;
import com.jscape.util.u;

public class SftpRandomAccessFile2
  extends SftpRandomAccessFile
{
  private static byte[] b(SftpFile paramSftpFile, JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask)
    throws SftpException
  {
    u.a(paramSftpFile);
    u.a(paramJFileOpenFlags);
    u.a(paramMask);
    SftpFileAttributes2 localSftpFileAttributes2 = new SftpFileAttributes2();
    localSftpFileAttributes2.setType(JFileType.REGULAR);
    SftpClient4 localSftpClient4 = (SftpClient4)paramSftpFile.getFileSystem();
    return localSftpClient4.open(paramSftpFile.getPath(), paramJFileOpenFlags, paramMask, localSftpFileAttributes2);
  }
  
  public SftpRandomAccessFile2(SftpFile paramSftpFile, JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask)
    throws SftpException
  {
    this(b(paramSftpFile, paramJFileOpenFlags, paramMask), (SftpClient)paramSftpFile.getFileSystem());
    this.file = paramSftpFile;
  }
  
  protected SftpRandomAccessFile2(byte[] paramArrayOfByte, SftpClient paramSftpClient)
  {
    super(paramArrayOfByte, paramSftpClient);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.SftpRandomAccessFile2
 * JD-Core Version:    0.7.0.1
 */