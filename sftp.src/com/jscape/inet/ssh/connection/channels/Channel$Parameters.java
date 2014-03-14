package com.jscape.inet.ssh.connection.channels;

import com.jscape.util.u;

public final class Channel$Parameters
{
  private final String a;
  private final long b;
  private final long c;
  private final long d;
  private final long e;
  private final long f;
  private final long g;
  
  public Channel$Parameters(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    u.a(paramString);
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramLong3;
    this.e = paramLong4;
    this.f = paramLong5;
    this.g = paramLong6;
  }
  
  public String getType()
  {
    return this.a;
  }
  
  public long getLocalNo()
  {
    return this.b;
  }
  
  public long getLocalWindowSize()
  {
    return this.c;
  }
  
  public long getLocalPacketSize()
  {
    return this.d;
  }
  
  public long getRemoteNo()
  {
    return this.e;
  }
  
  public long getRemoteWindowSize()
  {
    return this.f;
  }
  
  public long getRemotePacketSize()
  {
    return this.g;
  }
  
  static long a(Parameters paramParameters)
  {
    return paramParameters.e;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.channels.Channel.Parameters
 * JD-Core Version:    0.7.0.1
 */