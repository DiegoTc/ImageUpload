package com.jscape.inet.ssh.transport.mac;

import java.security.InvalidKeyException;
import javax.crypto.Mac;

public class NullMac
  extends Mac
{
  public static boolean a;
  
  public NullMac()
  {
    super(new NullMacSpi(), null, null);
    try
    {
      init(null);
    }
    catch (InvalidKeyException localInvalidKeyException) {}
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.mac.NullMac
 * JD-Core Version:    0.7.0.1
 */