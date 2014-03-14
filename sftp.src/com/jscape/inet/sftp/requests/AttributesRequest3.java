package com.jscape.inet.sftp.requests;

import com.jscape.inet.sftp.RequestException;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.SftpExceptionFactory;
import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.v3.packets.SshFxpStatus2;

public class AttributesRequest3
  extends AttributesRequest
{
  protected SftpException getException(SftpPacket paramSftpPacket1, SftpPacket paramSftpPacket2)
  {
    if ((AttributesRequest.a) || (paramSftpPacket2.getClass().equals(SshFxpStatus2.class)))
    {
      SshFxpStatus2 localSshFxpStatus2 = (SshFxpStatus2)paramSftpPacket2;
      return SftpExceptionFactory.getException(localSshFxpStatus2, localSshFxpStatus2.getMessage());
    }
    return new RequestException(paramSftpPacket1, paramSftpPacket2);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.AttributesRequest3
 * JD-Core Version:    0.7.0.1
 */