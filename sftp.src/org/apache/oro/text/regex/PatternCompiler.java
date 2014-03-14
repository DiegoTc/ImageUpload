package org.apache.oro.text.regex;

public abstract interface PatternCompiler
{
  public abstract Pattern compile(String paramString)
    throws MalformedPatternException;
  
  public abstract Pattern compile(String paramString, int paramInt)
    throws MalformedPatternException;
  
  public abstract Pattern compile(char[] paramArrayOfChar)
    throws MalformedPatternException;
  
  public abstract Pattern compile(char[] paramArrayOfChar, int paramInt)
    throws MalformedPatternException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.PatternCompiler
 * JD-Core Version:    0.7.0.1
 */