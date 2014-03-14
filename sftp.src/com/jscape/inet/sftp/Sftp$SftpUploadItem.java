package com.jscape.inet.sftp;

import com.jscape.inet.ssh.util.SshParameters;
import com.jscape.util.ec;
import com.jscape.util.mb;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

class Sftp$SftpUploadItem
  extends Thread
{
  private Sftp a = null;
  private String b = null;
  private Vector c = null;
  private File d = null;
  private String e = null;
  private boolean f = true;
  private File g = null;
  private boolean h = false;
  private boolean i = false;
  private String j = null;
  final Sftp k;
  
  public Sftp$SftpUploadItem(Sftp paramSftp1, Sftp paramSftp2, String paramString1, Vector paramVector, String paramString2, File paramFile)
  {
    SshParameters localSshParameters = new SshParameters(Sftp.a(paramSftp2));
    this.a = new Sftp(localSshParameters, Sftp.b(paramSftp2));
    if (!SftpPacket.c)
    {
      if (Sftp.c(paramSftp2) != null) {
        this.a.setLineTerminator(Sftp.c(paramSftp2));
      }
      this.a.setDownloadBlockSize(paramSftp2.getDownloadBlockSize());
      this.a.setReceiveBufferSize(Sftp.d(paramSftp2));
      this.a.setSendBufferSize(Sftp.e(paramSftp2));
      Sftp.a(this.a, Sftp.f(paramSftp2));
    }
    this.a.disableFileAccessLogging();
    this.b = paramString1;
    this.c = paramVector;
    this.e = paramString2;
    this.d = paramFile;
  }
  
  public boolean getConnected()
  {
    return this.f;
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
      this.h = true;
      this.a.interrupt();
    }
    catch (Exception localException) {}
  }
  
  public boolean error()
  {
    return this.i;
  }
  
  public String getErrorMessage()
  {
    return this.j;
  }
  
  public void run()
  {
    boolean bool = SftpPacket.c;
    try
    {
      this.a.connect();
      this.f = true;
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
      Enumeration localEnumeration = this.c.elements();
      label232:
      do
      {
        for (;;)
        {
          if (!localEnumeration.hasMoreElements()) {
            break label302;
          }
          if ((bool) || (bool)) {
            break label310;
          }
          if (this.h) {
            break label302;
          }
          this.a.reset();
          this.a.setDir(this.e);
          String str1 = (String)localEnumeration.nextElement();
          this.g = new File(str1);
          String str2 = mb.d(this.d, this.g);
          if (!bool) {
            if (ec.a(str2))
            {
              this.a.makeDirRecursive(this.e + str2);
              if (!bool) {
                break label232;
              }
            }
          }
          str2 = this.e;
          this.a.setDir(str2);
          try
          {
            this.a.upload(this.b, this.g);
          }
          catch (SftpException localSftpException)
          {
            if (!bool)
            {
              if (!this.a.interrupted()) {
                this.i = true;
              }
            }
            else
            {
              this.j = localSftpException.getMessage();
              localSftpException.printStackTrace();
            }
          }
        }
      } while (!bool);
    }
    catch (Exception localException) {}finally
    {
      label302:
      label310:
      this.a.disconnect();
      this.f = false;
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.Sftp.SftpUploadItem
 * JD-Core Version:    0.7.0.1
 */