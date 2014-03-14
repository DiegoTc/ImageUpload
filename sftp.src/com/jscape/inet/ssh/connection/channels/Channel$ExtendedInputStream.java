package com.jscape.inet.ssh.connection.channels;

import com.jscape.util.ab;
import com.jscape.util.u;
import java.io.InputStream;

public final class Channel$ExtendedInputStream
  extends InputStream
{
  private volatile long a = 1L;
  private ab b = new ab();
  private boolean c = false;
  final Channel d;
  
  protected Channel$ExtendedInputStream(Channel paramChannel) {}
  
  public long getDataType()
  {
    return this.a;
  }
  
  public synchronized void close()
  {
    this.c = true;
    notifyAll();
  }
  
  public synchronized int available()
  {
    return this.b.b();
  }
  
  public synchronized void putData(long paramLong, byte[] paramArrayOfByte)
  {
    this.a = paramLong;
    this.b = new ab(paramArrayOfByte);
    notifyAll();
  }
  
  public synchronized int read()
  {
    waitForData();
    return this.b.c();
  }
  
  public synchronized int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    u.a(paramArrayOfByte, paramInt1, paramInt2);
    waitForData();
    return this.b.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected synchronized void waitForData()
  {
    boolean bool = Channel.b;
    do
    {
      for (;;)
      {
        if ((available() != 0) || ((!bool) && (this.c))) {
          return;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
    } while (!bool);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.channels.Channel.ExtendedInputStream
 * JD-Core Version:    0.7.0.1
 */