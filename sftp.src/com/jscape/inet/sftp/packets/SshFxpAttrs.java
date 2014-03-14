package com.jscape.inet.sftp.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshFxpAttrs
  extends SftpPacket
{
  public static final int TYPE = 105;
  private final SftpFileAttributes d;
  private static final String z = -1;
  
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    SshFxpAttrs localSshFxpAttrs = new SshFxpAttrs(SftpFileAttributes.readFrom(paramInputStream, paramString));
    localSshFxpAttrs.setId(l);
    return localSshFxpAttrs;
  }
  
  public SshFxpAttrs(SftpFileAttributes paramSftpFileAttributes)
  {
    super(105);
    u.a(paramSftpFileAttributes);
    this.d = paramSftpFileAttributes;
  }
  
  public SftpFileAttributes getAttrs()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    super.writeTo(paramOutputStream, paramString);
    this.d.writeTo(paramOutputStream, paramString);
  }
  
  public String toString()
  {
    return z + this.d;
  }
  
  static
  {
    break label13;
    break label114;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.packets.SshFxpAttrs
 * JD-Core Version:    0.7.0.1
 */