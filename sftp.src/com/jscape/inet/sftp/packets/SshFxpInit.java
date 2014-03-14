package com.jscape.inet.sftp.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.ssh.types.SshByte;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshFxpInit
  extends SftpPacket
  implements Dispatchable
{
  public static final int TYPE = 1;
  private final int d;
  private static final String z = -1;
  
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    return new SshFxpInit(SshUint32.readIntFrom(paramInputStream));
  }
  
  public SshFxpInit(int paramInt)
  {
    super(1);
    this.d = paramInt;
  }
  
  public int getVersion()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    u.a(paramOutputStream);
    SshByte.writeIntTo(this.type, paramOutputStream);
    SshUint32.writeIntTo(this.d, paramOutputStream);
  }
  
  public SftpPacket accept(PacketDispatcher paramPacketDispatcher)
    throws IOException
  {
    u.a(paramPacketDispatcher);
    return paramPacketDispatcher.onSshFxpInit(this);
  }
  
  public String toString()
  {
    return z + this.d;
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.packets.SshFxpInit
 * JD-Core Version:    0.7.0.1
 */