package com.jscape.inet.ssh.util.keyreader.sshcom;

import com.jscape.inet.ssh.util.keyreader.KeyPairSpec;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;

public class DSAFormat
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
    localDataReader2.readMpint();
    BigInteger localBigInteger1 = localDataReader2.readMpint();
    BigInteger localBigInteger2 = localDataReader2.readMpint();
    BigInteger localBigInteger3 = localDataReader2.readMpint();
    BigInteger localBigInteger4 = localDataReader2.readMpint();
    BigInteger localBigInteger5 = localDataReader2.readMpint();
    if (bool) {
      u.a = !u.a;
    }
    return new KeyPairSpec(i, new DSAPublicKeySpec(localBigInteger4, localBigInteger1, localBigInteger3, localBigInteger2), new DSAPrivateKeySpec(localBigInteger5, localBigInteger1, localBigInteger3, localBigInteger2));
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.sshcom.DSAFormat
 * JD-Core Version:    0.7.0.1
 */