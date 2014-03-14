package com.jscape.inet.ssh.transport.messages;

import com.jscape.inet.ssh.SshWriter;
import com.jscape.inet.ssh.transport.Message;
import com.jscape.util.u;
import java.io.IOException;
import java.io.OutputStream;

public class SshMsgUnknown
  extends Message
  implements TransportDispatchable
{
  private final byte[] d;
  private static final String z = -1;
  
  public SshMsgUnknown(int paramInt, byte[] paramArrayOfByte)
  {
    super(paramInt);
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
    paramOutputStream.write(this.d);
  }
  
  public void writeTo(SshWriter paramSshWriter)
    throws IOException
  {
    super.writeTo(paramSshWriter);
    paramSshWriter.write(this.d);
  }
  
  public boolean accept(TransportMessageDispatcher paramTransportMessageDispatcher)
  {
    return paramTransportMessageDispatcher.onSshMsgUnknown(this);
  }
  
  public String toString()
  {
    return z + this.type;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.messages.SshMsgUnknown
 * JD-Core Version:    0.7.0.1
 */