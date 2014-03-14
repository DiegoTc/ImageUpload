package com.jscape.inet.sftp;

import com.jscape.inet.sftp.packets.SshFxpInit;
import com.jscape.inet.sftp.packets.SshFxpVersion;
import com.jscape.inet.ssh.types.SshByte;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class PacketReader
{
  private final InputStream a;
  private final Map b = Collections.synchronizedMap(new HashMap());
  private volatile boolean c = false;
  private static final String z = -1;
  
  public PacketReader(InputStream paramInputStream)
  {
    u.a(paramInputStream);
    this.a = paramInputStream;
    registerPacket(1, SshFxpInit.class);
    registerPacket(2, SshFxpVersion.class);
  }
  
  public PacketReader(InputStream paramInputStream, Map paramMap)
  {
    this(paramInputStream);
    u.a(paramMap);
    this.b.putAll(paramMap);
  }
  
  public void registerPacket(int paramInt, Class paramClass)
  {
    u.a(paramClass);
    b();
    this.b.put(new SshByte(paramInt), paramClass);
  }
  
  public void unregisterPacket(int paramInt)
  {
    b();
    this.b.remove(new SshByte(paramInt));
  }
  
  public boolean knowsPacket(int paramInt)
  {
    b();
    return this.b.containsKey(new SshByte(paramInt));
  }
  
  public void close()
  {
    if (!SftpPacket.c)
    {
      if (isClosed()) {
        return;
      }
      this.c = true;
    }
    try
    {
      this.a.close();
    }
    catch (IOException localIOException) {}
  }
  
  public boolean isClosed()
  {
    return this.c;
  }
  
  public synchronized SftpPacket readPacket(String paramString)
    throws SftpException
  {
    b();
    try
    {
      byte[] arrayOfByte = SshString.readValue(this.a);
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
      SshByte localSshByte = SshByte.readFrom(localByteArrayInputStream);
      Class localClass = (Class)this.b.get(localSshByte);
      return SftpPacket.readFrom(localByteArrayInputStream, localClass, paramString);
    }
    catch (Throwable localThrowable)
    {
      throw SftpException.wrap(localThrowable);
    }
  }
  
  private void b()
  {
    if (isClosed()) {
      throw new IllegalStateException(z);
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.PacketReader
 * JD-Core Version:    0.7.0.1
 */