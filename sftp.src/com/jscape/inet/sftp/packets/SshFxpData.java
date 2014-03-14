package com.jscape.inet.sftp.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshFxpData
  extends SftpPacket
{
  public static final int TYPE = 103;
  private final byte[] d;
  private static final String z = -1;
  
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    return new SshFxpData(l, SshString.readValue(paramInputStream));
  }
  
  private SshFxpData(long paramLong, byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte);
    setId(paramLong);
  }
  
  public SshFxpData(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public SshFxpData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(103);
    this.d = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.d, 0, this.d.length);
  }
  
  public byte[] getData()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    super.writeTo(paramOutputStream, paramString);
    SshString.writeValue(this.d, paramOutputStream);
  }
  
  public String toString()
  {
    return z;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.packets.SshFxpData
 * JD-Core Version:    0.7.0.1
 */