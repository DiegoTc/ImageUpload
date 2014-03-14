package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.file.JAcl;
import com.jscape.inet.file.JFile;
import com.jscape.inet.file.JFilePermissions;
import com.jscape.inet.file.JFileType;
import com.jscape.inet.sftp.packets.SftpFileAttributes;
import com.jscape.inet.sftp.packets.SftpFileAttributes.AttributePresenceFlags;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.inet.ssh.types.SshUint64;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SftpFileAttributes2
  extends SftpFileAttributes
{
  private JFileType b;
  private String c;
  private String d;
  private long e;
  private long f;
  private long g;
  private long h;
  private JAcl[] i;
  public static int j;
  
  public SftpFileAttributes2()
  {
    this.flags = new AttributePresenceFlags2();
  }
  
  public static SftpFileAttributes readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    int n = j;
    SftpFileAttributes2 localSftpFileAttributes2 = new SftpFileAttributes2();
    AttributePresenceFlags2 localAttributePresenceFlags2 = (AttributePresenceFlags2)AttributePresenceFlags2.readFrom(paramInputStream, paramString);
    localSftpFileAttributes2.setType(SftpFileType.readFrom(paramInputStream, paramString));
    if (n == 0) {
      if (localAttributePresenceFlags2.isSizePresent()) {
        localSftpFileAttributes2.setSize(SshUint64.readLongFrom(paramInputStream));
      }
    }
    if (n == 0) {
      if (localAttributePresenceFlags2.isOwnerGroupPresent())
      {
        localSftpFileAttributes2.setOwner(SshString.readValue(paramInputStream, paramString));
        localSftpFileAttributes2.setGroup(SshString.readValue(paramInputStream, paramString));
      }
    }
    if (n == 0) {
      if (localAttributePresenceFlags2.isPermissionsPresent()) {
        localSftpFileAttributes2.setPermissions(new JFilePermissions(SshUint32.readIntFrom(paramInputStream)));
      }
    }
    if (n == 0) {
      if (localAttributePresenceFlags2.isAccessTimePresent())
      {
        localSftpFileAttributes2.setAtime(SshUint64.readLongFrom(paramInputStream));
        if (n != 0) {
          break label152;
        }
        if (localAttributePresenceFlags2.isSubSecondTimesPresent()) {
          localSftpFileAttributes2.setAtimeNseconds(SshUint32.readLongFrom(paramInputStream));
        }
      }
    }
    label152:
    if (n == 0) {
      if (localAttributePresenceFlags2.isCreateTimePresent())
      {
        localSftpFileAttributes2.setCreationTime(SshUint64.readLongFrom(paramInputStream));
        if (n != 0) {
          break label192;
        }
        if (localAttributePresenceFlags2.isSubSecondTimesPresent()) {
          localSftpFileAttributes2.setCreationTimeNseconds(SshUint32.readLongFrom(paramInputStream));
        }
      }
    }
    label192:
    if (n == 0) {
      if (localAttributePresenceFlags2.isModifyTimePresent())
      {
        localSftpFileAttributes2.setMtime(SshUint64.readLongFrom(paramInputStream));
        if (n != 0) {
          break label232;
        }
        if (localAttributePresenceFlags2.isSubSecondTimesPresent()) {
          localSftpFileAttributes2.setMtimeNseconds(SshUint32.readLongFrom(paramInputStream));
        }
      }
    }
    label232:
    if (n == 0) {
      if (localAttributePresenceFlags2.isAclPresent()) {
        localSftpFileAttributes2.setAcls(SftpAcl.readFrom(paramInputStream, paramString));
      }
    }
    if ((n != 0) || (localAttributePresenceFlags2.isExtendedPresent()))
    {
      int k = SshUint32.readIntFrom(paramInputStream);
      int m = 0;
      do
      {
        if (m >= k) {
          break;
        }
        if (n != 0) {
          break label304;
        }
        localSftpFileAttributes2.setExtension(SshString.readValue(paramInputStream, paramString), SshString.readValue(paramInputStream));
        m++;
      } while (n == 0);
    }
    label304:
    return localSftpFileAttributes2;
  }
  
  public static SftpFileAttributes forFile(JFile paramJFile)
  {
    u.a(paramJFile);
    SftpFileAttributes2 localSftpFileAttributes2 = new SftpFileAttributes2();
    try
    {
      localSftpFileAttributes2.setType(paramJFile.getType());
    }
    catch (Exception localException1) {}
    try
    {
      localSftpFileAttributes2.setSize(paramJFile.getFilesize());
    }
    catch (Exception localException2) {}
    try
    {
      localSftpFileAttributes2.setOwner(paramJFile.getOwner());
      localSftpFileAttributes2.setGroup(paramJFile.getGroup());
    }
    catch (Exception localException3) {}
    try
    {
      localSftpFileAttributes2.setPermissions(paramJFile.getPermissions());
    }
    catch (Exception localException4) {}
    try
    {
      localSftpFileAttributes2.setAtime(paramJFile.getAccessTime());
      localSftpFileAttributes2.setAtimeNseconds(paramJFile.getAccessTimeNsec());
      localSftpFileAttributes2.setCreationTime(paramJFile.getCreationTime());
      localSftpFileAttributes2.setCreationTimeNseconds(paramJFile.getCreationTimeNsec());
      localSftpFileAttributes2.setMtime(paramJFile.getModificationTime());
      localSftpFileAttributes2.setMtimeNseconds(paramJFile.getModificationTimeNsec());
    }
    catch (Exception localException5) {}
    try
    {
      localSftpFileAttributes2.setAcls(paramJFile.getAcl());
    }
    catch (Exception localException6) {}
    return localSftpFileAttributes2;
  }
  
  public void setType(JFileType paramJFileType)
  {
    u.a(paramJFileType);
    this.b = paramJFileType;
  }
  
  public JFileType getType()
  {
    return this.b;
  }
  
  public void setOwner(String paramString)
  {
    this.c = paramString;
    ((AttributePresenceFlags2)this.flags).setOwnerGroupPresent();
  }
  
  public String getOwner()
  {
    return this.c;
  }
  
  public void setGroup(String paramString)
  {
    this.d = paramString;
    ((AttributePresenceFlags2)this.flags).setOwnerGroupPresent();
  }
  
  public String getGroup()
  {
    return this.d;
  }
  
  public void setAtime(long paramLong)
  {
    this.atime = paramLong;
    ((AttributePresenceFlags2)this.flags).setAccessTimePresent();
  }
  
  public long getAtime64()
  {
    return this.atime;
  }
  
  public void setAtimeNseconds(long paramLong)
  {
    this.e = paramLong;
    ((AttributePresenceFlags2)this.flags).setSubSecondTimesPresent();
  }
  
  public long getAtimeNseconds()
  {
    return this.e;
  }
  
  public void setCreationTime(long paramLong)
  {
    this.f = paramLong;
    ((AttributePresenceFlags2)this.flags).setCreateTimePresent();
  }
  
  public long getCreationTime()
  {
    return this.f;
  }
  
  public void setCreationTimeNseconds(long paramLong)
  {
    this.g = paramLong;
    ((AttributePresenceFlags2)this.flags).setSubSecondTimesPresent();
  }
  
  public long getCreationTimeNseconds()
  {
    return this.g;
  }
  
  public void setMtime(long paramLong)
  {
    this.mtime = paramLong;
    ((AttributePresenceFlags2)this.flags).setModifyTimePresent();
  }
  
  public long getMtime64()
  {
    return this.mtime;
  }
  
  public void setMtimeNseconds(long paramLong)
  {
    this.h = paramLong;
    ((AttributePresenceFlags2)this.flags).setSubSecondTimesPresent();
  }
  
  public long getMtimeNseconds()
  {
    return this.h;
  }
  
  public void setAcls(JAcl[] paramArrayOfJAcl)
  {
    u.a(paramArrayOfJAcl);
    this.i = paramArrayOfJAcl;
    ((AttributePresenceFlags2)this.flags).setAclPresent();
  }
  
  public JAcl[] getAcls()
  {
    return this.i;
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    int k = j;
    this.flags.writeTo(paramOutputStream);
    SftpFileType.writeTypeTo(this.b, paramOutputStream);
    AttributePresenceFlags2 localAttributePresenceFlags2 = (AttributePresenceFlags2)this.flags;
    if (k == 0) {
      if (localAttributePresenceFlags2.isSizePresent()) {
        SshUint64.writeLongTo(this.size, paramOutputStream);
      }
    }
    if (k == 0) {
      if (localAttributePresenceFlags2.isOwnerGroupPresent())
      {
        SshString.writeValue(this.c, paramString, paramOutputStream);
        SshString.writeValue(this.d, paramString, paramOutputStream);
      }
    }
    if (k == 0) {
      if (localAttributePresenceFlags2.isPermissionsPresent()) {
        SshUint32.writeIntTo(this.permissions.intValue(), paramOutputStream);
      }
    }
    if (k == 0) {
      if (localAttributePresenceFlags2.isAccessTimePresent())
      {
        SshUint64.writeLongTo(this.atime, paramOutputStream);
        if (k != 0) {
          break label146;
        }
        if (localAttributePresenceFlags2.isSubSecondTimesPresent()) {
          SshUint32.writeLongTo(this.e, paramOutputStream);
        }
      }
    }
    label146:
    if (k == 0) {
      if (localAttributePresenceFlags2.isCreateTimePresent())
      {
        SshUint64.writeLongTo(this.f, paramOutputStream);
        if (k != 0) {
          break label186;
        }
        if (localAttributePresenceFlags2.isSubSecondTimesPresent()) {
          SshUint32.writeLongTo(this.g, paramOutputStream);
        }
      }
    }
    label186:
    if (k == 0) {
      if (localAttributePresenceFlags2.isModifyTimePresent())
      {
        SshUint64.writeLongTo(this.mtime, paramOutputStream);
        if (k != 0) {
          break label226;
        }
        if (localAttributePresenceFlags2.isSubSecondTimesPresent()) {
          SshUint32.writeLongTo(this.h, paramOutputStream);
        }
      }
    }
    if (localAttributePresenceFlags2.isAclPresent()) {
      label226:
      SftpAcl.writeTo(this.i, paramString, paramOutputStream);
    }
    writeExtensionsTo(paramOutputStream, paramString);
  }
  
  public void setupFileAttributes(JFile paramJFile)
  {
    u.a(paramJFile);
    try
    {
      paramJFile.setOwner(this.c);
      paramJFile.setGroup(this.d);
    }
    catch (Exception localException1) {}
    try
    {
      paramJFile.setPermissions(this.permissions);
    }
    catch (Exception localException2) {}
    try
    {
      paramJFile.setAcl(this.i);
    }
    catch (Exception localException3) {}
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SftpFileAttributes2
 * JD-Core Version:    0.7.0.1
 */