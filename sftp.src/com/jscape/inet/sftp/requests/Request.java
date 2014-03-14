package com.jscape.inet.sftp.requests;

import com.jscape.inet.sftp.SftpClient;
import com.jscape.inet.sftp.SftpException;

public abstract interface Request
{
  public abstract boolean isValid();
  
  public abstract void execute(SftpClient paramSftpClient)
    throws SftpException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.requests.Request
 * JD-Core Version:    0.7.0.1
 */