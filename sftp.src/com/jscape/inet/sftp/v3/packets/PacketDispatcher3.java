package com.jscape.inet.sftp.v3.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.v2.packets.PacketDispatcher2;
import java.io.IOException;

public abstract interface PacketDispatcher3
  extends PacketDispatcher2
{
  public abstract SftpPacket onSshFxpReadlink(SshFxpReadlink paramSshFxpReadlink)
    throws IOException;
  
  public abstract SftpPacket onSshFxpSymlink(SshFxpSymlink paramSshFxpSymlink)
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v3.packets.PacketDispatcher3
 * JD-Core Version:    0.7.0.1
 */