package com.jscape.inet.ssh.connection;

import com.jscape.inet.ssh.transport.SshLogger;
import com.jscape.util.Logger.Level;
import com.jscape.util.u;
import java.io.PrintStream;

public class ConnectionConfiguration
{
  private volatile Logger.Level a = Logger.Level.OFF;
  private volatile PrintStream b = System.out;
  
  public Logger.Level getLoggerLevel()
  {
    return this.a;
  }
  
  public void setLoggerLevel(Logger.Level paramLevel)
  {
    u.a(paramLevel);
    this.a = paramLevel;
  }
  
  public PrintStream getLoggerStream()
  {
    return this.b;
  }
  
  public void setLoggerStream(PrintStream paramPrintStream)
  {
    u.a(paramPrintStream);
    this.b = paramPrintStream;
  }
  
  public SshLogger createLogger()
  {
    return new SshLogger(this.a, this.b);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.ConnectionConfiguration
 * JD-Core Version:    0.7.0.1
 */