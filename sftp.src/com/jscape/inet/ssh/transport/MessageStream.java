package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.transport.compression.Compression;
import com.jscape.inet.ssh.util.Sequence;
import com.jscape.util.u;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public abstract class MessageStream
{
  private static final int a = 32768;
  protected static final int PACKET_LEN_SIZE = 4;
  protected static final int PADDING_LEN_SIZE = 1;
  protected final Sequence sequence = new Sequence();
  protected Compression compression = null;
  protected Cipher cipher = null;
  protected Mac mac = null;
  protected long bytesCount = 0L;
  protected byte[] buffer = new byte[32768];
  
  public synchronized long getBytesCount()
  {
    return this.bytesCount;
  }
  
  public synchronized void setCompression(Compression paramCompression)
  {
    u.a(paramCompression);
    this.compression = paramCompression;
  }
  
  public synchronized void setCipher(Cipher paramCipher)
  {
    u.a(paramCipher);
    this.cipher = paramCipher;
  }
  
  public synchronized void setMac(Mac paramMac)
  {
    u.a(paramMac);
    this.mac = paramMac;
  }
  
  protected void resizeBuffer(int paramInt)
  {
    if (Message.c == 0) {
      if (paramInt < this.buffer.length) {
        return;
      }
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.buffer.length);
    this.buffer = arrayOfByte;
  }
  
  protected void updateMac(long paramLong)
  {
    this.mac.update((byte)(int)(paramLong >> 24 & 0xFF));
    this.mac.update((byte)(int)(paramLong >> 16 & 0xFF));
    this.mac.update((byte)(int)(paramLong >> 8 & 0xFF));
    this.mac.update((byte)(int)(paramLong & 0xFF));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.MessageStream
 * JD-Core Version:    0.7.0.1
 */