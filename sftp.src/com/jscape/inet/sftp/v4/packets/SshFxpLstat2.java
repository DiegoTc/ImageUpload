package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SshFxpLstat;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshFxpLstat2
  extends SshFxpLstat
{
  private final AttributePresenceFlags2 e;
  private static final String z = -1;
  
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    long l = SshUint32.readLongFrom(paramInputStream);
    String str = SshString.readValue(paramInputStream, paramString);
    AttributePresenceFlags2 localAttributePresenceFlags2 = (AttributePresenceFlags2)AttributePresenceFlags2.readFrom(paramInputStream, paramString);
    SshFxpLstat2 localSshFxpLstat2 = new SshFxpLstat2(str, localAttributePresenceFlags2);
    localSshFxpLstat2.setId(l);
    return localSshFxpLstat2;
  }
  
  public SshFxpLstat2(String paramString, AttributePresenceFlags2 paramAttributePresenceFlags2)
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
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpLstat2
 * JD-Core Version:    0.7.0.1
 */