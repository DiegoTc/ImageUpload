package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SshFxpStat;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshFxpStat2
  extends SshFxpStat
{
  private final AttributePresenceFlags2 e;
  private static final String z = -1;
  
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    SshFxpStat2 localSshFxpStat2 = new SshFxpStat2(SshString.readValue(paramInputStream, paramString), (AttributePresenceFlags2)AttributePresenceFlags2.readFrom(paramInputStream, paramString));
    localSshFxpStat2.setId(l);
    return localSshFxpStat2;
  }
  
  public SshFxpStat2(String paramString, AttributePresenceFlags2 paramAttributePresenceFlags2)
  {
    super(paramString);
    u.a(paramAttributePresenceFlags2);
    this.e = paramAttributePresenceFlags2;
  }
  
  public AttributePresenceFlags2 getFlags()
  {
    return this.e;
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    super.writeTo(paramOutputStream, paramString);
    this.e.writeTo(paramOutputStream);
  }
  
  public String toString()
  {
    return super.toString() + z + this.e;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpStat2
 * JD-Core Version:    0.7.0.1
 */