package com.jscape.inet.sftp;

public class SftpPermissionDeniedException
  extends SftpException
{
  private String a;
  private static final String z = -1;
  
  public SftpPermissionDeniedException(String paramString)
  {
    super(z + paramString);
    this.a = paramString;
  }
  
  public String getResource()
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
 * Qualified Name:     com.jscape.inet.sftp.SftpPermissionDeniedException
 * JD-Core Version:    0.7.0.1
 */