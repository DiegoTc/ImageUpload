package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SshFxpSetstat;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;

public class SshFxpSetstat2
  extends SshFxpSetstat
{
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    SshFxpSetstat2 localSshFxpSetstat2 = new SshFxpSetstat2(SshString.readValue(paramInputStream, paramString), (SftpFileAttributes2)SftpFileAttributes2.readFrom(paramInputStream, paramString));
    localSshFxpSetstat2.setId(l);
    return localSshFxpSetstat2;
  }
  
  public SshFxpSetstat2(String paramString, SftpFileAttributes2 paramSftpFileAttributes2)
  {
    super(paramString, paramSftpFileAttributes2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpSetstat2
 * JD-Core Version:    0.7.0.1
 */