package com.jscape.inet.ssh.util.keyreader.openssh;

import com.jscape.inet.ssh.util.keyreader.KeyPairSpec;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class RSAFormat
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
    if (u.a) {
      Record.f = !bool;
    }
    return new KeyPairSpec(k, new RSAPublicKeySpec(localBigInteger1, localBigInteger2), new RSAPrivateKeySpec(localBigInteger1, localBigInteger3));
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.openssh.RSAFormat
 * JD-Core Version:    0.7.0.1
 */