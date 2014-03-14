package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.transport.compression.Compression;
import com.jscape.inet.ssh.transport.messages.SshMsgUnknown;
import com.jscape.inet.ssh.types.SshByte;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.inet.ssh.util.Sequence;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class MessageReader
  extends MessageStream
{
  private final DataInputStream b;
  private boolean c = true;
  private int d = 0;
  private final Map e = Collections.synchronizedMap(new HashMap());
  private long f = 0L;
  private static final String z = -1;
  
  public MessageReader(InputStream paramInputStream, Compression paramCompression, Cipher paramCipher, Mac paramMac)
  {
    this.b = new DataInputStream(paramInputStream);
    setCompression(paramCompression);
    setCipher(paramCipher);
    setMac(paramMac);
  }
  
  public synchronized void setCipher(Cipher paramCipher)
  {
    int j = Message.c;
    super.setCipher(paramCipher);
    if (j == 0) {}
    int i = this.cipher.getBlockSize() > 0 ? this.cipher.getBlockSize() : 4;
    if (j == 0) {}
    this.d = (4 <= i ? i : i * (4 / i + 1));
  }
  
  public synchronized boolean isMacCheckAllowed()
  {
    return this.c;
  }
  
  public synchronized void setMacCheckAllowed(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void registerMessage(int paramInt, Class paramClass)
  {
    u.a(paramClass);
    this.e.put(new SshByte(paramInt), paramClass);
  }
  
  public void unregisterMessage(int paramInt)
  {
    this.e.remove(new SshByte(paramInt));
  }
  
  public boolean knowsMessage(int paramInt)
  {
    return this.e.containsKey(new SshByte(paramInt));
  }
  
  public void close()
  {
    try
    {
      this.b.close();
    }
    catch (Exception localException) {}
  }
  
  public synchronized String readLine()
    throws IOException
  {
    return this.b.readUTF();
  }
  
  public synchronized Message readMessage()
    throws IOException
  {
    int n = Message.c;
    try
    {
      this.b.readFully(this.buffer, 0, this.d);
      this.cipher.update(this.buffer, 0, this.d, this.buffer, 0);
      int i = SshUint32.restore(this.buffer, 0);
      int j = 4 + i;
      int k = j + this.mac.getMacLength();
      resizeBuffer(k);
      this.b.readFully(this.buffer, this.d, k - this.d);
      this.bytesCount += k;
      this.cipher.update(this.buffer, this.d, j - this.d, this.buffer, this.d);
      a(j);
      int m = i - SshByte.restore(this.buffer, 4) - 1;
      byte[] arrayOfByte = this.compression.update(this.buffer, 5, m);
      Arrays.fill(this.buffer, (byte)0);
      if (u.a) {
        Message.c = ++n;
      }
      return a(arrayOfByte);
    }
    catch (Throwable localThrowable)
    {
      throw new TransportException(localThrowable.getMessage());
    }
  }
  
  private void a(int paramInt)
    throws TransportException
  {
    int k = Message.c;
    this.f = this.sequence.nextValue();
    if (k == 0)
    {
      if (!this.c) {
        return;
      }
      updateMac(this.f);
      this.mac.update(this.buffer, 0, paramInt);
    }
    byte[] arrayOfByte = this.mac.doFinal();
    int i = 0;
    int j = paramInt;
    do
    {
      if (i >= arrayOfByte.length) {
        break;
      }
      if (this.buffer[j] != arrayOfByte[i]) {
        throw new TransportException(z);
      }
      i++;
      j++;
    } while (k == 0);
  }
  
  private Message a(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    SshByte localSshByte = SshByte.readFrom(localByteArrayInputStream);
    if (Message.c == 0) {
      if (!knowsMessage(localSshByte.intValue()))
      {
        localObject = new byte[localByteArrayInputStream.available()];
        localByteArrayInputStream.read((byte[])localObject);
        return new SshMsgUnknown(localSshByte.intValue(), (byte[])localObject);
      }
    }
    Object localObject = (Class)this.e.get(localSshByte);
    Message localMessage = Message.readFrom(localByteArrayInputStream, (Class)localObject);
    localMessage.setId(this.f);
    return localMessage;
  }
  
  static
  {
    break label13;
    break label114;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.MessageReader
 * JD-Core Version:    0.7.0.1
 */