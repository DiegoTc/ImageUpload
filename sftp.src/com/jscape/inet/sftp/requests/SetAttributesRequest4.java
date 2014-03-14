package com.jscape.inet.sftp.requests;

import com.jscape.inet.file.JFilePermissions;
import com.jscape.inet.file.JFilePermissions.Permission;
import com.jscape.inet.file.JFileType;
import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.v4.packets.SftpFileAttributes2;
import com.jscape.inet.sftp.v4.packets.SshFxpSetstat2;
import java.util.Date;

public class SetAttributesRequest4
  extends SetAttributesRequest3
{
  protected SftpPacket getRequestPacket()
  {
    boolean bool = AttributesRequest.a;
    SftpFileAttributes2 localSftpFileAttributes2 = new SftpFileAttributes2();
    if (!bool) {
      if (this.permissions != null)
      {
        JFilePermissions.Permission localPermission1 = new JFilePermissions.Permission(this.permissions.intValue() / 100);
        JFilePermissions.Permission localPermission2 = new JFilePermissions.Permission(this.permissions.intValue() / 10 % 10);
        JFilePermissions.Permission localPermission3 = new JFilePermissions.Permission(this.permissions.intValue() % 10);
        localSftpFileAttributes2.setPermissions(new JFilePermissions(JFileType.UNKNOWN, localPermission1, localPermission2, localPermission3));
      }
    }
    if ((bool) || (this.modificationTime != null))
    {
      long l = this.modificationTime.getTime() / 1000L;
      localSftpFileAttributes2.setAtime(l);
      localSftpFileAttributes2.setMtime(l);
    }
    return new SshFxpSetstat2(this.path, localSftpFileAttributes2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.SetAttributesRequest4
 * JD-Core Version:    0.7.0.1
 */