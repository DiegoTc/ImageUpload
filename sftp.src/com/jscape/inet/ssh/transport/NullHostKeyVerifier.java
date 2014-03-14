package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.util.HostKeyVerifier;
import java.io.Serializable;
import java.net.InetAddress;

public class NullHostKeyVerifier
  implements HostKeyVerifier, Serializable
{
  public void verify(InetAddress paramInetAddress, byte[] paramArrayOfByte) {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.NullHostKeyVerifier
 * JD-Core Version:    0.7.0.1
 */