package com.jscape.inet.sftp;

import com.jscape.inet.file.JFile;
import com.jscape.inet.file.JFileInputStream;
import com.jscape.inet.file.JFileOutputStream;
import com.jscape.inet.sftp.events.SftpDownloadEvent;
import com.jscape.inet.sftp.events.SftpProgressEvent;
import com.jscape.inet.sftp.events.SftpUploadEvent;
import com.jscape.util.qb;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class Sftp$TransferMode
{
  protected final int code;
  protected String fileName = null;
  protected int eventMode = 0;
  protected long endTime = 0L;
  protected long startTime = 0L;
  protected long totalBytes = 0L;
  protected long transferredBytes = 0L;
  protected long readBytes = 0L;
  final Sftp a;
  
  protected Sftp$TransferMode(Sftp paramSftp, int paramInt)
  {
    this.code = paramInt;
  }
  
  public final int getCode()
  {
    return this.code;
  }
  
  public synchronized void download(JFile paramJFile1, JFile paramJFile2, long paramLong)
    throws SftpException
  {
    InputStream localInputStream = null;
    OutputStream localOutputStream = null;
    try
    {
      localInputStream = openIn(paramJFile1, paramLong);
      localOutputStream = openOut(paramJFile2, paramLong);
      a(localInputStream, localOutputStream, paramJFile1.getFilename(), paramJFile1.getFilesize() - paramLong, paramLong);
    }
    catch (RequestException localRequestException)
    {
      throw SftpExceptionFactory.getException(localRequestException, paramJFile1.getFilename());
    }
    catch (IOException localIOException)
    {
      throw new SftpException(localIOException.getMessage(), localIOException);
    }
    finally
    {
      qb.a(localInputStream);
      qb.a(localOutputStream);
    }
  }
  
  public synchronized void download(JFile paramJFile, OutputStream paramOutputStream, long paramLong)
    throws SftpException
  {
    JFileInputStream localJFileInputStream = null;
    try
    {
      long l = paramJFile.getFilesize();
      localJFileInputStream = new JFileInputStream(paramJFile, paramLong);
      a(localJFileInputStream, paramOutputStream, paramJFile.getFilename(), l - paramLong, paramLong);
    }
    catch (RequestException localRequestException)
    {
      throw SftpExceptionFactory.getException(localRequestException, paramJFile.getFilename());
    }
    catch (IOException localIOException)
    {
      throw new SftpException(localIOException.getMessage(), localIOException);
    }
    finally
    {
      qb.a(localJFileInputStream);
    }
  }
  
  public synchronized void upload(JFile paramJFile1, JFile paramJFile2, long paramLong)
    throws SftpException
  {
    InputStream localInputStream = null;
    OutputStream localOutputStream = null;
    try
    {
      localInputStream = openIn(paramJFile1, paramLong);
      localOutputStream = openOut(paramJFile2, paramLong);
      b(localInputStream, localOutputStream, paramJFile1.getFilename(), paramJFile1.getFilesize() - paramLong, paramLong);
    }
    catch (RequestException localRequestException)
    {
      throw SftpExceptionFactory.getException(localRequestException, paramJFile2.getFilename());
    }
    catch (IOException localIOException)
    {
      throw new SftpException(localIOException.getMessage(), localIOException);
    }
    finally
    {
      qb.a(localInputStream);
      qb.a(localOutputStream);
    }
  }
  
  public synchronized void upload(InputStream paramInputStream, JFile paramJFile, long paramLong)
    throws SftpException
  {
    OutputStream localOutputStream = null;
    try
    {
      localOutputStream = openOut(paramJFile, paramLong);
      b(paramInputStream, localOutputStream, paramJFile.getFilename(), paramInputStream.available(), paramLong);
    }
    catch (RequestException localRequestException)
    {
      throw SftpExceptionFactory.getException(localRequestException, paramJFile.getFilename());
    }
    catch (IOException localIOException)
    {
      throw new SftpException(localIOException.getMessage(), localIOException);
    }
    finally
    {
      qb.a(localOutputStream);
    }
  }
  
  protected void copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte, long paramLong)
    throws SftpException
  {}
  
  protected void fireProgressEvent()
  {
    String str = "";
    if (!SftpPacket.c) {
      if (Sftp.h(this.a) != null) {
        str = Sftp.h(this.a).getAbsolutePath();
      }
    }
    Sftp.a(this.a, new SftpProgressEvent(this.a, this.fileName, Sftp.i(this.a).getPath(), str, this.eventMode, this.transferredBytes, this.readBytes, Sftp.j(this.a)));
  }
  
  protected InputStream openIn(JFile paramJFile, long paramLong)
    throws IOException
  {
    return new JFileInputStream(paramJFile, paramLong);
  }
  
  protected OutputStream openOut(JFile paramJFile, long paramLong)
    throws IOException
  {
    return new JFileOutputStream(paramJFile, paramLong);
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream, String paramString, long paramLong1, long paramLong2)
    throws SftpException
  {
    this.fileName = paramString;
    this.totalBytes = paramLong1;
    this.eventMode = 1;
    copy(paramInputStream, paramOutputStream, Sftp.k(this.a), paramLong2);
    b();
  }
  
  private void b()
  {
    String str = "";
    if (!SftpPacket.c) {
      if (Sftp.h(this.a) != null) {
        str = Sftp.h(this.a).getAbsolutePath();
      }
    }
    Sftp.a(this.a, new SftpDownloadEvent(this.a, this.fileName, Sftp.i(this.a).getPath(), str, this.transferredBytes, this.endTime - this.startTime));
  }
  
  private void c()
  {
    String str = "";
    if (!SftpPacket.c) {
      if (Sftp.h(this.a) != null) {
        str = Sftp.h(this.a).getAbsolutePath();
      }
    }
    Sftp.a(this.a, new SftpUploadEvent(this.a, this.fileName, Sftp.i(this.a).getPath(), str, this.transferredBytes, this.endTime - this.startTime));
  }
  
  private void b(InputStream paramInputStream, OutputStream paramOutputStream, String paramString, long paramLong1, long paramLong2)
    throws SftpException
  {
    this.fileName = paramString;
    this.totalBytes = paramLong1;
    this.eventMode = 0;
    copy(paramInputStream, paramOutputStream, Sftp.l(this.a), paramLong2);
    c();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.Sftp.TransferMode
 * JD-Core Version:    0.7.0.1
 */