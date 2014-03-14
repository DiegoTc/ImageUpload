package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SshFxpAttrs;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;

public class SshFxpAttrs2
  extends SshFxpAttrs
{
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    SshFxpAttrs2 localSshFxpAttrs2 = new SshFxpAttrs2((SftpFileAttributes2)SftpFileAttributes2.readFrom(paramInputStream, paramString));
    localSshFxpAttrs2.setId(l);
    return localSshFxpAttrs2;
  }
  
  public SshFxpAttrs2(SftpFileAttributes2 paramSftpFileAttributes2)
  {
    super(paramSftpFileAttributes2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpAttrs2
 * JD-Core Version:    0.7.0.1
 */