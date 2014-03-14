package com.jscape.inet.sftp;

import com.jscape.inet.file.JAcl.Mask;
import com.jscape.inet.file.JFile;
import com.jscape.inet.file.JFileInputStream;
import com.jscape.inet.file.JFileOpenFlags;
import com.jscape.inet.file.JFileOutputStream;
import com.jscape.inet.file.JRandomAccessFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class Sftp$BinaryMode
  extends Sftp.TransferMode
{
  private static final int b = 2;
  final Sftp c;
  
  public Sftp$BinaryMode(Sftp paramSftp)
  {
    super(paramSftp, 2);
  }
  
  protected void copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte, long paramLong)
    throws SftpException
  {
    boolean bool = SftpPacket.c;
    this.transferredBytes = paramLong;
    this.readBytes = 0L;
    this.startTime = System.currentTimeMillis();
    fireProgressEvent();
    try
    {
      int i = paramInputStream.read(paramArrayOfByte);
      do
      {
        if (i == -1) {
          break;
        }
        if ((bool) || (bool)) {
          break label108;
        }
        if (this.c.interrupted()) {
          break;
        }
        paramOutputStream.write(paramArrayOfByte, 0, i);
        this.transferredBytes += i;
        this.readBytes = i;
        fireProgressEvent();
        i = paramInputStream.read(paramArrayOfByte);
      } while (!bool);
      paramOutputStream.flush();
      label108:
      this.endTime = System.currentTimeMillis();
    }
    catch (Exception localException)
    {
      throw SftpException.wrap(localException);
    }
  }
  
  protected InputStream openIn(JFile paramJFile, long paramLong)
    throws IOException
  {
    JAcl.Mask localMask = new JAcl.Mask();
    localMask.setReadData(true);
    JFileOpenFlags localJFileOpenFlags = new JFileOpenFlags();
    localJFileOpenFlags.setOpenExisting(true);
    localJFileOpenFlags.setReadLock(true);
    JRandomAccessFile localJRandomAccessFile = paramJFile.getRandomAccessFile(localJFileOpenFlags, localMask);
    localJRandomAccessFile.setFilePointer(paramLong);
    return new JFileInputStream(localJRandomAccessFile);
  }
  
  protected OutputStream openOut(JFile paramJFile, long paramLong)
    throws IOException
  {
    JAcl.Mask localMask = new JAcl.Mask();
    localMask.setWriteData(true);
    JFileOpenFlags localJFileOpenFlags = new JFileOpenFlags();
    localJFileOpenFlags.setOpenOrCreate(true);
    if (!SftpPacket.c) {}
    localJFileOpenFlags.setCreateTruncate(paramLong == 0L);
    localJFileOpenFlags.setWriteLock(true);
    JRandomAccessFile localJRandomAccessFile = paramJFile.getRandomAccessFile(localJFileOpenFlags, localMask);
    localJRandomAccessFile.setFilePointer(paramLong);
    return new JFileOutputStream(localJRandomAccessFile);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.Sftp.BinaryMode
 * JD-Core Version:    0.7.0.1
 */