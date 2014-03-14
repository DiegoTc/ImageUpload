package com.jscape.inet.ftp;

import java.io.InputStream;
import java.io.OutputStream;

public abstract interface FtpConnection
{
  public abstract void prepareIncoming(int paramInt1, int paramInt2, int paramInt3)
    throws FtpException;
  
  public abstract void openIncoming(int paramInt1, int paramInt2)
    throws FtpException;
  
  public abstract void openOutgoing(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws FtpException;
  
  public abstract void openOutgoing(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString2, int paramInt4, String paramString3, String paramString4, String paramString5)
    throws FtpException;
  
  public abstract void close();
  
  public abstract boolean isOpen();
  
  public abstract InputStream getInputStream()
    throws FtpException;
  
  public abstract OutputStream getOutputStream()
    throws FtpException;
  
  public abstract String getHost();
  
  public abstract void setCompression(boolean paramBoolean);
  
  public abstract void setSendBufferSize(int paramInt);
  
  public abstract void setReceiveBufferSize(int paramInt);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpConnection
 * JD-Core Version:    0.7.0.1
 */