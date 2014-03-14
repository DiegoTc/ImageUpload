package com.jscape.inet.ssh.transport.compression.zlib;

public final class ZlibStream
{
  private static final int a = 15;
  private static final int b = 15;
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  private static final int h = 9;
  private static final int i = 0;
  private static final int j = 1;
  private static final int k = 2;
  private static final int l = -1;
  private static final int m = -2;
  private static final int n = -3;
  private static final int o = -4;
  private static final int p = -5;
  private static final int q = -6;
  public byte[] nextIn;
  public int nextInIndex;
  public int availIn;
  public long totalIn;
  public byte[] nextOut;
  public int nextOutIndex;
  public int availOut;
  public long totalOut;
  public String msg;
  ZlibDeflater r;
  ZlibInflater s;
  int t;
  public long adler;
  ZlibAdler32 u = new ZlibAdler32();
  public static boolean v;
  
  public int inflateInit()
  {
    return inflateInit(15);
  }
  
  public int inflateInit(int paramInt)
  {
    this.s = new ZlibInflater();
    return this.s.a(this, paramInt);
  }
  
  public int inflate(int paramInt)
  {
    if (!v) {
      if (this.s == null) {
        return -2;
      }
    }
    return this.s.b(this, paramInt);
  }
  
  public int inflateEnd()
  {
    if (!v) {
      if (this.s == null) {
        return -2;
      }
    }
    int i1 = this.s.b(this);
    this.s = null;
    return i1;
  }
  
  public int inflateSync()
  {
    if (!v) {
      if (this.s == null) {
        return -2;
      }
    }
    return this.s.c(this);
  }
  
  public int inflateSetDictionary(byte[] paramArrayOfByte, int paramInt)
  {
    if (!v) {
      if (this.s == null) {
        return -2;
      }
    }
    return this.s.a(this, paramArrayOfByte, paramInt);
  }
  
  public int deflateInit(int paramInt)
  {
    return deflateInit(paramInt, 15);
  }
  
  public int deflateInit(int paramInt1, int paramInt2)
  {
    this.r = new ZlibDeflater();
    return this.r.a(this, paramInt1, paramInt2);
  }
  
  public int deflate(int paramInt)
  {
    if (!v) {
      if (this.r == null) {
        return -2;
      }
    }
    return this.r.b(this, paramInt);
  }
  
  public int deflateEnd()
  {
    if (!v) {
      if (this.r == null) {
        return -2;
      }
    }
    int i1 = this.r.k();
    this.r = null;
    return i1;
  }
  
  public int deflateParams(int paramInt1, int paramInt2)
  {
    if (!v) {
      if (this.r == null) {
        return -2;
      }
    }
    return this.r.b(this, paramInt1, paramInt2);
  }
  
  public int deflateSetDictionary(byte[] paramArrayOfByte, int paramInt)
  {
    if (!v) {
      if (this.r == null) {
        return -2;
      }
    }
    return this.r.a(this, paramArrayOfByte, paramInt);
  }
  
  void b()
  {
    boolean bool = v;
    int i1 = this.r.jb;
    if (!bool) {
      if (i1 > this.availOut) {
        i1 = this.availOut;
      }
    }
    if (!bool)
    {
      if (i1 == 0) {
        return;
      }
      System.arraycopy(this.r.gb, this.r.ib, this.nextOut, this.nextOutIndex, i1);
      this.nextOutIndex += i1;
      this.r.ib += i1;
      this.totalOut += i1;
      this.availOut -= i1;
      this.r.jb -= i1;
    }
    if ((bool) || (this.r.jb == 0)) {
      this.r.ib = 0;
    }
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = v;
    int i1 = this.availIn;
    if (!bool) {
      if (i1 > paramInt2) {
        i1 = paramInt2;
      }
    }
    if (!bool)
    {
      if (i1 == 0) {
        return 0;
      }
      this.availIn -= i1;
    }
    if (!bool)
    {
      if (this.r.kb == 0) {
        this.adler = this.u.a(this.adler, this.nextIn, this.nextInIndex, i1);
      }
      System.arraycopy(this.nextIn, this.nextInIndex, paramArrayOfByte, paramInt1, i1);
      this.nextInIndex += i1;
      this.totalIn += i1;
    }
    return i1;
  }
  
  public void free()
  {
    this.nextIn = null;
    this.nextOut = null;
    this.msg = null;
    this.u = null;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.compression.zlib.ZlibStream
 * JD-Core Version:    0.7.0.1
 */