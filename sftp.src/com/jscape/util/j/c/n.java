package com.jscape.util.j.c;

import java.io.IOException;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;

class n
{
  private final SSLEngine a;
  private final o b;
  private final p c;
  private ByteBuffer d;
  
  private n(SSLEngine paramSSLEngine, o paramo, p paramp)
  {
    this.a = paramSSLEngine;
    this.b = paramo;
    this.c = paramp;
  }
  
  public synchronized void b()
    throws IOException
  {
    if ((l.g) || (d())) {
      e();
    }
  }
  
  public synchronized void c()
    throws IOException
  {
    boolean bool = l.g;
    this.d = c.b.b(this.a);
    do
    {
      while (!this.a.isOutboundDone()) {
        i();
      }
      this.d = null;
    } while (bool);
  }
  
  private boolean d()
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus = this.a.getHandshakeStatus();
    return (l.g) || ((localHandshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) && (localHandshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED));
  }
  
  private void e()
    throws IOException
  {
    boolean bool = l.g;
    this.d = c.b.b(this.a);
    if (f())
    {
      g();
      i();
      if (!bool) {}
    }
    else if (!bool)
    {
      if (h())
      {
        i();
        if (!bool) {
          break label71;
        }
      }
    }
    label71:
    do
    {
      if (!bool) {
        if (j()) {
          k();
        }
      }
      if (d()) {
        break;
      }
      this.d = null;
    } while (bool);
  }
  
  private boolean f()
  {
    return this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK;
  }
  
  private void g()
  {
    boolean bool = l.g;
    do
    {
      Runnable localRunnable;
      if ((localRunnable = this.a.getDelegatedTask()) == null) {
        break;
      }
      localRunnable.run();
    } while (!bool);
  }
  
  private boolean h()
  {
    return this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP;
  }
  
  private void i()
    throws IOException
  {
    this.d.clear();
    this.d.flip();
    this.c.a(this.d);
  }
  
  private boolean j()
  {
    return this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
  }
  
  private void k()
    throws IOException
  {
    this.d.clear();
    this.d = this.b.a(this.d);
  }
  
  n(SSLEngine paramSSLEngine, o paramo, p paramp, m paramm)
  {
    this(paramSSLEngine, paramo, paramp);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.c.n
 * JD-Core Version:    0.7.0.1
 */