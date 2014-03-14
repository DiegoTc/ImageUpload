package com.jscape.inet.sftp;

import com.jscape.inet.ssh.util.SshParameters;
import com.jscape.util.mb;
import com.jscape.util.u;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

class Sftp$SftpDownloadItem
  extends Thread
{
  private Sftp a = null;
  private File b = null;
  private String c = null;
  private boolean d = true;
  private Vector e = null;
  private File f = null;
  private boolean g = false;
  private boolean h = false;
  private String i = null;
  final Sftp j;
  
  public Sftp$SftpDownloadItem(Sftp paramSftp1, Sftp paramSftp2, File paramFile, String paramString, Vector paramVector)
  {
    this.b = paramFile;
    this.c = paramString;
    this.f = new File(this.c);
    this.e = paramVector;
    SshParameters localSshParameters = new SshParameters(Sftp.a(paramSftp2));
    this.a = new Sftp(localSshParameters, Sftp.b(paramSftp2));
    if (!bool)
    {
      if (Sftp.c(paramSftp2) != null) {
        this.a.setLineTerminator(Sftp.c(paramSftp2));
      }
      this.a.setDownloadBlockSize(Sftp.m(paramSftp2));
      this.a.setReceiveBufferSize(Sftp.d(paramSftp2));
      this.a.setSendBufferSize(Sftp.e(paramSftp2));
      Sftp.a(this.a, Sftp.f(paramSftp2));
    }
    this.a.disableFileAccessLogging();
    if (u.a) {
      SftpPacket.c = !bool;
    }
  }
  
  public boolean getConnected()
  {
    return this.d;
  }
  
  public void interruptTransfer()
  {
    try
    {
      this.a.interrupt();
    }
    catch (Exception localException) {}
  }
  
  public void cancelTransfer()
  {
    try
    {
      this.g = true;
      this.a.interrupt();
    }
    catch (Exception localException) {}
  }
  
  public boolean error()
  {
    return this.h;
  }
  
  public String getErrorMessage()
  {
    return this.i;
  }
  
  public void run()
  {
    boolean bool = SftpPacket.c;
    try
    {
      this.a.connect();
      this.d = true;
      if (!bool)
      {
        if (this.a.getMode() == 1)
        {
          this.a.setAscii();
          if (!bool) {
            break label96;
          }
        }
        if (bool) {}
      }
      else
      {
        if (this.a.getMode() == 2)
        {
          this.a.setBinary();
          if (!bool) {
            break label96;
          }
        }
        if (bool) {
          break label97;
        }
      }
      if (this.a.getMode() == 0) {
        this.a.setAuto(true);
      }
      label96:
      label97:
      Enumeration localEnumeration = this.e.elements();
      do
      {
        for (;;)
        {
          if (!localEnumeration.hasMoreElements()) {
            break label296;
          }
          if ((bool) || (bool)) {
            break label304;
          }
          if (this.g) {
            break label296;
          }
          this.a.reset();
          this.a.setDir(this.c);
          this.a.setLocalDir(this.b);
          String str1 = (String)localEnumeration.nextElement();
          File localFile1 = new File(str1);
          String str2 = mb.d(this.f, localFile1);
          if (!bool) {
            if ((str2 != null) && (!str2.equals("")))
            {
              this.a.setDir(str2);
              File localFile2 = this.a.makeLocalDir(str2);
              this.a.setLocalDir(localFile2);
            }
          }
          try
          {
            this.a.download(localFile1.getName());
          }
          catch (SftpException localSftpException)
          {
            if (!bool)
            {
              if (!this.a.interrupted()) {
                this.h = true;
              }
            }
            else
            {
              this.i = localSftpException.getMessage();
              localSftpException.printStackTrace();
            }
          }
        }
      } while (!bool);
    }
    catch (Exception localException) {}finally
    {
      label296:
      label304:
      this.a.disconnect();
      this.d = false;
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.Sftp.SftpDownloadItem
 * JD-Core Version:    0.7.0.1
 */