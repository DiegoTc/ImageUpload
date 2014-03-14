package com.jscape.inet.ssh.transport.kex;

import com.jscape.inet.ssh.transport.KeyCreator;
import com.jscape.inet.ssh.transport.Transport;
import com.jscape.inet.ssh.transport.keyformat.KeyFormat;
import com.jscape.util.u;
import java.io.IOException;
import java.security.KeyPair;

public abstract class KeyExchange
{
  protected final Transport transport;
  protected final String algorithm;
  public static boolean a;
  
  protected KeyExchange(String paramString, Transport paramTransport)
  {
    u.a(paramString);
    u.a(paramTransport);
    this.algorithm = paramString;
    this.transport = paramTransport;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  public abstract KeyCreator runClient(boolean paramBoolean, KeyFormat paramKeyFormat)
    throws IOException;
  
  public abstract KeyCreator runServer(KeyPair paramKeyPair, KeyFormat paramKeyFormat)
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.kex.KeyExchange
 * JD-Core Version:    0.7.0.1
 */