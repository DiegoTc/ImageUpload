package com.jscape.inet.ssh;

import com.jscape.util.u;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

public class SshWriter
{
  private final OutputStream a;
  private final boolean b;
  public static boolean c;
  private static final String z = -1;
  
  public SshWriter(OutputStream paramOutputStream, boolean paramBoolean)
  {
    u.a(paramOutputStream);
    this.a = paramOutputStream;
    this.b = paramBoolean;
  }
  
  public void close()
  {
    if ((c) || (this.b)) {
      try
      {
        this.a.close();
      }
      catch (IOException localIOException) {}
    }
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    if (!c) {}
    writeByte(paramBoolean ? 1 : 0);
  }
  
  public void writeByte(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
  
  public void writeUint32(long paramLong)
    throws IOException
  {
    writeInt32((int)(paramLong & 0xFFFFFFFF));
  }
  
  public void writeInt32(int paramInt)
    throws IOException
  {
    writeByte(paramInt >> 24 & 0xFF);
    writeByte(paramInt >> 16 & 0xFF);
    writeByte(paramInt >> 8 & 0xFF);
    writeByte(paramInt >> 0 & 0xFF);
  }
  
  public void writeUint64(BigInteger paramBigInteger)
    throws IOException
  {
    writeInt64(paramBigInteger.longValue());
  }
  
  public void writeInt64(long paramLong)
    throws IOException
  {
    boolean bool = c;
    writeByte((int)(paramLong >> 56 & 0xFF));
    writeByte((int)(paramLong >> 48 & 0xFF));
    writeByte((int)(paramLong >> 40 & 0xFF));
    writeByte((int)(paramLong >> 32 & 0xFF));
    writeByte((int)(paramLong >> 24 & 0xFF));
    writeByte((int)(paramLong >> 16 & 0xFF));
    writeByte((int)(paramLong >> 8 & 0xFF));
    writeByte((int)(paramLong >> 0 & 0xFF));
    if (u.a) {
      c = !bool;
    }
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    writeString(paramString.getBytes());
  }
  
  public void writeString(byte[] paramArrayOfByte)
    throws IOException
  {
    writeString(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void writeString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    writeUint32(paramInt2);
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeMpint(BigInteger paramBigInteger)
    throws IOException
  {
    writeString(paramBigInteger.toByteArray());
  }
  
  public void writeNameList(String[] paramArrayOfString)
    throws IOException
  {
    boolean bool = c;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    do
    {
      if (i >= paramArrayOfString.length) {
        break;
      }
      localStringBuffer.append(paramArrayOfString[i]);
      if (bool) {
        return;
      }
      if (!bool)
      {
        if (i < paramArrayOfString.length - 1) {
          localStringBuffer.append(',');
        }
        i++;
      }
    } while (!bool);
    writeString(localStringBuffer.toString());
  }
  
  public void writeLine(String paramString)
    throws IOException
  {
    String str = z;
    write(paramString.getBytes());
    write(str.getBytes());
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.SshWriter
 * JD-Core Version:    0.7.0.1
 */