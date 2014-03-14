package com.jscape.filetransfer;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

class AftpFileTransfer$SslHandshakeEventForwarder
  implements HandshakeCompletedListener
{
  final AftpFileTransfer a;
  
  private AftpFileTransfer$SslHandshakeEventForwarder(AftpFileTransfer paramAftpFileTransfer) {}
  
  public void handshakeCompleted(HandshakeCompletedEvent paramHandshakeCompletedEvent)
  {
    AftpFileTransfer.access$300(this.a, new FileTransferSslHandshakeEvent(this.a, paramHandshakeCompletedEvent));
  }
  
  AftpFileTransfer$SslHandshakeEventForwarder(AftpFileTransfer paramAftpFileTransfer, AftpFileTransfer.1 param1)
  {
    this(paramAftpFileTransfer);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.AftpFileTransfer.SslHandshakeEventForwarder
 * JD-Core Version:    0.7.0.1
 */