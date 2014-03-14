package com.jscape.inet.sftp;

import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.inet.ssh.util.Sequence;
import com.jscape.util.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class PacketWriter
{
  private final OutputStream a;
  private final ByteArrayOutputStream b = new ByteArrayOutputStream();
  private final Sequence c = new Sequence();
  private volatile boolean d = false;
  private static final String z = -1;
  
  public PacketWriter(OutputStream paramOutputStream)
  {
    u.a(paramOutputStream);
    this.a = paramOutputStream;
  }
  
  public synchronized void close()
  {
    if (!SftpPacket.c)
    {
      if (isClosed()) {
        return;
      }
      this.d = true;
    }
    try
    {
      this.a.close();
    }
    catch (IOException localIOException) {}
  }
  
  public synchronized boolean isClosed()
  {
    return this.d;
  }
  
  public synchronized void writePacket(SftpPacket paramSftpPacket, String paramString)
    throws SftpException
  {
    b();
    paramSftpPacket.setId(this.c.nextValue());
    try
    {
      SshUint32.writeIntTo(0, this.b);
      paramSftpPacket.writeTo(this.b, paramString);
      byte[] arrayOfByte = this.b.toByteArray();
      int i = arrayOfByte.length - 4;
      arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(i & 0xFF));
      this.a.write(arrayOfByte);
      this.a.flush();
    }
    catch (IOException localIOException)
    {
      throw new SftpException(localIOException.getMessage(), localIOException);
    }
    finally
    {
      this.b.reset();
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
 * Qualified Name:     com.jscape.inet.sftp.PacketWriter
 * JD-Core Version:    0.7.0.1
 */