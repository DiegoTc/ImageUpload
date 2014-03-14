package com.jscape.inet.sftp.packets;

import com.jscape.inet.sftp.SftpPacket;
import java.io.IOException;

public abstract interface Dispatchable
{
  public abstract SftpPacket accept(PacketDispatcher paramPacketDispatcher)
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.packets.Dispatchable
 * JD-Core Version:    0.7.0.1
 */