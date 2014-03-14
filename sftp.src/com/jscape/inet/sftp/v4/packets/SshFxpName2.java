package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SshFxpName;
import com.jscape.inet.ssh.types.SshUint32;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SshFxpName2
  extends SshFxpName
{
  public static SftpPacket readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    int k = SftpFileAttributes2.j;
    long l = SshUint32.readLongFrom(paramInputStream);
    ArrayList localArrayList = new ArrayList();
    int i = SshUint32.readIntFrom(paramInputStream);
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      localArrayList.add(SftpName2.readFrom(paramInputStream, paramString));
      j++;
    } while (k == 0);
    SshFxpName2 localSshFxpName2 = new SshFxpName2(localArrayList);
    localSshFxpName2.setId(l);
    return localSshFxpName2;
  }
  
  public SshFxpName2(List paramList)
  {
    super(paramList);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SshFxpName2
 * JD-Core Version:    0.7.0.1
 */