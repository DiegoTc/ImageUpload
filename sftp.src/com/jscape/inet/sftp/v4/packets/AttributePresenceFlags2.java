package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.packets.SftpFileAttributes.AttributePresenceFlags;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;

public class AttributePresenceFlags2
  extends SftpFileAttributes.AttributePresenceFlags
{
  protected static final int SSH_FILEXFER_ATTR_ACCESSTIME = 8;
  protected static final int SSH_FILEXFER_ATTR_CREATETIME = 16;
  protected static final int SSH_FILEXFER_ATTR_MODIFYTIME = 32;
  protected static final int SSH_FILEXFER_ATTR_ACL = 64;
  protected static final int SSH_FILEXFER_ATTR_OWNERGROUP = 128;
  protected static final int SSH_FILEXFER_ATTR_SUBSECOND_TIMES = 256;
  protected boolean accessTimePresent;
  protected boolean createTimePresent;
  protected boolean modifyTimePresent;
  protected boolean aclPresent;
  protected boolean ownerGroupPresent;
  protected boolean subSecondTimesPresent;
  
  public static SftpFileAttributes.AttributePresenceFlags readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    AttributePresenceFlags2 localAttributePresenceFlags2 = new AttributePresenceFlags2();
    int i = SshUint32.readIntFrom(paramInputStream);
    if (j == 0) {
      if ((i & 0x1) != 0) {
        localAttributePresenceFlags2.setSizePresent();
      }
    }
    if (j == 0) {
      if ((i & 0x2) != 0) {
        localAttributePresenceFlags2.setUidGidPresent();
      }
    }
    if (j == 0) {
      if ((i & 0x4) != 0) {
        localAttributePresenceFlags2.setPermissionsPresent();
      }
    }
    if (j == 0) {
      if ((i & 0x8) != 0) {
        localAttributePresenceFlags2.setAcModTimePresent();
      }
    }
    if (j == 0) {
      if ((i & 0x80000000) != 0) {
        localAttributePresenceFlags2.setExtendedPresent();
      }
    }
    if (j == 0) {
      if ((i & 0x8) != 0) {
        localAttributePresenceFlags2.setAccessTimePresent();
      }
    }
    if (j == 0) {
      if ((i & 0x10) != 0) {
        localAttributePresenceFlags2.setCreateTimePresent();
      }
    }
    if (j == 0) {
      if ((i & 0x20) != 0) {
        localAttributePresenceFlags2.setModifyTimePresent();
      }
    }
    if (j == 0) {
      if ((i & 0x40) != 0) {
        localAttributePresenceFlags2.setAclPresent();
      }
    }
    if (j == 0) {
      if ((i & 0x80) != 0) {
        localAttributePresenceFlags2.setOwnerGroupPresent();
      }
    }
    if ((i & 0x100) != 0) {
      localAttributePresenceFlags2.setSubSecondTimesPresent();
    }
    return localAttributePresenceFlags2;
  }
  
  public boolean isAccessTimePresent()
  {
    return this.accessTimePresent;
  }
  
  public void setAccessTimePresent()
  {
    this.accessTimePresent = true;
  }
  
  public boolean isCreateTimePresent()
  {
    return this.createTimePresent;
  }
  
  public void setCreateTimePresent()
  {
    this.createTimePresent = true;
  }
  
  public boolean isModifyTimePresent()
  {
    return this.modifyTimePresent;
  }
  
  public void setModifyTimePresent()
  {
    this.modifyTimePresent = true;
  }
  
  public boolean isAclPresent()
  {
    return this.aclPresent;
  }
  
  public void setAclPresent()
  {
    this.aclPresent = true;
  }
  
  public boolean isOwnerGroupPresent()
  {
    return this.ownerGroupPresent;
  }
  
  public void setOwnerGroupPresent()
  {
    this.ownerGroupPresent = true;
  }
  
  public boolean isSubSecondTimesPresent()
  {
    return this.subSecondTimesPresent;
  }
  
  public void setSubSecondTimesPresent()
  {
    this.subSecondTimesPresent = true;
  }
  
  protected int asInteger()
  {
    int j = SftpFileAttributes2.j;
    int i = super.asInteger();
    if (j == 0) {
      if (isAccessTimePresent()) {
        i |= 0x8;
      }
    }
    if (j == 0) {
      if (isCreateTimePresent()) {
        i |= 0x10;
      }
    }
    if (j == 0) {
      if (isModifyTimePresent()) {
        i |= 0x20;
      }
    }
    if (j == 0) {
      if (isAclPresent()) {
        i |= 0x40;
      }
    }
    if (j == 0) {
      if (isOwnerGroupPresent()) {
        i |= 0x80;
      }
    }
    if (j == 0) {
      if (isSubSecondTimesPresent()) {
        i |= 0x100;
      }
    }
    return i;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.AttributePresenceFlags2
 * JD-Core Version:    0.7.0.1
 */