package com.jscape.ftcl;

import com.jscape.ftcl.b.a.cf;
import com.jscape.util.gc;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class FileTransferAgentTask
  extends Task
{
  private String scriptFile;
  private String hostname;
  private Integer port;
  private gc timeout;
  private String username;
  private String password;
  private Boolean secure;
  private String keyFile;
  private Boolean debug = Boolean.valueOf(true);
  private String logFile;
  private static final String z = -1;
  
  public void setScriptFile(String paramString)
  {
    this.scriptFile = paramString;
  }
  
  public void setHostname(String paramString)
  {
    this.hostname = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.port = Integer.valueOf(paramInt);
  }
  
  public void setTimeout(int paramInt)
  {
    this.timeout = gc.d(paramInt);
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setSecure(boolean paramBoolean)
  {
    this.secure = Boolean.valueOf(paramBoolean);
  }
  
  public void setKeyFile(String paramString)
  {
    this.keyFile = paramString;
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.debug = Boolean.valueOf(paramBoolean);
  }
  
  public void setLogFile(String paramString)
  {
    this.logFile = paramString;
  }
  
  public void execute()
    throws BuildException
  {
    k localk = asConfiguration();
    try
    {
      FTCL.execute(localk);
    }
    catch (Exception localException)
    {
      throw new BuildException(localException);
    }
  }
  
  private k asConfiguration()
    throws BuildException
  {
    checkParameters();
    return new k(this.scriptFile, this.hostname, this.port, this.timeout, this.username, this.password, this.secure, this.keyFile, this.debug, this.logFile, new cf());
  }
  
  private void checkParameters()
    throws BuildException
  {
    if (this.scriptFile == null) {
      throw new BuildException(z);
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.FileTransferAgentTask
 * JD-Core Version:    0.7.0.1
 */