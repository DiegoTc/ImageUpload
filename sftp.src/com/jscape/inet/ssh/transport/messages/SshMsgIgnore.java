package com.jscape.inet.ssh.transport.messages;

import com.jscape.inet.ssh.SshReader;
import com.jscape.inet.ssh.SshWriter;
import com.jscape.inet.ssh.transport.Message;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshMsgIgnore
  extends Message
  implements TransportDispatchable
{
  public static final int TYPE = 2;
  private final byte[] d;
  private static final String z = -1;
  
  public static SshMsgIgnore readFrom(InputStream paramInputStream)
  {
    try
    {
      byte[] arrayOfByte = SshString.readValue(paramInputStream);
      return new SshMsgIgnore(arrayOfByte);
    }
    catch (Exception localException) {}
    return new SshMsgIgnore(new byte[0]);
  }
  
  public static Message readFrom(SshReader paramSshReader)
    throws IOException
  {
    u.a(paramSshReader);
    byte[] arrayOfByte = paramSshReader.readStringAsByteArray();
    return new SshMsgIgnore(arrayOfByte);
  }
  
  public SshMsgIgnore(byte[] paramArrayOfByte)
  {
    super(2);
    u.a(paramArrayOfByte);
    this.d = paramArrayOfByte;
  }
  
  public byte[] getData()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(paramOutputStream);
    SshString.writeValue(this.d, paramOutputStream);
  }
  
  public void writeTo(SshWriter paramSshWriter)
    throws IOException
  {
    super.writeTo(paramSshWriter);
    paramSshWriter.writeString(this.d);
  }
  
  public boolean accept(TransportMessageDispatcher paramTransportMessageDispatcher)
  {
    return paramTransportMessageDispatcher.onSshMsgIgnore(this);
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
 * Qualified Name:     com.jscape.inet.ssh.transport.messages.SshMsgIgnore
 * JD-Core Version:    0.7.0.1
 */