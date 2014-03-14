package com.jscape.filetransfer;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

public class FtpsTransfer$SslHandshakeEventConverter
  implements HandshakeCompletedListener
{
  final FtpsTransfer a;
  
  protected FtpsTransfer$SslHandshakeEventConverter(FtpsTransfer paramFtpsTransfer) {}
  
  public void handshakeCompleted(HandshakeCompletedEvent paramHandshakeCompletedEvent)
  {
    this.a.raiseEvent(new FileTransferSslHandshakeEvent(this.a, paramHandshakeCompletedEvent));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FtpsTransfer.SslHandshakeEventConverter
 * JD-Core Version:    0.7.0.1
 */