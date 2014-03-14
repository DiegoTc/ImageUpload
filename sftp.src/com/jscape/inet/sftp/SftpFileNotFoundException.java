package com.jscape.inet.sftp;

public class SftpFileNotFoundException
  extends SftpException
{
  private String a;
  private static final String z = -1;
  
  public SftpFileNotFoundException(String paramString)
  {
    super(z);
    this.a = paramString;
  }
  
  public String getFilename()
  {
    return this.a;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.SftpFileNotFoundException
 * JD-Core Version:    0.7.0.1
 */