package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SshFxpMkdir;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;

public class SshFxpMkdir2
  extends SshFxpMkdir
{
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    SshFxpMkdir2 localSshFxpMkdir2 = new SshFxpMkdir2(SshString.readValue(paramInputStream, paramString), (SftpFileAttributes2)SftpFileAttributes2.readFrom(paramInputStream, paramString));
    localSshFxpMkdir2.setId(l);
    return localSshFxpMkdir2;
  }
  
  public SshFxpMkdir2(String paramString, SftpFileAttributes2 paramSftpFileAttributes2)
  {
    super(paramString, paramSftpFileAttributes2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpMkdir2
 * JD-Core Version:    0.7.0.1
 */