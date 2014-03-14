package com.jscape.inet.file;

import com.jscape.util.k.e;
import com.jscape.util.k.g;

public class RegexFileFilter
  implements JFileFilter
{
  private final g a;
  
  public RegexFileFilter(String paramString)
  {
    try
    {
      this.a = new e().a(paramString);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.getMessage());
    }
  }
  
  public boolean accepts(JFile paramJFile)
  {
    return accepts(paramJFile.getFilename());
  }
  
  public synchronized boolean accepts(String paramString)
  {
    return this.a.a(paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.RegexFileFilter
 * JD-Core Version:    0.7.0.1
 */