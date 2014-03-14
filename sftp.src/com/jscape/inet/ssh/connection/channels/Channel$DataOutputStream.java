package com.jscape.inet.ssh.connection.channels;

import com.jscape.inet.ssh.connection.messages.SshMsgChannelData;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelEof;
import java.io.IOException;
import java.io.OutputStream;

public final class Channel$DataOutputStream
  extends OutputStream
{
  private long a;
  private final int b;
  private boolean c;
  final Channel d;
  private static final String z = -1;
  
  public Channel$DataOutputStream(Channel paramChannel, long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = ((int)paramLong2);
  }
  
  public synchronized void close()
  {
    if (!Channel.b)
    {
      if (this.c) {
        return;
      }
      this.c = true;
    }
    try
    {
      this.d.sendMessage(new SshMsgChannelEof(this.d.getRemoteNo()));
    }
    catch (Exception localException) {}
    try
    {
      super.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    notifyAll();
  }
  
  public synchronized void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = ((byte)paramInt);
    write(arrayOfByte);
  }
  
  public synchronized void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool = Channel.b;
    int i = 0;
    do
    {
      if (0 >= paramInt2) {
        break;
      }
      if (!bool) {
        if (this.a == 0L) {
          b();
        }
      }
      i = (int)a(paramInt2);
      byte[] arrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2, i);
      SshMsgChannelData localSshMsgChannelData = new SshMsgChannelData(this.d.getRemoteNo(), arrayOfByte);
      this.d.sendMessage(localSshMsgChannelData);
      paramInt1 += i;
      paramInt2 -= i;
      this.a -= i;
    } while (!bool);
  }
  
  public synchronized void flush()
    throws IOException
  {}
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = Channel.b;
    if (!bool) {
      if (paramInt1 == 0)
      {
        if (bool) {
          break label40;
        }
        if (paramInt2 == paramArrayOfByte.length)
        {
          if (bool) {
            break label40;
          }
          if (paramInt2 == paramInt3) {
            return paramArrayOfByte;
          }
        }
      }
    }
    label40:
    byte[] arrayOfByte = new byte[paramInt3];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  private long a(int paramInt)
  {
    return Math.min(Math.min(paramInt, this.a), this.b);
  }
  
  public synchronized void adjustWindow(long paramLong)
  {
    this.a += paramLong;
    notifyAll();
  }
  
  private synchronized void b()
    throws IOException
  {
    boolean bool = Channel.b;
    do
    {
      for (;;)
      {
        if (this.a != 0L) {
          break label40;
        }
        if ((bool) || (bool)) {
          break label44;
        }
        if (this.c) {
          break label40;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
    } while (!bool);
    label40:
    if (this.c) {
      label44:
      throw new IOException(z);
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.channels.Channel.DataOutputStream
 * JD-Core Version:    0.7.0.1
 */