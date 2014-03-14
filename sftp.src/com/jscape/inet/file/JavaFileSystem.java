package com.jscape.inet.file;

public final class JavaFileSystem
  implements JFileSystem
{
  private static final JavaFileSystem a = new JavaFileSystem();
  
  public static JavaFileSystem getInstance()
  {
    return a;
  }
  
  public JFile getFile(String paramString)
  {
    return new JavaFile(paramString);
  }
  
  public JFile getFile(JFile paramJFile, String paramString)
  {
    return new JavaFile(paramJFile, paramString);
  }
  
  public void close() {}
  
  public boolean isClosed()
  {
    return false;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JavaFileSystem
 * JD-Core Version:    0.7.0.1
 */