package com.jscape.inet.ssh.authentication.messages;

import com.jscape.inet.ssh.transport.Message;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class SshMsgUserauthSuccess
  extends Message
{
  public static final int TYPE = 52;
  private static final String z = -1;
  
  public static SshMsgUserauthSuccess readFrom(InputStream paramInputStream)
  {
    u.a(paramInputStream);
    return new SshMsgUserauthSuccess();
  }
  
  public SshMsgUserauthSuccess()
  {
    super(52);
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(paramOutputStream);
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
 * Qualified Name:     com.jscape.inet.ssh.authentication.messages.SshMsgUserauthSuccess
 * JD-Core Version:    0.7.0.1
 */