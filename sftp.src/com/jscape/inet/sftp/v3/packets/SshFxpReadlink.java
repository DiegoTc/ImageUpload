package com.jscape.inet.sftp.v3.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.Dispatchable;
import com.jscape.inet.sftp.packets.PacketDispatcher;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshFxpReadlink
  extends SftpPacket
  implements Dispatchable
{
  public static final int TYPE = 19;
  private final String d;
  private static final String z = -1;
  
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    SshFxpReadlink localSshFxpReadlink = new SshFxpReadlink(SshString.readValue(paramInputStream, paramString));
    localSshFxpReadlink.setId(l);
    return localSshFxpReadlink;
  }
  
  public SshFxpReadlink(String paramString)
  {
    super(19);
    u.a(paramString);
    this.d = paramString;
  }
  
  public String getPath()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    super.writeTo(paramOutputStream, paramString);
    SshString.writeValue(this.d, paramString, paramOutputStream);
  }
  
  public SftpPacket accept(PacketDispatcher paramPacketDispatcher)
    throws IOException
  {
    u.a(paramPacketDispatcher);
    return ((PacketDispatcher3)paramPacketDispatcher).onSshFxpReadlink(this);
  }
  
  public String toString()
  {
    return z + this.d;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v3.packets.SshFxpReadlink
 * JD-Core Version:    0.7.0.1
 */