package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SshFxpFsetstat;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;

public class SshFxpFsetstat2
  extends SshFxpFsetstat
{
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    byte[] arrayOfByte = SshString.readValue(paramInputStream);
    SftpFileAttributes2 localSftpFileAttributes2 = (SftpFileAttributes2)SftpFileAttributes2.readFrom(paramInputStream, paramString);
    SshFxpFsetstat2 localSshFxpFsetstat2 = new SshFxpFsetstat2(arrayOfByte, localSftpFileAttributes2);
    localSshFxpFsetstat2.setId(l);
    return localSshFxpFsetstat2;
  }
  
  public SshFxpFsetstat2(byte[] paramArrayOfByte, SftpFileAttributes2 paramSftpFileAttributes2)
  {
    super(paramArrayOfByte, paramSftpFileAttributes2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpFsetstat2
 * JD-Core Version:    0.7.0.1
 */