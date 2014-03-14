package com.jscape.inet.sftp.requests;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.SftpName;
import com.jscape.inet.sftp.v4.packets.SshFxpName2;

public class RealPathRequest4
  extends RealPathRequest3
{
  protected boolean isValidResponse(SftpPacket paramSftpPacket)
  {
    boolean bool = AttributesRequest.a;
    if ((bool) || (paramSftpPacket.getClass().equals(SshFxpName2.class))) {
      if (bool) {}
    }
    return ((SshFxpName2)paramSftpPacket).getNames().length > 0;
  }
  
  protected void processResponse(SftpPacket paramSftpPacket)
  {
    this.realPath = ((SshFxpName2)paramSftpPacket).getNames()[0].getFileName();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.RealPathRequest4
 * JD-Core Version:    0.7.0.1
 */