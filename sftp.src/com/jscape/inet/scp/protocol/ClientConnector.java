package com.jscape.inet.scp.protocol;

import com.jscape.inet.scp.protocol.messages.CommandLine;
import com.jscape.util.j.a.g;

public abstract interface ClientConnector
{
  public abstract ScpConnection connect(CommandLine paramCommandLine)
    throws g;
  
  public abstract void dispose();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.ClientConnector
 * JD-Core Version:    0.7.0.1
 */