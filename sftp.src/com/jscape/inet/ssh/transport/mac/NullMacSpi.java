package com.jscape.inet.ssh.transport.mac;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;

class NullMacSpi
  extends MacSpi
{
  protected void engineInit(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec) {}
  
  protected void engineUpdate(byte paramByte) {}
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  protected byte[] engineDoFinal()
  {
    return new byte[0];
  }
  
  protected void engineReset() {}
  
  protected int engineGetMacLength()
  {
    return 0;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.mac.NullMacSpi
 * JD-Core Version:    0.7.0.1
 */