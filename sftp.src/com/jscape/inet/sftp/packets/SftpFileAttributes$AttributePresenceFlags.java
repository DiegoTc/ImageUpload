package com.jscape.inet.sftp.packets;

import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SftpFileAttributes$AttributePresenceFlags
{
  protected static final int SSH_FILEXFER_ATTR_SIZE = 1;
  protected static final int SSH_FILEXFER_ATTR_UIDGID = 2;
  protected static final int SSH_FILEXFER_ATTR_PERMISSIONS = 4;
  protected static final int SSH_FILEXFER_ATTR_ACMODTIME = 8;
  protected static final int SSH_FILEXFER_ATTR_EXTENDED = -2147483648;
  protected boolean sizePresent = false;
  protected boolean uidGidPresent = false;
  protected boolean permissionsPresent = false;
  protected boolean acModTimePresent = false;
  protected boolean extendedPresent = false;
  
  public static AttributePresenceFlags readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    boolean bool = SftpFileAttributes.a;
    AttributePresenceFlags localAttributePresenceFlags = new AttributePresenceFlags();
    int i = SshUint32.readIntFrom(paramInputStream);
    if (!bool) {
      if ((i & 0x1) != 0) {
        localAttributePresenceFlags.setSizePresent();
      }
    }
    if (!bool) {
      if ((i & 0x2) != 0) {
        localAttributePresenceFlags.setUidGidPresent();
      }
    }
    if (!bool) {
      if ((i & 0x4) != 0) {
        localAttributePresenceFlags.setPermissionsPresent();
      }
    }
    if (!bool) {
      if ((i & 0x8) != 0) {
        localAttributePresenceFlags.setAcModTimePresent();
      }
    }
    if ((i & 0x80000000) != 0) {
      localAttributePresenceFlags.setExtendedPresent();
    }
    return localAttributePresenceFlags;
  }
  
  public boolean isSizePresent()
  {
    return this.sizePresent;
  }
  
  public void setSizePresent()
  {
    this.sizePresent = true;
  }
  
  public boolean isUidGidPresent()
  {
    return this.uidGidPresent;
  }
  
  public void setUidGidPresent()
  {
    this.uidGidPresent = true;
  }
  
  public boolean isPermissionsPresent()
  {
    return this.permissionsPresent;
  }
  
  public void setPermissionsPresent()
  {
    this.permissionsPresent = true;
  }
  
  public boolean isAcModTimePresent()
  {
    return this.acModTimePresent;
  }
  
  public void setAcModTimePresent()
  {
    this.acModTimePresent = true;
  }
  
  public boolean isExtendedPresent()
  {
    return this.extendedPresent;
  }
  
  public void setExtendedPresent()
  {
    this.extendedPresent = true;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramOutputStream);
    new SshUint32(asInteger()).writeTo(paramOutputStream);
  }
  
  protected int asInteger()
  {
    boolean bool = SftpFileAttributes.a;
    int i = 0;
    if (!bool) {
      if (isSizePresent()) {
        i |= 0x1;
      }
    }
    if (!bool) {
      if (isUidGidPresent()) {
        i |= 0x2;
      }
    }
    if (!bool) {
      if (isPermissionsPresent()) {
        i |= 0x4;
      }
    }
    if (!bool) {
      if (isAcModTimePresent()) {
        i |= 0x8;
      }
    }
    if (!bool) {
      if (isExtendedPresent()) {
        i |= 0x80000000;
      }
    }
    return i;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.packets.SftpFileAttributes.AttributePresenceFlags
 * JD-Core Version:    0.7.0.1
 */