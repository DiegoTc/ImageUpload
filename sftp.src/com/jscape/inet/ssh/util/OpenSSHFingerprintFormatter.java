package com.jscape.inet.ssh.util;

import com.jscape.a.f;
import com.jscape.util.pb;

public class OpenSSHFingerprintFormatter
  implements KeyFingerprintFormatter
{
  public String format(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = f.e().b(paramArrayOfByte);
    return pb.a(arrayOfByte, ":");
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.OpenSSHFingerprintFormatter
 * JD-Core Version:    0.7.0.1
 */