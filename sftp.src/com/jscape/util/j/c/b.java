package com.jscape.util.j.c;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

class b
  extends OutputStream
{
  private final ByteBuffer a;
  private final byte[] b;
  final l c;
  private static final String z = -1;
  
  private b(l paraml)
  {
    this.a = c.b.b(l.a(paraml));
    this.b = new byte[1];
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.b[0] = ((byte)paramInt);
    write(this.b);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool = l.g;
    c();
    do
    {
      if (paramInt2 <= 0) {
        break;
      }
      a(paramArrayOfByte, paramInt1, paramInt2);
      paramInt2 -= this.a.remaining();
      paramInt1 += this.a.remaining();
      b();
      a(paramInt2);
    } while (!bool);
  }
  
  private void b()
    throws IOException
  {
    l.b(this.c, this.a);
  }
  
  public void close()
    throws IOException
  {
    l.d(this.c);
  }
  
  private void c()
    throws IOException
  {
    if (l.e(this.c).b()) {
      throw new IOException(z);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.clear();
    int i = Math.min(paramInt2, this.a.capacity());
    this.a.put(paramArrayOfByte, paramInt1, i);
    this.a.flip();
  }
  
  private void a(int paramInt)
    throws IOException
  {
    if ((l.g) || ((l.e(this.c).b()) && (paramInt > 0))) {
      throw new IOException(z);
    }
  }
  
  b(l paraml, m paramm)
  {
    this(paraml);
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.b
 * JD-Core Version:    0.7.0.1
 */