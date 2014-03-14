package com.jscape.inet.ssh.util.keyreader.openssh;

import com.jscape.inet.ssh.util.keyreader.KeyPairSpec;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;

public class DSAFormat
  extends OpenSSHFormat
{
  private static final String k = -1;
  
  protected String getAlgorithm()
  {
    return k;
  }
  
  protected KeyPairSpec restoreKeyPair(Record paramRecord)
    throws IOException
  {
    boolean bool = Record.f;
    DataReader localDataReader = new DataReader(new ByteArrayInputStream(paramRecord.getKeyPairData()));
    localDataReader.readByte();
    localDataReader.readLength();
    localDataReader.readByte();
    localDataReader.readBigInteger();
    localDataReader.readByte();
    BigInteger localBigInteger1 = localDataReader.readBigInteger();
    localDataReader.readByte();
    BigInteger localBigInteger2 = localDataReader.readBigInteger();
    localDataReader.readByte();
    BigInteger localBigInteger3 = localDataReader.readBigInteger();
    localDataReader.readByte();
    BigInteger localBigInteger4 = localDataReader.readBigInteger();
    localDataReader.readByte();
    BigInteger localBigInteger5 = localDataReader.readBigInteger();
    if (bool) {
      u.a = !u.a;
    }
    return new KeyPairSpec(k, new DSAPublicKeySpec(localBigInteger4, localBigInteger1, localBigInteger2, localBigInteger3), new DSAPrivateKeySpec(localBigInteger5, localBigInteger1, localBigInteger2, localBigInteger3));
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.openssh.DSAFormat
 * JD-Core Version:    0.7.0.1
 */