package com.jscape.inet.sftp.v4;

import com.jscape.inet.file.JAcl;
import com.jscape.inet.file.JAcl.Mask;
import com.jscape.inet.file.JFileOpenFlags;
import com.jscape.inet.file.JFileType;
import com.jscape.inet.file.JRandomAccessFile;
import com.jscape.inet.sftp.SftpClient;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.v3.SftpFile3;
import com.jscape.inet.sftp.v4.packets.SftpFileAttributes2;
import com.jscape.util.u;

public class SftpFile4
  extends SftpFile3
{
  public SftpFile4(String paramString, SftpClient4 paramSftpClient4)
  {
    super(paramString, paramSftpClient4);
  }
  
  public SftpFile4(SftpFile4 paramSftpFile4, String paramString, SftpClient4 paramSftpClient4)
  {
    super(paramSftpFile4, paramString, paramSftpClient4);
  }
  
  protected SftpFile4(SftpFile4 paramSftpFile4, String paramString, SftpFileAttributes2 paramSftpFileAttributes2, SftpClient4 paramSftpClient4)
  {
    super(paramSftpFile4, paramString, paramSftpFileAttributes2, paramSftpClient4);
  }
  
  public JFileType getType()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getType();
  }
  
  public String getOwner()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getOwner();
  }
  
  public void setOwner(String paramString)
    throws SftpException
  {
    u.a(paramString);
    ensureAttributesInit();
    ((SftpFileAttributes2)this.attrs).setOwner(paramString);
    setAttributes();
  }
  
  public String getGroup()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getGroup();
  }
  
  public void setGroup(String paramString)
    throws SftpException
  {
    u.a(paramString);
    ensureAttributesInit();
    ((SftpFileAttributes2)this.attrs).setGroup(paramString);
    setAttributes();
  }
  
  public long getAccessTime()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getAtime64();
  }
  
  public long getAccessTimeNsec()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getAtimeNseconds();
  }
  
  public long getCreationTime()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getCreationTime();
  }
  
  public long getCreationTimeNsec()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getCreationTimeNseconds();
  }
  
  public long getModificationTime()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getMtime64();
  }
  
  public long getModificationTimeNsec()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getMtimeNseconds();
  }
  
  public JAcl[] getAcl()
    throws SftpException
  {
    ensureAttributesInit();
    return ((SftpFileAttributes2)this.attrs).getAcls();
  }
  
  public void setAcl(JAcl[] paramArrayOfJAcl)
    throws SftpException
  {
    u.a(paramArrayOfJAcl);
    ensureAttributesInit();
    ((SftpFileAttributes2)this.attrs).setAcls(paramArrayOfJAcl);
    setAttributes();
  }
  
  public void createNewDirectory()
    throws SftpException
  {
    if (exists()) {
      return;
    }
    SftpFileAttributes2 localSftpFileAttributes2 = new SftpFileAttributes2();
    localSftpFileAttributes2.setType(JFileType.DIRECTORY);
    this.client.mkdir(this.path, localSftpFileAttributes2);
    initAbsolutePath();
  }
  
  public JRandomAccessFile getRandomAccessFile(JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask)
    throws SftpException
  {
    u.a(paramJFileOpenFlags);
    u.a(paramMask);
    return new SftpRandomAccessFile2(this, paramJFileOpenFlags, paramMask);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.SftpFile4
 * JD-Core Version:    0.7.0.1
 */