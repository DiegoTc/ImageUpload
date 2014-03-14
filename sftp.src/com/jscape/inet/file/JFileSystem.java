package com.jscape.inet.file;

public abstract interface JFileSystem
{
  public abstract void close();
  
  public abstract boolean isClosed();
  
  public abstract JFile getFile(String paramString);
  
  public abstract JFile getFile(JFile paramJFile, String paramString);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JFileSystem
 * JD-Core Version:    0.7.0.1
 */