package com.jscape.inet.ssh.connection.messages;

import com.jscape.inet.ssh.transport.Message;
import com.jscape.inet.ssh.util.ReadUtil;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshMsgRequestSuccess
  extends Message
  implements ConnectionDispatchable
{
  public static final int TYPE = 81;
  private final byte[] d;
  private static final String z = -1;
  
  public static SshMsgRequestSuccess readFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    byte[] arrayOfByte = new byte[paramInputStream.available()];
    ReadUtil.read(arrayOfByte, paramInputStream);
    return new SshMsgRequestSuccess(arrayOfByte);
  }
  
  public SshMsgRequestSuccess(byte[] paramArrayOfByte)
  {
    super(81);
    u.a(paramArrayOfByte);
    this.d = paramArrayOfByte;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(paramOutputStream);
    paramOutputStream.write(this.d);
  }
  
  public byte[] getData()
  {
    return this.d;
  }
  
  public void accept(ConnectionMessageDispatcher paramConnectionMessageDispatcher)
  {
    u.a(paramConnectionMessageDispatcher);
    paramConnectionMessageDispatcher.onSshMsgRequestSuccess(this);
  }
  
  public String toString()
  {
    return z;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.messages.SshMsgRequestSuccess
 * JD-Core Version:    0.7.0.1
 */