package com.jscape.util.j.c;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLException;

class p
{
  private final SSLEngine a;
  private final WritableByteChannel b;
  private ByteBuffer c;
  private SSLEngineResult d;
  private boolean e;
  
  private p(SSLEngine paramSSLEngine, OutputStream paramOutputStream)
  {
    this.a = paramSSLEngine;
    this.b = Channels.newChannel(paramOutputStream);
    this.c = c.a.b(this.a);
  }
  
  public synchronized void a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    b(paramByteBuffer);
    c();
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  private void b(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    boolean bool = l.g;
    do
    {
      this.c.clear();
      while (d())
      {
        c(paramByteBuffer);
        if (d()) {
          e();
        }
      }
    } while (bool);
    f();
  }
  
  private void c()
    throws IOException
  {
    if ((l.g) || (this.c.hasRemaining())) {
      this.b.write(this.c);
    }
  }
  
  private void c(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    this.d = this.a.wrap(paramByteBuffer, this.c);
    this.c.flip();
  }
  
  private boolean d()
  {
    return this.d.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW;
  }
  
  private void e()
  {
    this.c = c.a.a(this.a, this.c);
  }
  
  private void f()
  {
    if ((l.g) || (this.d.getStatus() == SSLEngineResult.Status.CLOSED)) {
      this.e = true;
    }
  }
  
  p(SSLEngine paramSSLEngine, OutputStream paramOutputStream, m paramm)
  {
    this(paramSSLEngine, paramOutputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.p
 * JD-Core Version:    0.7.0.1
 */