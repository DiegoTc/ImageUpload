package org.apache.oro.text.regex;

public abstract interface MatchResult
{
  public abstract int begin(int paramInt);
  
  public abstract int beginOffset(int paramInt);
  
  public abstract int end(int paramInt);
  
  public abstract int endOffset(int paramInt);
  
  public abstract String group(int paramInt);
  
  public abstract int groups();
  
  public abstract int length();
  
  public abstract String toString();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.MatchResult
 * JD-Core Version:    0.7.0.1
 */