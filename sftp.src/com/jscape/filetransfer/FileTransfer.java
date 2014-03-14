package com.jscape.filetransfer;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.TimeZone;
import java.util.Vector;

public abstract interface FileTransfer
{
  public static final int AUTO = 0;
  public static final int ASCII = 1;
  public static final int BINARY = 2;
  public static final String CURRENT_DIR = ".";
  public static final String UP_DIR = -1;
  
  public abstract String getHostname();
  
  public abstract void setHostname(String paramString);
  
  public abstract int getPort();
  
  public abstract void setPort(int paramInt);
  
  public abstract long getTimeout();
  
  public abstract void setTimeout(long paramLong);
  
  public abstract String getUsername();
  
  public abstract void setUsername(String paramString);
  
  public abstract String getPassword();
  
  public abstract void setPassword(String paramString);
  
  public abstract int getBlockTransferSize();
  
  public abstract void setBlockTransferSize(int paramInt);
  
  public abstract boolean getPassive();
  
  public abstract void setPassive(boolean paramBoolean);
  
  public abstract String getWireEncoding();
  
  public abstract void setWireEncoding(String paramString);
  
  public abstract void setPreserveFileUploadTimestamp(boolean paramBoolean);
  
  public abstract void setPreserveFileDownloadTimestamp(boolean paramBoolean);
  
  public abstract void setTimeZone(TimeZone paramTimeZone);
  
  public abstract void setProxyHost(String paramString, int paramInt);
  
  public abstract void setProxyAuthentication(String paramString1, String paramString2);
  
  public abstract void setProxyType(String paramString);
  
  public abstract void clearProxySettings();
  
  public abstract boolean getDebug();
  
  public abstract void setDebug(boolean paramBoolean);
  
  public abstract PrintStream getDebugStream();
  
  public abstract void setDebugStream(PrintStream paramPrintStream);
  
  public abstract void addFileTransferListener(FileTransferListener paramFileTransferListener);
  
  public abstract void removeFileTransferListener(FileTransferListener paramFileTransferListener);
  
  public abstract File getLocalDir();
  
  public abstract void setLocalDir(File paramFile);
  
  public abstract Enumeration getLocalDirListing();
  
  public abstract File makeLocalDir(String paramString);
  
  public abstract Object getImplementation();
  
  public abstract FileTransfer copy();
  
  public abstract void connect()
    throws FileTransferException;
  
  public abstract void disconnect()
    throws FileTransferException;
  
  public abstract boolean isConnected();
  
  public abstract int getMode();
  
  public abstract void setAscii()
    throws FileTransferException;
  
  public abstract void setAuto(boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void setBinary()
    throws FileTransferException;
  
  public abstract String getDir()
    throws FileTransferException;
  
  public abstract void setDir(String paramString)
    throws FileTransferException;
  
  public abstract void setDirUp()
    throws FileTransferException;
  
  public abstract Enumeration getDirListing()
    throws FileTransferException;
  
  public abstract Enumeration getDirListing(String paramString)
    throws FileTransferException;
  
  public abstract String getDirListingAsString()
    throws FileTransferException;
  
  public abstract String getDirListingAsString(String paramString)
    throws FileTransferException;
  
  public abstract Enumeration getNameListing()
    throws FileTransferException;
  
  public abstract Enumeration getNameListing(String paramString)
    throws FileTransferException;
  
  public abstract long getRecursiveDirectorySize(String paramString)
    throws FileTransferException;
  
  public abstract int getRecursiveDirectoryFileCount(String paramString)
    throws FileTransferException;
  
  public abstract Vector getRemoteFileList(String paramString)
    throws FileTransferException;
  
  public abstract void makeDir(String paramString)
    throws FileTransferException;
  
  public abstract void makeDirRecursive(String paramString)
    throws FileTransferException;
  
  public abstract void deleteDir(String paramString)
    throws FileTransferException;
  
  public abstract void deleteDir(String paramString, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract boolean exists(String paramString)
    throws FileTransferException;
  
  public abstract long getFilesize(String paramString)
    throws FileTransferException;
  
  public abstract Date getFileTimestamp(String paramString)
    throws FileTransferException;
  
  public abstract void setFileTimestamp(String paramString, Date paramDate)
    throws FileTransferException;
  
  public abstract void setFileModificationTime(String paramString, Date paramDate)
    throws FileTransferException;
  
  public abstract boolean sameChecksum(File paramFile, String paramString)
    throws FileTransferException;
  
  public abstract void renameFile(String paramString1, String paramString2)
    throws FileTransferException;
  
  public abstract void deleteFile(String paramString)
    throws FileTransferException;
  
  public abstract void mdelete(String paramString)
    throws FileTransferException;
  
  public abstract void download(OutputStream paramOutputStream, String paramString)
    throws FileTransferException;
  
  public abstract File download(String paramString)
    throws FileTransferException;
  
  public abstract File download(String paramString1, String paramString2)
    throws FileTransferException;
  
  public abstract void resumeDownload(String paramString, long paramLong)
    throws FileTransferException;
  
  public abstract void resumeDownload(String paramString1, String paramString2, long paramLong)
    throws FileTransferException;
  
  public abstract void mdownload(Enumeration paramEnumeration)
    throws FileTransferException;
  
  public abstract void mdownload(String paramString)
    throws FileTransferException;
  
  public abstract void downloadDir(String paramString)
    throws FileTransferException;
  
  public abstract void downloadDir(String paramString, int paramInt, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void downloadDir(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
    throws FileTransferException;
  
  public abstract void upload(byte[] paramArrayOfByte, String paramString)
    throws FileTransferException;
  
  public abstract void upload(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void upload(File paramFile)
    throws FileTransferException;
  
  public abstract void upload(File paramFile, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void upload(String paramString, File paramFile)
    throws FileTransferException;
  
  public abstract void upload(File paramFile, String paramString)
    throws FileTransferException;
  
  public abstract void upload(File paramFile, String paramString, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void upload(String paramString)
    throws FileTransferException;
  
  public abstract void upload(String paramString, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void upload(String paramString1, String paramString2)
    throws FileTransferException;
  
  public abstract void upload(String paramString1, String paramString2, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void resumeUpload(File paramFile, long paramLong)
    throws FileTransferException;
  
  public abstract void resumeUpload(String paramString, long paramLong)
    throws FileTransferException;
  
  public abstract void resumeUpload(File paramFile, String paramString, long paramLong)
    throws FileTransferException;
  
  public abstract String uploadUnique(String paramString)
    throws FileTransferException;
  
  public abstract String uploadUnique(File paramFile)
    throws FileTransferException;
  
  public abstract String uploadUnique(InputStream paramInputStream, String paramString)
    throws FileTransferException;
  
  public abstract void mupload(Enumeration paramEnumeration)
    throws FileTransferException;
  
  public abstract void mupload(String paramString)
    throws FileTransferException;
  
  public abstract void uploadDir(File paramFile)
    throws FileTransferException;
  
  public abstract void uploadDir(File paramFile, String paramString)
    throws FileTransferException;
  
  public abstract void uploadDir(File paramFile, int paramInt, boolean paramBoolean, String paramString)
    throws FileTransferException;
  
  public abstract void uploadDir(File paramFile, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
    throws FileTransferException;
  
  public abstract InputStream getInputStream(String paramString, long paramLong)
    throws FileTransferException;
  
  public abstract OutputStream getOutputStream(String paramString, long paramLong, boolean paramBoolean)
    throws FileTransferException;
  
  public abstract void interrupt();
  
  public abstract void reset();
  
  public abstract boolean interrupted();
  
  public abstract void abortUploadThread(String paramString);
  
  public abstract void abortDownloadThread(String paramString);
  
  public abstract void abortUploadThreads();
  
  public abstract void abortDownloadThreads();
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.filetransfer.FileTransfer
 * JD-Core Version:    0.7.0.1
 */