package com.jscape.filetransfer;

import com.jscape.inet.file.JFilePermissions;
import com.jscape.inet.file.JFilePermissions.Permission;
import com.jscape.inet.sftp.Sftp;
import com.jscape.inet.sftp.SftpAuthenticationException;
import com.jscape.inet.sftp.SftpConfiguration;
import com.jscape.inet.sftp.SftpFile;
import com.jscape.inet.ssh.util.SshParameters;
import com.jscape.util.bc;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class SftpTransfer
  implements FileTransfer
{
  private final SshParameters a;
  private final Sftp b;
  private final Set<FileTransferListener> c;
  private static final String z = -1;
  
  public SftpTransfer(SshParameters paramSshParameters, SftpConfiguration paramSftpConfiguration, Set<FileTransferListener> paramSet)
  {
    bc.a(paramSshParameters);
    this.a = paramSshParameters;
    this.b = new Sftp(this.a, paramSftpConfiguration);
    this.c = new CopyOnWriteArraySet(paramSet);
    this.b.addSftpListener(new SftpTransfer.SftpEventConverter(this));
  }
  
  public SftpTransfer(SshParameters paramSshParameters, SftpConfiguration paramSftpConfiguration)
  {
    this(paramSshParameters, paramSftpConfiguration, Collections.emptySet());
  }
  
  public SftpTransfer(SshParameters paramSshParameters)
  {
    this(paramSshParameters, new SftpConfiguration());
  }
  
  public SftpTransfer(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(new SshParameters(paramString1, paramInt, paramString2, paramString3));
  }
  
  public SftpTransfer(String paramString1, String paramString2, String paramString3)
  {
    this(new SshParameters(paramString1, paramString2, paramString3));
  }
  
  public SftpTransfer(String paramString1, String paramString2, String paramString3, Integer paramInteger)
  {
    this(paramString1, paramString2, paramString3, paramInteger.intValue());
  }
  
  public SftpTransfer(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    this(new SshParameters(paramString1, paramString2, paramString3, paramFile));
  }
  
  public SftpTransfer(String paramString1, String paramString2, String paramString3, int paramInt, SftpConfiguration paramSftpConfiguration)
  {
    this(new SshParameters(paramString1, paramInt, paramString2, paramString3), paramSftpConfiguration);
  }
  
  public void setAscii()
    throws FileTransferException
  {
    this.b.setAscii();
  }
  
  public void setAuto(boolean paramBoolean)
  {
    this.b.setAuto(paramBoolean);
  }
  
  public void setBinary()
    throws FileTransferException
  {
    this.b.setBinary();
  }
  
  /**
   * @deprecated
   */
  public void setBlockTransferSize(int paramInt)
  {
    setUploadBlockSize(paramInt);
  }
  
  /**
   * @deprecated
   */
  public int getBlockTransferSize()
  {
    return getUploadBlockSize();
  }
  
  public boolean isConnected()
  {
    return this.b.isConnected();
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.b.setDebug(paramBoolean);
  }
  
  public boolean getDebug()
  {
    return this.b.getDebug();
  }
  
  public void setDebugStream(PrintStream paramPrintStream)
  {
    this.b.setDebugStream(paramPrintStream);
  }
  
  public PrintStream getDebugStream()
  {
    return this.b.getDebugStream();
  }
  
  public void setDir(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.setDir(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public String getDir()
    throws FileTransferException
  {
    return this.b.getDir();
  }
  
  public Enumeration getDirListing()
    throws FileTransferException
  {
    int i = FileTransferEvent.a;
    try
    {
      Enumeration localEnumeration = this.b.getDirListing();
      Vector localVector = new Vector();
      do
      {
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        SftpFile localSftpFile = (SftpFile)localEnumeration.nextElement();
        FileTransferRemoteFile localFileTransferRemoteFile = a(localSftpFile);
        if (i != 0) {
          break label64;
        }
        localVector.addElement(localFileTransferRemoteFile);
      } while (i == 0);
      label64:
      return localVector.elements();
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public Enumeration getDirListing(String paramString)
    throws FileTransferException
  {
    int i = FileTransferEvent.a;
    try
    {
      Enumeration localEnumeration = this.b.getDirListing(paramString);
      Vector localVector = new Vector();
      do
      {
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        SftpFile localSftpFile = (SftpFile)localEnumeration.nextElement();
        FileTransferRemoteFile localFileTransferRemoteFile = a(localSftpFile);
        if (i != 0) {
          break label67;
        }
        localVector.addElement(localFileTransferRemoteFile);
      } while (i == 0);
      label67:
      return localVector.elements();
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  private FileTransferRemoteFile a(SftpFile paramSftpFile)
    throws Exception
  {
    FileTransferRemoteFile localFileTransferRemoteFile = new FileTransferRemoteFile();
    localFileTransferRemoteFile.setFilename(paramSftpFile.getFilename());
    localFileTransferRemoteFile.setDirectory(paramSftpFile.isDirectory());
    localFileTransferRemoteFile.setFilesize(paramSftpFile.getFilesize());
    localFileTransferRemoteFile.setFileDate(paramSftpFile.getDate());
    JFilePermissions localJFilePermissions = paramSftpFile.getPermissions();
    if (FileTransferEvent.a == 0)
    {
      if (localJFilePermissions != null) {
        localFileTransferRemoteFile.setReadable(localJFilePermissions.getOwnerPermission().readAllowed());
      }
    }
    else {
      localFileTransferRemoteFile.setWritable(localJFilePermissions.getOwnerPermission().writeAllowed());
    }
    return localFileTransferRemoteFile;
  }
  
  public String getDirListingAsString()
    throws FileTransferException
  {
    try
    {
      return this.b.getDirListingAsString();
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public String getDirListingAsString(String paramString)
    throws FileTransferException
  {
    try
    {
      return this.b.getDirListingAsString(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void setDirUp()
    throws FileTransferException
  {
    try
    {
      this.b.setDirUp();
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void setDownloadBlockSize(int paramInt)
  {
    this.b.setDownloadBlockSize(paramInt);
  }
  
  public int getDownloadBlockSize()
  {
    return this.b.getDownloadBlockSize();
  }
  
  public void setFileTimestamp(String paramString, Date paramDate)
    throws FileTransferException
  {
    try
    {
      this.b.setFileTimestamp(paramString, paramDate);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void setFileModificationTime(String paramString, Date paramDate)
    throws FileTransferException
  {
    setFileTimestamp(paramString, paramDate);
  }
  
  public boolean sameChecksum(File paramFile, String paramString)
    throws FileTransferException
  {
    throw new FileTransferException(z);
  }
  
  public Date getFileTimestamp(String paramString)
    throws FileTransferException
  {
    try
    {
      return this.b.getFileTimestamp(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public long getFilesize(String paramString)
    throws FileTransferException
  {
    try
    {
      return this.b.getFilesize(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void setHostname(String paramString)
  {
    this.b.getSshParameters().setSshHostname(paramString);
  }
  
  public String getHostname()
  {
    return this.b.getSshParameters().getSshHostname();
  }
  
  public InputStream getInputStream(String paramString, long paramLong)
    throws FileTransferException
  {
    try
    {
      return this.b.getInputStream(paramString, paramLong);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public Object getImplementation()
  {
    return this.b;
  }
  
  public void setLineTerminator(String paramString)
  {
    this.b.setLineTerminator(paramString);
  }
  
  public void setLocalDir(File paramFile)
  {
    this.b.setLocalDir(paramFile);
  }
  
  public File getLocalDir()
  {
    return this.b.getLocalDir();
  }
  
  public void abortDownloadThread(String paramString)
  {
    this.b.abortDownloadThread(paramString);
  }
  
  public void abortUploadThread(String paramString)
  {
    this.b.abortUploadThread(paramString);
  }
  
  public void abortUploadThreads()
  {
    this.b.abortUploadThreads();
  }
  
  public void abortDownloadThreads()
  {
    this.b.abortDownloadThreads();
  }
  
  public Vector getRemoteFileList(String paramString)
    throws FileTransferException
  {
    try
    {
      return this.b.getRemoteFileList(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public long getRecursiveDirectorySize(String paramString)
  {
    return this.b.getRecursiveDirectorySize(paramString);
  }
  
  public int getRecursiveDirectoryFileCount(String paramString)
  {
    return this.b.getRecursiveDirectoryFileCount(paramString);
  }
  
  public Enumeration getLocalDirListing()
  {
    return this.b.getLocalDirListing();
  }
  
  public int getMode()
  {
    return this.b.getMode();
  }
  
  public Enumeration getNameListing()
    throws FileTransferException
  {
    try
    {
      return this.b.getNameListing();
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public Enumeration getNameListing(String paramString)
    throws FileTransferException
  {
    try
    {
      return this.b.getNameListing(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public OutputStream getOutputStream(String paramString, long paramLong, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      return this.b.getOutputStream(paramString, paramLong, paramBoolean);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public FileTransfer copy()
  {
    SftpTransfer localSftpTransfer = new SftpTransfer(this.a, this.b.getConfiguration(), this.c);
    localSftpTransfer.setDebugStream(getDebugStream());
    localSftpTransfer.setDebug(getDebug());
    return localSftpTransfer;
  }
  
  public void setPassive(boolean paramBoolean) {}
  
  public boolean getPassive()
  {
    return false;
  }
  
  public void setPassword(String paramString)
  {
    this.b.getSshParameters().setSshPassword(paramString);
  }
  
  public String getPassword()
  {
    return this.b.getSshParameters().getSshPassword();
  }
  
  public void setPort(int paramInt)
  {
    this.b.getSshParameters().setSshPort(paramInt);
  }
  
  public int getPort()
  {
    return this.b.getSshParameters().getSshPort();
  }
  
  public File getPrivateKey()
  {
    return this.b.getSshParameters().getPrivateKey();
  }
  
  public void setProxyAuthentication(String paramString1, String paramString2)
  {
    this.b.setProxyAuthentication(paramString1, paramString2);
  }
  
  public void setProxyHost(String paramString, int paramInt)
  {
    this.b.setProxyHost(paramString, paramInt);
  }
  
  public void setProxyType(String paramString)
  {
    this.b.setProxyType(paramString);
  }
  
  public void clearProxySettings() {}
  
  public void setTimeout(long paramLong)
  {
    this.b.setTimeout(paramLong);
  }
  
  public long getTimeout()
  {
    return this.b.getTimeout();
  }
  
  public void setUploadBlockSize(int paramInt)
  {
    this.b.setUploadBlockSize(paramInt);
  }
  
  public int getUploadBlockSize()
  {
    return this.b.getUploadBlockSize();
  }
  
  public void setUsername(String paramString)
  {
    this.b.getSshParameters().setSshUsername(paramString);
  }
  
  public String getUsername()
  {
    return this.b.getSshParameters().getSshUsername();
  }
  
  public boolean isValidPath(String paramString)
    throws FileTransferException
  {
    try
    {
      return this.b.isValidPath(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void setWireEncoding(String paramString) {}
  
  public String getWireEncoding()
  {
    return "";
  }
  
  public void addFileTransferListener(FileTransferListener paramFileTransferListener)
  {
    bc.a(paramFileTransferListener);
    this.c.add(paramFileTransferListener);
  }
  
  public void connect()
    throws FileTransferException
  {
    try
    {
      this.b.connect();
    }
    catch (SftpAuthenticationException localSftpAuthenticationException)
    {
      throw new FileTransferAuthenticationException(localSftpAuthenticationException);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void setPreserveFileUploadTimestamp(boolean paramBoolean) {}
  
  public void setPreserveFileDownloadTimestamp(boolean paramBoolean) {}
  
  public void setTimeZone(TimeZone paramTimeZone) {}
  
  public void deleteDir(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.deleteDir(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void deleteDir(String paramString, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      this.b.deleteDir(paramString, paramBoolean);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public boolean exists(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.getFileTimestamp(paramString);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void deleteFile(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.deleteFile(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void disconnect()
    throws FileTransferException
  {
    this.b.disconnect();
  }
  
  public void download(OutputStream paramOutputStream, String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.download(paramOutputStream, paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public File download(String paramString)
    throws FileTransferException
  {
    try
    {
      return this.b.download(paramString);
    }
    catch (Exception localException)
    {
      raiseErrorEvent(new FileTransferErrorEvent(this, paramString, this.b.getDir(), this.b.getLocalDir() + File.separator + paramString, 1));
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public File download(String paramString1, String paramString2)
    throws FileTransferException
  {
    try
    {
      return this.b.download(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void downloadDir(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.downloadDir(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void downloadDir(String paramString, int paramInt, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      this.b.downloadDir(paramString, paramInt);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void downloadDir(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
    throws FileTransferException
  {
    try
    {
      this.b.downloadDir(paramString, paramInt1, 0, paramInt2);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void interrupt()
  {
    this.b.interrupt();
  }
  
  public boolean interrupted()
  {
    return this.b.interrupted();
  }
  
  public void makeDir(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.makeDir(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void makeDirRecursive(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.makeDirRecursive(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public File makeLocalDir(String paramString)
  {
    return this.b.makeLocalDir(paramString);
  }
  
  public void mdelete(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.mdelete(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void mdownload(Enumeration paramEnumeration)
    throws FileTransferException
  {
    try
    {
      this.b.mdownload(paramEnumeration);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void mdownload(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.mdownload(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void mupload(Enumeration paramEnumeration)
    throws FileTransferException
  {
    try
    {
      this.b.mupload(paramEnumeration);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void mupload(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.mupload(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void removeFileTransferListener(FileTransferListener paramFileTransferListener)
  {
    this.c.remove(paramFileTransferListener);
  }
  
  public void renameFile(String paramString1, String paramString2)
    throws FileTransferException
  {
    try
    {
      this.b.renameFile(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void reset()
  {
    this.b.reset();
  }
  
  public void resumeDownload(String paramString, long paramLong)
    throws FileTransferException
  {
    try
    {
      this.b.resumeDownload(paramString, paramLong);
    }
    catch (Exception localException)
    {
      raiseErrorEvent(new FileTransferErrorEvent(this, paramString, this.b.getDir(), this.b.getLocalDir() + File.separator + paramString, 1));
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void resumeDownload(String paramString1, String paramString2, long paramLong)
    throws FileTransferException
  {
    try
    {
      this.b.resumeDownload(paramString1, paramString2, paramLong);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void resumeUpload(File paramFile, long paramLong)
    throws FileTransferException
  {
    try
    {
      this.b.resumeUpload(paramFile, paramLong);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void resumeUpload(String paramString, long paramLong)
    throws FileTransferException
  {
    try
    {
      this.b.resumeUpload(paramString, paramLong);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(byte[] paramArrayOfByte, String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramArrayOfByte, paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramArrayOfByte, paramString, paramBoolean);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(File paramFile)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramFile);
    }
    catch (Exception localException1)
    {
      try
      {
        raiseErrorEvent(new FileTransferErrorEvent(this, paramFile.getName(), this.b.getDir(), paramFile.getPath(), 0));
      }
      catch (Exception localException2) {}
      throw new FileTransferException(localException1.getMessage(), localException1);
    }
  }
  
  public void upload(File paramFile, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramFile, paramBoolean);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(String paramString, File paramFile)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramString, paramFile);
    }
    catch (Exception localException1)
    {
      try
      {
        raiseErrorEvent(new FileTransferErrorEvent(this, paramFile.getName(), this.b.getDir(), paramFile.getPath(), 0));
      }
      catch (Exception localException2) {}
      throw new FileTransferException(localException1.getMessage(), localException1);
    }
  }
  
  public void upload(File paramFile, String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramFile, paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(File paramFile, String paramString, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramFile, paramString, paramBoolean);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(String paramString, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramString, paramBoolean);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(String paramString1, String paramString2)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void upload(String paramString1, String paramString2, boolean paramBoolean)
    throws FileTransferException
  {
    try
    {
      this.b.upload(paramString1, paramString2, paramBoolean);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void uploadDir(File paramFile)
    throws FileTransferException
  {
    try
    {
      this.b.uploadDir(paramFile);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void uploadDir(File paramFile, String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.uploadDir(paramFile, paramFile.getName(), paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void uploadDir(File paramFile, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
    throws FileTransferException
  {
    try
    {
      this.b.uploadDir(paramFile, paramInt1, paramString, paramInt2);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public void uploadDir(File paramFile, int paramInt, boolean paramBoolean, String paramString)
    throws FileTransferException
  {
    try
    {
      this.b.uploadDir(paramFile, paramInt, paramString);
    }
    catch (Exception localException)
    {
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  public String uploadUnique(String paramString)
    throws FileTransferException
  {
    return "";
  }
  
  public String uploadUnique(File paramFile)
    throws FileTransferException
  {
    return "";
  }
  
  public String uploadUnique(InputStream paramInputStream, String paramString)
    throws FileTransferException
  {
    return "";
  }
  
  public void resumeUpload(File paramFile, String paramString, long paramLong)
    throws FileTransferException
  {
    try
    {
      this.b.resumeUpload(paramFile, paramString, paramLong);
    }
    catch (Exception localException)
    {
      raiseErrorEvent(new FileTransferErrorEvent(this, paramFile.getName(), this.b.getDir(), paramFile.getPath(), 0));
      throw new FileTransferException(localException.getMessage(), localException);
    }
  }
  
  protected void raiseEvent(FileTransferEvent paramFileTransferEvent)
  {
    int i = FileTransferEvent.a;
    Iterator localIterator = this.c.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      FileTransferListener localFileTransferListener = (FileTransferListener)localIterator.next();
      paramFileTransferEvent.accept(localFileTransferListener);
    } while (i == 0);
  }
  
  protected void raiseErrorEvent(FileTransferErrorEvent paramFileTransferErrorEvent)
  {
    int i = FileTransferEvent.a;
    Iterator localIterator = this.c.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      FileTransferListener localFileTransferListener = (FileTransferListener)localIterator.next();
      if ((i != 0) || ((localFileTransferListener instanceof FileTransferErrorListener))) {
        ((FileTransferErrorListener)localFileTransferListener).error(paramFileTransferErrorEvent);
      }
    } while (i == 0);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.SftpTransfer
 * JD-Core Version:    0.7.0.1
 */