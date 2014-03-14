package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.transport.compression.Compression;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.inet.ssh.util.Sequence;
import com.jscape.util.u;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.ShortBufferException;

public final class MessageWriter
  extends MessageStream
{
  private static final int b = 8;
  private static final int c = 4;
  private final DataOutputStream d;
  private final SecureRandom e = new SecureRandom();
  
  public MessageWriter(OutputStream paramOutputStream, Compression paramCompression, Cipher paramCipher, Mac paramMac)
  {
    this.d = new DataOutputStream(paramOutputStream);
    setCompression(paramCompression);
    setCipher(paramCipher);
    setMac(paramMac);
  }
  
  public void close()
  {
    try
    {
      this.d.close();
    }
    catch (Exception localException) {}
  }
  
  public synchronized void writeLine(String paramString)
    throws IOException
  {
    this.d.writeUTF(paramString);
  }
  
  public synchronized void writeMessage(Message paramMessage)
    throws IOException
  {
    int m = Message.c;
    u.a(paramMessage);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramMessage.writeTo(localByteArrayOutputStream);
      byte[] arrayOfByte1 = localByteArrayOutputStream.toByteArray();
      byte[] arrayOfByte2 = this.compression.update(arrayOfByte1);
      byte[] arrayOfByte3 = b(arrayOfByte2.length);
      int i = arrayOfByte2.length + arrayOfByte3.length + 1;
      int j = 4 + i;
      int k = j + this.mac.getMacLength();
      resizeBuffer(k);
      SshUint32.store(i, this.buffer, 0);
      this.buffer[4] = ((byte)arrayOfByte3.length);
      System.arraycopy(arrayOfByte2, 0, this.buffer, 5, arrayOfByte2.length);
      System.arraycopy(arrayOfByte3, 0, this.buffer, 5 + arrayOfByte2.length, arrayOfByte3.length);
      a(j);
      this.cipher.update(this.buffer, 0, j, this.buffer, 0);
      this.d.write(this.buffer, 0, k);
      this.d.flush();
      Arrays.fill(this.buffer, (byte)0);
      this.bytesCount += k;
    }
    catch (ShortBufferException localShortBufferException)
    {
      throw new TransportException(localShortBufferException.getMessage());
    }
    if (m != 0) {
      u.a = !u.a;
    }
  }
  
  private void a(int paramInt)
    throws TransportException
  {
    long l = this.sequence.nextValue();
    try
    {
      updateMac(l);
      this.mac.update(this.buffer, 0, paramInt);
      this.mac.doFinal(this.buffer, paramInt);
    }
    catch (ShortBufferException localShortBufferException)
    {
      throw new TransportException(localShortBufferException.getMessage());
    }
  }
  
  private byte[] b(int paramInt)
  {
    int i = 5 + paramInt;
    int j = this.cipher.getBlockSize();
    int k = Math.max(j, 8);
    int m = k - i % k;
    if (Message.c == 0) {
      if (m < 4) {
        m += k;
      }
    }
    byte[] arrayOfByte = new byte[m];
    this.e.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.MessageWriter
 * JD-Core Version:    0.7.0.1
 */