package com.jscape.util.j.c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

class a
  extends InputStream
{
  private ByteBuffer a;
  private final byte[] b;
  final l c;
  
  private a(l paraml)
  {
    this.a = c.b.b(l.a(paraml));
    this.a.flip();
    this.b = new byte[1];
  }
  
  public int read()
    throws IOException
  {
    int i = read(this.b);
    if (!l.g) {}
    return a(i) ? i : this.b[0] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!l.g)
    {
      if (l.b(this.c).b()) {
        return -1;
      }
      b();
    }
    return a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int available()
    throws IOException
  {
    return this.a.remaining();
  }
  
  public void close()
    throws IOException
  {
    l.c(this.c);
  }
  
  private boolean a(int paramInt)
  {
    if (!l.g) {}
    return paramInt == -1;
  }
  
  private void b()
    throws IOException
  {
    if ((l.g) || (!this.a.hasRemaining()))
    {
      this.a.clear();
      this.a = l.a(this.c, this.a);
    }
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!l.g) {
      if (!this.a.hasRemaining()) {
        return -1;
      }
    }
    int i = Math.min(paramInt2, this.a.remaining());
    this.a.get(paramArrayOfByte, paramInt1, i);
    return i;
  }
  
  a(l paraml, m paramm)
  {
    this(paraml);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.a
 * JD-Core Version:    0.7.0.1
 */