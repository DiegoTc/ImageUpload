package com.jscape.inet.ssh.connection.channels;

import com.jscape.inet.ssh.connection.messages.SshMsgChannelExtendedData;
import com.jscape.util.u;
import java.io.IOException;
import java.io.OutputStream;

public final class Channel$ExtendedOutputStream
  extends OutputStream
{
  private volatile long a = 1L;
  final Channel b;
  
  protected Channel$ExtendedOutputStream(Channel paramChannel) {}
  
  public long getDataType()
  {
    return this.a;
  }
  
  public void setDataType(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void close() {}
  
  public void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = { (byte)(paramInt & 0xFF) };
    write(arrayOfByte);
  }
  
  public synchronized void write(byte[] paramArrayOfByte)
    throws IOException
  {
    u.a(paramArrayOfByte);
    SshMsgChannelExtendedData localSshMsgChannelExtendedData = new SshMsgChannelExtendedData(this.b.getRemoteNo(), this.a, paramArrayOfByte);
    this.b.sendMessage(localSshMsgChannelExtendedData);
  }
  
  public synchronized void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    u.a(paramArrayOfByte, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, arrayOfByte.length);
    write(arrayOfByte);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.channels.Channel.ExtendedOutputStream
 * JD-Core Version:    0.7.0.1
 */