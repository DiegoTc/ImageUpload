package com.jscape.util;

import java.io.File;
import java.io.FileFilter;

final class nb
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.isFile();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.nb
 * JD-Core Version:    0.7.0.1
 */