package com.jscape.util;

import java.io.File;
import java.io.FileFilter;

final class ob
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.isDirectory();
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.ob
 * JD-Core Version:    0.7.0.1
 */