package com.jscape.inet.ssh.util.keyreader.sshcom;

import com.jscape.inet.ssh.util.keyreader.KeyPairSpec;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class RSAFormat
  extends SSHComFormat
{
  private static final String i = -1;
  
  protected String getAlgorithm()
  {
    return i;
  }
  
  protected KeyPairSpec restoreKeyPair(Record paramRecord)
    throws IOException
  {
    boolean bool = SSHComFormat.h;
    DataReader localDataReader1 = new DataReader(new ByteArrayInputStream(paramRecord.getKeyPairData()));
    DataReader localDataReader2 = new DataReader(new ByteArrayInputStream(localDataReader1.readStringAsByteArray()));
    BigInteger localBigInteger1 = localDataReader2.readMpint();
    BigInteger localBigInteger2 = localDataReader2.readMpint();
    BigInteger localBigInteger3 = localDataReader2.readMpint();
    if (u.a) {
      SSHComFormat.h = !bool;
    }
    return new KeyPairSpec(i, new RSAPublicKeySpec(localBigInteger3, localBigInteger1), new RSAPrivateKeySpec(localBigInteger3, localBigInteger2));
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.sshcom.RSAFormat
 * JD-Core Version:    0.7.0.1
 */