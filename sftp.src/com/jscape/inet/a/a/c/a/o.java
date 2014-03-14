package com.jscape.inet.a.a.c.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.util.g.m;
import com.jscape.util.g.qb;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class o
{
  private final qb<j> a;
  private final m b;
  private final DatagramPacket c;
  
  public o(qb<j> paramqb, int paramInt)
  {
    this.a = paramqb;
    this.b = new m(paramInt);
    this.c = new DatagramPacket(new byte[0], 0);
  }
  
  public void a(j paramj, DatagramSocket paramDatagramSocket)
    throws IOException
  {
    this.b.d();
    this.a.write(paramj, this.b);
    this.c.setData(this.b.b(), 0, this.b.c());
    this.c.setSocketAddress(paramj.c);
    paramDatagramSocket.send(this.c);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.o
 * JD-Core Version:    0.7.0.1
 */