package com.jscape.inet.sftp.requests;

import com.jscape.inet.file.JFilePermissions;
import com.jscape.inet.file.JFilePermissions.Permission;
import com.jscape.inet.file.JFileType;
import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SftpFileAttributes.AttributePresenceFlags;
import com.jscape.inet.sftp.v4.packets.AttributePresenceFlags2;
import com.jscape.inet.sftp.v4.packets.SftpFileAttributes2;
import com.jscape.inet.sftp.v4.packets.SshFxpAttrs2;
import com.jscape.inet.sftp.v4.packets.SshFxpLstat2;
import com.jscape.inet.sftp.v4.packets.SshFxpStat2;
import com.jscape.util.u;
import java.util.Date;

public class AttributesRequest4
  extends AttributesRequest3
{
  protected SftpPacket getRequestPacket()
  {
    AttributePresenceFlags2 localAttributePresenceFlags2 = new AttributePresenceFlags2();
    localAttributePresenceFlags2.setSizePresent();
    localAttributePresenceFlags2.setPermissionsPresent();
    localAttributePresenceFlags2.setModifyTimePresent();
    return this.followLink ? new SshFxpLstat2(this.path, localAttributePresenceFlags2) : new SshFxpStat2(this.path, localAttributePresenceFlags2);
  }
  
  protected boolean isValidResponse(SftpPacket paramSftpPacket)
  {
    return paramSftpPacket.getClass().equals(SshFxpAttrs2.class);
  }
  
  protected void processResponse(SftpPacket paramSftpPacket)
  {
    boolean bool = AttributesRequest.a;
    SftpFileAttributes2 localSftpFileAttributes2 = (SftpFileAttributes2)((SshFxpAttrs2)paramSftpPacket).getAttrs();
    this.isDirectory = new Boolean(localSftpFileAttributes2.getType() == JFileType.DIRECTORY);
    if (!bool) {
      if (localSftpFileAttributes2.getFlags().isSizePresent()) {
        this.size = new Long(localSftpFileAttributes2.getSize());
      }
    }
    if (!bool) {
      if (localSftpFileAttributes2.getFlags().isPermissionsPresent())
      {
        int i = localSftpFileAttributes2.getPermissions().getOwnerPermission().intValue();
        int j = localSftpFileAttributes2.getPermissions().getGroupPermission().intValue();
        int k = localSftpFileAttributes2.getPermissions().getOtherPermission().intValue();
        this.permissions = new Integer(i * 100 + j * 10 + k);
      }
    }
    if (localSftpFileAttributes2.getFlags().isAcModTimePresent()) {
      this.modificationDate = new Date(localSftpFileAttributes2.getMtime() * 1000L);
    }
    if (bool) {
      u.a = !u.a;
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.AttributesRequest4
 * JD-Core Version:    0.7.0.1
 */