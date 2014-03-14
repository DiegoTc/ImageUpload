package com.jscape.util.j.c;

import com.jscape.util.bc;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;

public class l
{
  private final SSLEngine a;
  private final o b;
  private final p c;
  private final n d;
  private final InputStream e;
  private final OutputStream f;
  public static boolean g;
  
  public l(SSLEngine paramSSLEngine, InputStream paramInputStream, OutputStream paramOutputStream)
  {
    bc.a(paramSSLEngine);
    this.a = paramSSLEngine;
    this.b = new o(paramSSLEngine, paramInputStream, null);
    this.c = new p(paramSSLEngine, paramOutputStream, null);
    this.d = new n(paramSSLEngine, this.b, this.c, null);
    this.e = new a(this, null);
    this.f = new b(this, null);
    if (bool) {
      u.a = !u.a;
    }
  }
  
  public InputStream b()
  {
    return this.e;
  }
  
  public OutputStream c()
  {
    return this.f;
  }
  
  private void a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    boolean bool = g;
    do
    {
      if ((this.c.b()) || (!paramByteBuffer.hasRemaining())) {
        break;
      }
      this.c.a(paramByteBuffer);
      a(this.c.b());
      d();
    } while (!bool);
  }
  
  private ByteBuffer b(ByteBuffer paramByteBuffer)
    throws IOException
  {
    boolean bool = g;
    do
    {
      if (this.b.b()) {
        break;
      }
      if ((bool) || (bool)) {
        break label63;
      }
      if (paramByteBuffer.position() != 0) {
        break;
      }
      paramByteBuffer = this.b.a(paramByteBuffer);
      a(this.b.b());
      d();
    } while (!bool);
    paramByteBuffer.flip();
    label63:
    return paramByteBuffer;
  }
  
  private void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      this.d.c();
    }
  }
  
  private void d()
    throws IOException
  {
    this.d.b();
  }
  
  private void e()
    throws SSLException
  {
    this.a.closeInbound();
  }
  
  private void f()
  {
    this.a.closeOutbound();
  }
  
  static SSLEngine a(l paraml)
  {
    return paraml.a;
  }
  
  static o b(l paraml)
  {
    return paraml.b;
  }
  
  static void c(l paraml)
    throws SSLException
  {
    paraml.e();
  }
  
  static ByteBuffer a(l paraml, ByteBuffer paramByteBuffer)
    throws IOException
  {
    return paraml.b(paramByteBuffer);
  }
  
  static void b(l paraml, ByteBuffer paramByteBuffer)
    throws IOException
  {
    paraml.a(paramByteBuffer);
  }
  
  static void d(l paraml)
  {
    paraml.f();
  }
  
  static p e(l paraml)
  {
    return paraml.c;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.l
 * JD-Core Version:    0.7.0.1
 */