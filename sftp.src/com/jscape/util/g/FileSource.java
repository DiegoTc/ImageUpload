package com.jscape.util.g;

import com.jscape.util.fc;
import com.jscape.util.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@fc
public class FileSource
  implements mb
{
  protected final File file;
  private static final String z = -1;
  
  public FileSource(File paramFile)
  {
    u.a(paramFile);
    this.file = paramFile;
  }
  
  public FileSource(String paramString)
  {
    this(new File(paramString));
  }
  
  public boolean writeAllowed()
  {
    return this.file.canWrite();
  }
  
  public boolean readAllowed()
  {
    return this.file.canRead();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return new FileInputStream(this.file);
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return new FileOutputStream(this.file);
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public String toString()
  {
    return z + this.file + "}";
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.FileSource
 * JD-Core Version:    0.7.0.1
 */