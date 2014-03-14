package com.jscape.inet.ssh.connection.messages;

import com.jscape.inet.ssh.transport.Message;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshMsgRequestFailure
  extends Message
  implements ConnectionDispatchable
{
  public static final int TYPE = 82;
  private static final String z = -1;
  
  public static SshMsgRequestFailure readFrom(InputStream paramInputStream)
  {
    u.a(paramInputStream);
    return new SshMsgRequestFailure();
  }
  
  public SshMsgRequestFailure()
  {
    super(82);
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(paramOutputStream);
  }
  
  public void accept(ConnectionMessageDispatcher paramConnectionMessageDispatcher)
  {
    u.a(paramConnectionMessageDispatcher);
    paramConnectionMessageDispatcher.onSsgMsgRequestFailure(this);
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
 * Qualified Name:     com.jscape.inet.ssh.connection.messages.SshMsgRequestFailure
 * JD-Core Version:    0.7.0.1
 */