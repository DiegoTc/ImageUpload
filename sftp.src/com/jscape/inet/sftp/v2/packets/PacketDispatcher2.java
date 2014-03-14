package com.jscape.inet.sftp.v2.packets;

import com.jscape.inet.sftp.SftpPacket;
import com.jscape.inet.sftp.packets.PacketDispatcher;
import java.io.IOException;

public abstract interface PacketDispatcher2
  extends PacketDispatcher
{
  public abstract SftpPacket onSshFxpRename(SshFxpRename paramSshFxpRename)
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v2.packets.PacketDispatcher2
 * JD-Core Version:    0.7.0.1
 */