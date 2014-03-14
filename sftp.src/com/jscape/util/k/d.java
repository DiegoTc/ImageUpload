package com.jscape.util.k;

import com.jscape.util.u;
import java.io.File;
import java.io.FileFilter;

public class d
  implements FileFilter
{
  private final g a;
  private static final String z = -1;
  
  public d(g paramg)
  {
    u.a(paramg);
    this.a = paramg;
  }
  
  public boolean accept(File paramFile)
  {
    int i = e.b;
    if ((i != 0) || (paramFile.isFile())) {
      if (i != 0) {}
    }
    return this.a.a(paramFile.getName());
  }
  
  public String toString()
  {
    return z + this.a + '}';
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.k.d
 * JD-Core Version:    0.7.0.1
 */