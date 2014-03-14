package com.jscape.inet.file;

import com.jscape.util.ic;
import com.jscape.util.u;

public class WildcardFileFilter
  implements JFileFilter
{
  private final ic a;
  
  public WildcardFileFilter(String paramString)
  {
    u.a(paramString);
    this.a = new ic(paramString);
  }
  
  public boolean accepts(JFile paramJFile)
  {
    return accepts(paramJFile.getFilename());
  }
  
  public synchronized boolean accepts(String paramString)
  {
    return this.a.c(paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.file.WildcardFileFilter
 * JD-Core Version:    0.7.0.1
 */