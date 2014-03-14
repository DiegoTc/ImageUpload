package com.jscape.inet.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public final class CRCComputer
{
  private static final int a = 4096;
  
  public long compute(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    boolean bool = FtpEvent.a;
    CheckedInputStream localCheckedInputStream = new CheckedInputStream(paramInputStream, new CRC32());
    byte[] arrayOfByte = new byte[4096];
    if (!bool) {}
    long l = arrayOfByte.length > paramLong ? paramLong : arrayOfByte.length;
    do
    {
      int i;
      if ((i = localCheckedInputStream.read(arrayOfByte, 0, (int)l)) == -1) {
        break;
      }
      if ((bool) || (bool)) {
        break label132;
      }
      if (paramLong <= 0L) {
        break;
      }
      paramLong -= i;
      if (!bool) {}
      l = arrayOfByte.length > paramLong ? paramLong : arrayOfByte.length;
    } while (!bool);
    label132:
    return localCheckedInputStream.getChecksum().getValue();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.CRCComputer
 * JD-Core Version:    0.7.0.1
 */