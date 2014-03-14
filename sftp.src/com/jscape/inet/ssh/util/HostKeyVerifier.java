package com.jscape.inet.ssh.util;

import java.net.InetAddress;

public abstract interface HostKeyVerifier
{
  public abstract void verify(InetAddress paramInetAddress, byte[] paramArrayOfByte)
    throws HostKeyVerifier.VerificationException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.HostKeyVerifier
 * JD-Core Version:    0.7.0.1
 */