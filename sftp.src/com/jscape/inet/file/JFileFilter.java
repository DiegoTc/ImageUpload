package com.jscape.inet.file;

public abstract interface JFileFilter
{
  public abstract boolean accepts(JFile paramJFile);
  
  public abstract boolean accepts(String paramString);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.JFileFilter
 * JD-Core Version:    0.7.0.1
 */