package org.apache.oro.text.regex;

public abstract interface PatternMatcher
{
  public abstract boolean contains(String paramString, Pattern paramPattern);
  
  public abstract boolean contains(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern);
  
  public abstract boolean contains(char[] paramArrayOfChar, Pattern paramPattern);
  
  public abstract MatchResult getMatch();
  
  public abstract boolean matches(String paramString, Pattern paramPattern);
  
  public abstract boolean matches(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern);
  
  public abstract boolean matches(char[] paramArrayOfChar, Pattern paramPattern);
  
  public abstract boolean matchesPrefix(String paramString, Pattern paramPattern);
  
  public abstract boolean matchesPrefix(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern);
  
  public abstract boolean matchesPrefix(char[] paramArrayOfChar, Pattern paramPattern);
  
  public abstract boolean matchesPrefix(char[] paramArrayOfChar, Pattern paramPattern, int paramInt);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.PatternMatcher
 * JD-Core Version:    0.7.0.1
 */