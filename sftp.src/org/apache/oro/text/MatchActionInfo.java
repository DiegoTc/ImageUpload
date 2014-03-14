package org.apache.oro.text;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Vector;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternMatcher;

public final class MatchActionInfo
{
  public int lineNumber;
  public String line;
  public char[] charLine;
  public Pattern fieldSeparator;
  public Vector fields;
  public PatternMatcher matcher;
  public Pattern pattern;
  public MatchResult match;
  public PrintWriter output;
  public BufferedReader input;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.MatchActionInfo
 * JD-Core Version:    0.7.0.1
 */