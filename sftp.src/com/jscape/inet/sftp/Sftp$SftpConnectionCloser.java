package com.jscape.inet.sftp;

import com.jscape.inet.sftp.events.SftpDisconnectedEvent;
import com.jscape.inet.ssh.connection.Connection;
import com.jscape.inet.ssh.connection.Connection.ConnectionClosedListener;
import com.jscape.inet.ssh.util.SshParameters;
import com.jscape.inet.util.a.a;

class Sftp$SftpConnectionCloser
  implements Connection.ConnectionClosedListener
{
  private final Sftp a;
  final Sftp b;
  
  public Sftp$SftpConnectionCloser(Sftp paramSftp1, Sftp paramSftp2)
  {
    this.a = paramSftp2;
  }
  
  public void onConnectionClosed(Connection paramConnection)
  {
    try
    {
      if ((SftpPacket.c) || (this.a.isConnected()))
      {
        SftpClient localSftpClient = (SftpClient)Sftp.g(this.a);
        localSftpClient.reader.close();
        localSftpClient.writer.close();
        localSftpClient.logger.close();
        localSftpClient.connection.close();
        Sftp.a(this.b, new SftpDisconnectedEvent(this.b, Sftp.a(this.b).getSshHostname()));
      }
    }
    catch (Exception localException) {}
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.Sftp.SftpConnectionCloser
 * JD-Core Version:    0.7.0.1
 */