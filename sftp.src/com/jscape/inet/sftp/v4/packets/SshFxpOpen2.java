package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.file.JAcl.Mask;
import com.jscape.inet.file.JFileOpenFlags;
import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SftpFileAttributes;
import com.jscape.inet.sftp.packets.SshFxpOpen;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshFxpOpen2
  extends SshFxpOpen
{
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    String str = SshString.readValue(paramInputStream, paramString);
    SftpFileOpenFlags2 localSftpFileOpenFlags2 = (SftpFileOpenFlags2)SftpFileOpenFlags2.readFrom(paramInputStream, paramString);
    SftpFileAttributes2 localSftpFileAttributes2 = (SftpFileAttributes2)SftpFileAttributes2.readFrom(paramInputStream, paramString);
    SshFxpOpen2 localSshFxpOpen2 = new SshFxpOpen2(str, localSftpFileOpenFlags2.asOpenFlags(), localSftpFileOpenFlags2.asAccessType(), localSftpFileAttributes2);
    localSshFxpOpen2.setId(l);
    return localSshFxpOpen2;
  }
  
  public SshFxpOpen2(String paramString, JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask, SftpFileAttributes2 paramSftpFileAttributes2)
  {
    super(paramString, paramJFileOpenFlags, paramMask, paramSftpFileAttributes2);
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    super.writeTo(paramOutputStream, paramString);
    SshString.writeValue(this.fileName, paramString, paramOutputStream);
    SftpFileOpenFlags2.writeFlagsTo(this.flags, this.accessType, paramOutputStream);
    this.attrs.writeTo(paramOutputStream, paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpOpen2
 * JD-Core Version:    0.7.0.1
 */