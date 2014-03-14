package com.jscape.inet.sftp.packets;

import com.jscape.inet.sftp.SftpPacket;
import java.io.IOException;

public abstract interface PacketDispatcher
{
  public abstract SftpPacket dispatch(Dispatchable paramDispatchable)
    throws IOException;
  
  public abstract SftpPacket onSshFxpClose(SshFxpClose paramSshFxpClose)
    throws IOException;
  
  public abstract SftpPacket onSshFxpFsetstat(SshFxpFsetstat paramSshFxpFsetstat)
    throws IOException;
  
  public abstract SftpPacket onSshFxpFstat(SshFxpFstat paramSshFxpFstat)
    throws IOException;
  
  public abstract SftpPacket onSshFxpInit(SshFxpInit paramSshFxpInit)
    throws IOException;
  
  public abstract SftpPacket onSshFxpLstat(SshFxpLstat paramSshFxpLstat)
    throws IOException;
  
  public abstract SftpPacket onSshFxpMkdir(SshFxpMkdir paramSshFxpMkdir)
    throws IOException;
  
  public abstract SftpPacket onSshFxpOpen(SshFxpOpen paramSshFxpOpen)
    throws IOException;
  
  public abstract SftpPacket onSshFxpOpendir(SshFxpOpendir paramSshFxpOpendir)
    throws IOException;
  
  public abstract SftpPacket onSshFxpRead(SshFxpRead paramSshFxpRead)
    throws IOException;
  
  public abstract SftpPacket onSshFxpReaddir(SshFxpReaddir paramSshFxpReaddir)
    throws IOException;
  
  public abstract SftpPacket onSshFxpRealpath(SshFxpRealpath paramSshFxpRealpath)
    throws IOException;
  
  public abstract SftpPacket onSshFxpRemove(SshFxpRemove paramSshFxpRemove)
    throws IOException;
  
  public abstract SftpPacket onSshFxpRmdir(SshFxpRmdir paramSshFxpRmdir)
    throws IOException;
  
  public abstract SftpPacket onSshFxpSetstat(SshFxpSetstat paramSshFxpSetstat)
    throws IOException;
  
  public abstract SftpPacket onSshFxpStat(SshFxpStat paramSshFxpStat)
    throws IOException;
  
  public abstract SftpPacket onSshFxpWrite(SshFxpWrite paramSshFxpWrite)
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.packets.PacketDispatcher
 * JD-Core Version:    0.7.0.1
 */