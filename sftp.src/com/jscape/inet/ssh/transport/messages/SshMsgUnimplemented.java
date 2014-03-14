package com.jscape.inet.ssh.transport.messages;

import com.jscape.inet.ssh.SshReader;
import com.jscape.inet.ssh.SshWriter;
import com.jscape.inet.ssh.transport.Message;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshMsgUnimplemented
  extends Message
{
  public static final int TYPE = 3;
  private final long d;
  private static final String z = -1;
  
  public static SshMsgUnimplemented readFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    long l = SshUint32.readLongFrom(paramInputStream);
    return new SshMsgUnimplemented(l);
  }
  
  public static Message readFrom(SshReader paramSshReader)
    throws IOException
  {
    u.a(paramSshReader);
    long l = paramSshReader.readUint32();
    return new SshMsgUnimplemented(l);
  }
  
  public SshMsgUnimplemented(long paramLong)
  {
    super(3);
    this.d = paramLong;
  }
  
  public long getMessageNo()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(paramOutputStream);
    SshUint32.writeLongTo(this.d, paramOutputStream);
  }
  
  public void writeTo(SshWriter paramSshWriter)
    throws IOException
  {
    super.writeTo(paramSshWriter);
    paramSshWriter.writeUint32(this.d);
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
 * Qualified Name:     com.jscape.inet.ssh.transport.messages.SshMsgUnimplemented
 * JD-Core Version:    0.7.0.1
 */