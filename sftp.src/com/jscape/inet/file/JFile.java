package com.jscape.inet.file;

import java.io.IOException;

public abstract interface JFile
{
  public abstract String getFilename();
  
  public abstract String getPath();
  
  public abstract JFile getParentFile();
  
  public abstract JFileType getType()
    throws IOException;
  
  public abstract boolean isDirectory()
    throws IOException;
  
  public abstract long getFilesize()
    throws IOException;
  
  public abstract String getOwner()
    throws IOException;
  
  public abstract void setOwner(String paramString)
    throws IOException;
  
  public abstract String getGroup()
    throws IOException;
  
  public abstract void setGroup(String paramString)
    throws IOException;
  
  public abstract JFilePermissions getPermissions()
    throws IOException;
  
  public abstract void setPermissions(JFilePermissions paramJFilePermissions)
    throws IOException;
  
  public abstract long getAccessTime()
    throws IOException;
  
  public abstract long getAccessTimeNsec()
    throws IOException;
  
  public abstract long getCreationTime()
    throws IOException;
  
  public abstract long getCreationTimeNsec()
    throws IOException;
  
  public abstract long getModificationTime()
    throws IOException;
  
  public abstract long getModificationTimeNsec()
    throws IOException;
  
  public abstract JAcl[] getAcl()
    throws IOException;
  
  public abstract void setAcl(JAcl[] paramArrayOfJAcl)
    throws IOException;
  
  public abstract boolean isReadOnly()
    throws IOException;
  
  public abstract boolean isSystem()
    throws IOException;
  
  public abstract boolean isHidden()
    throws IOException;
  
  public abstract boolean isCaseInsensitive()
    throws IOException;
  
  public abstract boolean isArchive()
    throws IOException;
  
  public abstract void setArchive(boolean paramBoolean)
    throws IOException;
  
  public abstract boolean isEncrypted()
    throws IOException;
  
  public abstract boolean isCompressed()
    throws IOException;
  
  public abstract boolean isSparse()
    throws IOException;
  
  public abstract boolean isAppendOnly()
    throws IOException;
  
  public abstract boolean isImmutable()
    throws IOException;
  
  public abstract void setImmutable(boolean paramBoolean)
    throws IOException;
  
  public abstract boolean isSync()
    throws IOException;
  
  public abstract void setSync(boolean paramBoolean)
    throws IOException;
  
  public abstract boolean exists()
    throws IOException;
  
  public abstract void createNewFile()
    throws IOException;
  
  public abstract void createNewDirectory()
    throws IOException;
  
  public abstract void createNewLink(JFile paramJFile)
    throws IOException;
  
  public abstract void renameTo(JFile paramJFile)
    throws IOException;
  
  public abstract void delete()
    throws IOException;
  
  public abstract void deleteRecursive()
    throws IOException;
  
  public abstract JFile[] listFiles()
    throws IOException;
  
  public abstract JFile[] listFiles(JFileFilter paramJFileFilter)
    throws IOException;
  
  public abstract JFile getLinkTarget()
    throws IOException;
  
  public abstract JRandomAccessFile getRandomAccessFile(JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask)
    throws IOException;
  
  public abstract JFileSystem getFileSystem();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JFile
 * JD-Core Version:    0.7.0.1
 */