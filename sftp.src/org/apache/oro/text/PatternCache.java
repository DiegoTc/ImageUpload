package org.apache.oro.text;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;

public abstract interface PatternCache
{
  public abstract Pattern addPattern(String paramString)
    throws MalformedPatternException;
  
  public abstract Pattern addPattern(String paramString, int paramInt)
    throws MalformedPatternException;
  
  public abstract int capacity();
  
  public abstract Pattern getPattern(String paramString)
    throws MalformedCachePatternException;
  
  public abstract Pattern getPattern(String paramString, int paramInt)
    throws MalformedCachePatternException;
  
  public abstract int size();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.PatternCache
 * JD-Core Version:    0.7.0.1
 */