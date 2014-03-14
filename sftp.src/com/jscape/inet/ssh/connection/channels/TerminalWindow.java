package com.jscape.inet.ssh.connection.channels;

import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TerminalWindow
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  
  public static TerminalWindow readFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    int i = SshUint32.readIntFrom(paramInputStream);
    int j = SshUint32.readIntFrom(paramInputStream);
    int k = SshUint32.readIntFrom(paramInputStream);
    int m = SshUint32.readIntFrom(paramInputStream);
    return new TerminalWindow(i, j, k, m);
  }
  
  public TerminalWindow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public int getCharWidth()
  {
    return this.a;
  }
  
  public int getCharHight()
  {
    return this.b;
  }
  
  public int getPixelWidth()
  {
    return this.c;
  }
  
  public int getPixelHight()
  {
    return this.d;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramOutputStream);
    SshUint32.writeIntTo(this.a, paramOutputStream);
    SshUint32.writeIntTo(this.b, paramOutputStream);
    SshUint32.writeIntTo(this.c, paramOutputStream);
    SshUint32.writeIntTo(this.d, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.channels.TerminalWindow
 * JD-Core Version:    0.7.0.1
 */