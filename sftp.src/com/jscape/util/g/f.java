package com.jscape.util.g;

import com.jscape.util.bc;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Deflater;

public class f
  extends InputStream
{
  private static final int a = 512;
  private static final int b = 1;
  private static final int c = -1;
  private final InputStream d;
  private final Deflater e;
  private final byte[] f;
  private byte[] g;
  private boolean h;
  
  public f(InputStream paramInputStream, Deflater paramDeflater, int paramInt)
  {
    bc.a(paramInputStream);
    this.d = paramInputStream;
    bc.a(paramDeflater);
    this.e = paramDeflater;
    this.f = new byte[paramInt];
    this.g = new byte[1];
  }
  
  public f(InputStream paramInputStream, Deflater paramDeflater)
  {
    this(paramInputStream, paramDeflater, 512);
  }
  
  public f(InputStream paramInputStream)
  {
    this(paramInputStream, new Deflater());
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.e.end();
    }
    finally
    {
      qb.a(this.d);
    }
  }
  
  public int read()
    throws IOException
  {
    int i = read(this.g, 0, 1);
    if (m.d == 0) {}
    return i == -1 ? -1 : this.g[0] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int k = m.d;
    int i = 0;
    do
    {
      if (paramInt2 <= 0) {
        break;
      }
      if ((k != 0) || (k != 0)) {
        break label72;
      }
      if (this.e.finished()) {
        break;
      }
      b();
      int j = this.e.deflate(paramArrayOfByte, paramInt1, paramInt2);
      i += j;
      paramInt1 += j;
      paramInt2 -= j;
    } while (k == 0);
    label72:
    if (k == 0) {
      if (i == 0)
      {
        if (k != 0) {
          break label105;
        }
        if (this.e.finished())
        {
          this.h = true;
          i = -1;
        }
      }
    }
    label105:
    return i;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    int k = m.d;
    if (k == 0) {
      if (this.g.length < 512) {
        this.g = new byte[512];
      }
    }
    int i = (int)Math.min(paramLong, 2147483647L);
    long l = 0L;
    do
    {
      if (i <= 0) {
        break;
      }
      int j = read(this.g, 0, Math.min(i, this.g.length));
      if (k == 0)
      {
        if (j < 0) {
          break;
        }
        l += j;
      }
      i -= j;
    } while (k == 0);
    return l;
  }
  
  public int available()
    throws IOException
  {
    if (m.d == 0) {}
    return this.h ? 0 : 1;
  }
  
  private void b()
    throws IOException
  {
    int j = m.d;
    if ((j != 0) || (this.e.needsInput()))
    {
      int i = this.d.read(this.f, 0, this.f.length);
      if (j == 0) {
        if (i > 0) {
          this.e.setInput(this.f, 0, i);
        }
      }
      if ((j != 0) && (i < 0)) {
        this.e.finish();
      }
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.g.f
 * JD-Core Version:    0.7.0.1
 */