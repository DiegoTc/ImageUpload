package com.jscape.util.j.c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLException;

class o
{
  private final SSLEngine a;
  private final ReadableByteChannel b;
  private ByteBuffer c;
  private SSLEngineResult d;
  private boolean e;
  
  private o(SSLEngine paramSSLEngine, InputStream paramInputStream)
  {
    this.a = paramSSLEngine;
    this.b = Channels.newChannel(paramInputStream);
    this.c = c.a.b(this.a);
    this.c.flip();
  }
  
  public synchronized ByteBuffer a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    boolean bool;
    do
    {
      bool = l.g;
      while (f())
      {
        b(paramByteBuffer);
        if (c())
        {
          paramByteBuffer = c(paramByteBuffer);
          if (!bool) {}
        }
        else
        {
          if (bool) {
            continue;
          }
          if (d())
          {
            e();
            g();
          }
        }
      }
      h();
    } while (bool);
    return paramByteBuffer;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  private void b(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    this.d = this.a.unwrap(this.c, paramByteBuffer);
  }
  
  private boolean c()
  {
    return this.d.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW;
  }
  
  private ByteBuffer c(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.flip();
    return c.b.a(this.a, paramByteBuffer);
  }
  
  private boolean d()
  {
    return this.d.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW;
  }
  
  private void e()
  {
    boolean bool = l.g;
    if (!bool)
    {
      if (this.c.remaining() == this.c.capacity())
      {
        this.c = c.a.a(this.a, this.c);
        if (!bool) {
          return;
        }
      }
      if (bool) {}
    }
    else if (this.c.hasRemaining())
    {
      this.c.compact();
      if (!bool) {
        return;
      }
    }
    this.c.clear();
  }
  
  private boolean f()
  {
    boolean bool = l.g;
    if (!bool) {
      if (!c()) {
        if (bool) {
          break label27;
        }
      }
    }
    label27:
    return d();
  }
  
  private void g()
    throws IOException
  {
    this.b.read(this.c);
    this.c.flip();
  }
  
  private void h()
  {
    if ((l.g) || (this.d.getStatus() == SSLEngineResult.Status.CLOSED)) {
      this.e = true;
    }
  }
  
  o(SSLEngine paramSSLEngine, InputStream paramInputStream, m paramm)
  {
    this(paramSSLEngine, paramInputStream);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.o
 * JD-Core Version:    0.7.0.1
 */