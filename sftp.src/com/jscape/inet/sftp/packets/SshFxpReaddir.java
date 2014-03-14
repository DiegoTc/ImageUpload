package com.jscape.inet.sftp.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class SshFxpReaddir
  extends SftpPacket
  implements Dispatchable
{
  public static final int TYPE = 12;
  private final byte[] d;
  private static final String z = -1;
  
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    return new SshFxpReaddir(l, SshString.readValue(paramInputStream));
  }
  
  private SshFxpReaddir(long paramLong, byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte);
    setId(paramLong);
  }
  
  public SshFxpReaddir(byte[] paramArrayOfByte)
  {
    super(12);
    u.a(paramArrayOfByte);
    this.d = paramArrayOfByte;
  }
  
  public byte[] getHandle()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    super.writeTo(paramOutputStream, paramString);
    SshString.writeValue(this.d, paramOutputStream);
  }
  
  public SftpPacket accept(PacketDispatcher paramPacketDispatcher)
    throws IOException
  {
    u.a(paramPacketDispatcher);
    return paramPacketDispatcher.onSshFxpReaddir(this);
  }
  
  public String toString()
  {
    return z + Arrays.toString(this.d);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.packets.SshFxpReaddir
 * JD-Core Version:    0.7.0.1
 */