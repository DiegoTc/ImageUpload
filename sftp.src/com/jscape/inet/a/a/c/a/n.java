package com.jscape.inet.a.a.c.a;

import com.jscape.inet.a.a.c.a.b.j;
import com.jscape.util.g.d;
import com.jscape.util.g.lb;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class n
{
  private final lb<j> a;
  private final DatagramPacket b;
  private final d c;
  
  public n(lb<j> paramlb, int paramInt)
  {
    this.a = paramlb;
    this.b = new DatagramPacket(new byte[paramInt], paramInt);
    this.c = new d(new byte[0]);
  }
  
  public j a(DatagramSocket paramDatagramSocket)
    throws IOException
  {
    paramDatagramSocket.receive(this.b);
    this.c.a(this.b.getData(), 0, this.b.getLength());
    j localj = (j)this.a.read(this.c);
    localj.b = ((InetSocketAddress)this.b.getSocketAddress());
    return localj;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */