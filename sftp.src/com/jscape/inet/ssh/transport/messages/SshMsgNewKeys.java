package com.jscape.inet.ssh.transport.messages;

import com.jscape.inet.ssh.SshReader;
import com.jscape.inet.ssh.transport.Message;
import com.jscape.util.u;
import java.io.InputStream;

public class SshMsgNewKeys
  extends Message
{
  public static final int TYPE = 21;
  private static final String z = -1;
  
  public static SshMsgNewKeys readFrom(InputStream paramInputStream)
  {
    u.a(paramInputStream);
    return new SshMsgNewKeys();
  }
  
  public static Message readFrom(SshReader paramSshReader)
  {
    u.a(paramSshReader);
    return new SshMsgNewKeys();
  }
  
  public SshMsgNewKeys()
  {
    super(21);
  }
  
  public String toString()
  {
    return z;
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.messages.SshMsgNewKeys
 * JD-Core Version:    0.7.0.1
 */