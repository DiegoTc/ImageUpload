package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.transport.compression.Compression;
import com.jscape.inet.ssh.transport.kex.KeyExchange;
import com.jscape.inet.ssh.transport.keyformat.KeyFormat;
import com.jscape.inet.ssh.transport.messages.SshMsgKexInit;
import com.jscape.inet.ssh.transport.messages.SshMsgServiceAccept;
import com.jscape.inet.ssh.transport.messages.SshMsgServiceRequest;
import com.jscape.inet.util.ConnectionParameters;
import com.jscape.util.u;
import java.io.IOException;
import java.net.Socket;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class TransportClient
  extends Transport
{
  protected final boolean checkServerKeySignature;
  private static final String z = -1;
  
  public TransportClient(ConnectionParameters paramConnectionParameters, TransportConfiguration paramTransportConfiguration)
    throws IOException
  {
    this(paramConnectionParameters.createSocket(), paramTransportConfiguration, paramConnectionParameters.getConnectionTimeout());
  }
  
  protected TransportClient(Socket paramSocket, TransportConfiguration paramTransportConfiguration, long paramLong)
    throws IOException
  {
    super(paramSocket, paramTransportConfiguration);
    this.checkServerKeySignature = paramTransportConfiguration.checkServerKeySignature();
    this.initTimeout = paramLong;
    initProtocol();
    exchangeKeys();
  }
  
  public ProtocolVersion getClientVersion()
  {
    return this.localVersion;
  }
  
  public ProtocolVersion getServerVersion()
  {
    return this.remoteVersion;
  }
  
  public String getServerBanner()
  {
    return this.remoteVersion.getBanner();
  }
  
  public void requestService(String paramString)
    throws IOException
  {
    u.a(paramString);
    SshMsgServiceRequest localSshMsgServiceRequest = new SshMsgServiceRequest(paramString);
    synchronized (this.reader)
    {
      synchronized (this.writer)
      {
        sendMessage(localSshMsgServiceRequest);
        Message localMessage = receiveMessage();
        assertIsServiceAccept(localMessage);
      }
    }
  }
  
  protected void assertIsServiceAccept(Message paramMessage)
    throws TransportException
  {
    if ((paramMessage instanceof SshMsgServiceAccept)) {
      return;
    }
    throw new TransportException(z + paramMessage);
  }
  
  protected AlgorithmSuite getSuite(SshMsgKexInit paramSshMsgKexInit1, SshMsgKexInit paramSshMsgKexInit2)
    throws TransportException
  {
    return new AlgorithmSuite(paramSshMsgKexInit1, paramSshMsgKexInit2);
  }
  
  protected KeyCreator runKeyExchange()
    throws IOException
  {
    KeyExchange localKeyExchange = this.factory.getKeyExchange(this.currentSuite.getKeyExchange(), this);
    KeyFormat localKeyFormat = this.factory.keyFormatFor(this.currentSuite.getServerHostKeyFormat());
    return localKeyExchange.runClient(this.checkServerKeySignature, localKeyFormat);
  }
  
  protected void setReaderAlgorithms(KeyCreator paramKeyCreator)
    throws TransportException
  {
    Compression localCompression = this.factory.compressionFor(this.currentSuite.getServerClientCompr(), 2);
    Cipher localCipher = getServerClientCipher(paramKeyCreator, 2);
    Mac localMac = getServerClientMac(paramKeyCreator);
    this.reader.setCompression(localCompression);
    this.reader.setCipher(localCipher);
    this.reader.setMac(localMac);
  }
  
  protected void setWriterAlgorithms(KeyCreator paramKeyCreator)
    throws TransportException
  {
    Compression localCompression = this.factory.compressionFor(this.currentSuite.getClientServerCompr(), 1);
    Cipher localCipher = getClientServerCipher(paramKeyCreator, 1);
    Mac localMac = getClientServerMac(paramKeyCreator);
    this.writer.setCompression(localCompression);
    this.writer.setCipher(localCipher);
    this.writer.setMac(localMac);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.TransportClient
 * JD-Core Version:    0.7.0.1
 */