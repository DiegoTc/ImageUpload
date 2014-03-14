package com.jscape.inet.ssh.transport.kex.messages;

import com.jscape.inet.ssh.transport.Message;
import com.jscape.inet.ssh.types.SshMpint;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class SshMsgKexDhInit
  extends Message
{
  public static final int TYPE = 30;
  private final BigInteger d;
  private static final String z = -1;
  
  public static SshMsgKexDhInit readFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    BigInteger localBigInteger = SshMpint.readBigIntegerFrom(paramInputStream);
    return new SshMsgKexDhInit(localBigInteger);
  }
  
  public SshMsgKexDhInit(BigInteger paramBigInteger)
  {
    super(30);
    u.a(paramBigInteger);
    this.d = paramBigInteger;
  }
  
  public BigInteger getE()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(paramOutputStream);
    SshMpint.writeBigIntegerTo(this.d, paramOutputStream);
  }
  
  public String toString()
  {
    return z + this.d;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.kex.messages.SshMsgKexDhInit
 * JD-Core Version:    0.7.0.1
 */