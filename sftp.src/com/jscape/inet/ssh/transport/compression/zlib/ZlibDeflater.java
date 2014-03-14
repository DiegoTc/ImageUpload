package com.jscape.inet.ssh.transport.compression.zlib;

public final class ZlibDeflater
{
  ZlibStream a;
  private static final int b = 9;
  private static final int c = -1;
  private static final int d = 15;
  private static final int e = 8;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final ZlibDeflater.Config[] i;
  private static final String[] j;
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int o = 32;
  private static final int p = 1;
  private static final int q = 2;
  private static final int r = 0;
  private static final int s = 0;
  private static final int t = 1;
  private static final int u = 2;
  private static final int v = 3;
  private static final int w = 4;
  private static final int x = 0;
  private static final int y = 1;
  private static final int z = 2;
  private static final int A = -1;
  private static final int B = -2;
  private static final int C = -3;
  private static final int D = -4;
  private static final int E = -5;
  private static final int F = -6;
  private static final int G = 42;
  private static final int H = 113;
  private static final int I = 666;
  private static final int J = 8;
  private static final int K = 0;
  private static final int L = 1;
  private static final int M = 2;
  private static final int N = 0;
  private static final int O = 1;
  private static final int P = 2;
  private static final int Q = 16;
  private static final int R = 16;
  private static final int S = 17;
  private static final int T = 18;
  private static final int U = 3;
  private static final int V = 258;
  private static final int W = 262;
  private static final int X = 15;
  private static final int Y = 30;
  private static final int Z = 19;
  private static final int ab = 29;
  private static final int bb = 256;
  private static final int cb = 286;
  private static final int db = 573;
  private static final int eb = 256;
  int fb;
  byte[] gb;
  int hb;
  int ib;
  int jb;
  int kb;
  byte lb;
  byte mb;
  int nb;
  int ob;
  int pb;
  int qb;
  byte[] rb;
  int sb;
  short[] tb;
  short[] ub;
  int vb;
  int wb;
  int xb;
  int yb;
  int zb;
  int Ab;
  int Bb;
  int Cb;
  int Db;
  int Eb;
  int Fb;
  int Gb;
  int Hb;
  int Ib;
  int Jb;
  int Kb;
  int Lb;
  int Mb;
  int Nb;
  short[] Ob = new short[1146];
  short[] Pb = new short[122];
  short[] Qb = new short[78];
  Tree Rb = new Tree();
  Tree Sb = new Tree();
  Tree Tb = new Tree();
  short[] Ub = new short[16];
  int[] Vb = new int[573];
  int Wb;
  int Xb;
  byte[] Yb = new byte[573];
  int Zb;
  int ac;
  int bc;
  int cc;
  int dc;
  int ec;
  int fc;
  int gc;
  short hc;
  int ic;
  
  void b()
  {
    boolean bool = ZlibStream.v;
    this.sb = (2 * this.ob);
    this.ub[(this.wb - 1)] = 0;
    int i1 = 0;
    do
    {
      if (i1 >= this.wb - 1) {
        break;
      }
      this.ub[i1] = 0;
      i1++;
      if (bool) {
        return;
      }
    } while (!bool);
    this.Jb = i[this.Kb].b;
    this.Mb = i[this.Kb].a;
    this.Nb = i[this.Kb].c;
    this.Ib = i[this.Kb].d;
    this.Eb = 0;
    this.Ab = 0;
    this.Gb = 0;
    this.Bb = (this.Hb = 2);
    this.Db = 0;
    this.vb = 0;
  }
  
  void c()
  {
    this.Rb.w = this.Ob;
    this.Rb.y = StaticTree.j;
    this.Sb.w = this.Pb;
    this.Sb.y = StaticTree.k;
    this.Tb.w = this.Qb;
    this.Tb.y = StaticTree.l;
    this.hc = 0;
    this.ic = 0;
    this.gc = 8;
    d();
  }
  
  void d()
  {
    boolean bool = ZlibStream.v;
    int i1 = 0;
    do
    {
      if (i1 >= 286) {
        break;
      }
      this.Ob[(i1 * 2)] = 0;
      i1++;
      if (bool) {
        break label35;
      }
    } while (!bool);
    i1 = 0;
    label35:
    do
    {
      if (i1 >= 30) {
        break;
      }
      this.Pb[(i1 * 2)] = 0;
      i1++;
      if (bool) {
        break label63;
      }
    } while (!bool);
    i1 = 0;
    label63:
    do
    {
      if (i1 >= 19) {
        break;
      }
      this.Qb[(i1 * 2)] = 0;
      i1++;
      if (bool) {
        return;
      }
    } while (!bool);
    this.Ob[512] = 1;
    this.dc = (this.ec = 0);
    this.bc = (this.fc = 0);
  }
  
  void a(short[] paramArrayOfShort, int paramInt)
  {
    boolean bool = ZlibStream.v;
    int i1 = this.Vb[paramInt];
    int i2 = paramInt << 1;
    label91:
    do
    {
      if (i2 > this.Wb) {
        break;
      }
      if (!bool) {
        if (i2 < this.Wb)
        {
          if (bool) {
            break label91;
          }
          if (a(paramArrayOfShort, this.Vb[(i2 + 1)], this.Vb[i2], this.Yb)) {
            i2++;
          }
        }
      }
      if (!bool)
      {
        if (a(paramArrayOfShort, i1, this.Vb[i2], this.Yb)) {
          break;
        }
        this.Vb[paramInt] = this.Vb[i2];
        paramInt = i2;
      }
      i2 <<= 1;
    } while (!bool);
    this.Vb[paramInt] = i1;
  }
  
  static boolean a(short[] paramArrayOfShort, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool = ZlibStream.v;
    if (!bool) {
      if (paramArrayOfShort[(paramInt1 * 2)] >= paramArrayOfShort[(paramInt2 * 2)]) {
        if (!bool)
        {
          if (paramArrayOfShort[(paramInt1 * 2)] != paramArrayOfShort[(paramInt2 * 2)]) {
            break label59;
          }
          if (bool) {
            break label56;
          }
        }
      }
    }
    label56:
    label59:
    return paramArrayOfByte[paramInt1] <= paramArrayOfByte[paramInt2];
  }
  
  void b(short[] paramArrayOfShort, int paramInt)
  {
    boolean bool = ZlibStream.v;
    int i2 = -1;
    int i4 = paramArrayOfShort[1];
    int i5 = 0;
    int i6 = 7;
    int i7 = 4;
    if (!bool)
    {
      if (i4 == 0)
      {
        i6 = 138;
        i7 = 3;
      }
      paramArrayOfShort[((paramInt + 1) * 2 + 1)] = -1;
    }
    int i1 = 0;
    label137:
    label219:
    do
    {
      if (i1 > paramInt) {
        break;
      }
      int i3 = i4;
      i4 = paramArrayOfShort[((i1 + 1) * 2 + 1)];
      i5++;
      if (!bool) {
        if (i5 < i6)
        {
          if (!bool) {
            if (i3 == i4) {
              break label280;
            }
          }
        }
        else {
          if (bool) {
            break label137;
          }
        }
      }
      if (i5 < i7)
      {
        tmp123_122 = (i3 * 2);
        tmp123_116 = this.Qb;
        tmp123_116[tmp123_122] = ((short)(tmp123_116[tmp123_122] + i5));
        if (!bool) {}
      }
      else
      {
        if (!bool) {
          if (i3 != 0)
          {
            if (i3 != i2)
            {
              tmp160_159 = (i3 * 2);
              tmp160_153 = this.Qb;
              tmp160_153[tmp160_159] = ((short)(tmp160_153[tmp160_159] + 1));
            }
            tmp172_167 = this.Qb;
            tmp172_167[32] = ((short)(tmp172_167[32] + 1));
            if (!bool) {
              break label219;
            }
          }
        }
        if (i5 <= 10)
        {
          tmp196_191 = this.Qb;
          tmp196_191[34] = ((short)(tmp196_191[34] + 1));
          if (!bool) {}
        }
        else
        {
          tmp213_208 = this.Qb;
          tmp213_208[36] = ((short)(tmp213_208[36] + 1));
        }
      }
      i5 = 0;
      i2 = i3;
      if (!bool) {
        if (i4 == 0)
        {
          i6 = 138;
          i7 = 3;
          if (!bool) {
            break label280;
          }
        }
      }
      if (!bool)
      {
        if (i3 == i4)
        {
          i6 = 6;
          i7 = 3;
          if (!bool) {}
        }
        else
        {
          i6 = 7;
        }
      }
      else {
        i7 = 4;
      }
      i1++;
    } while (!bool);
    label280:
  }
  
  int e()
  {
    boolean bool = ZlibStream.v;
    b(this.Ob, this.Rb.x);
    b(this.Pb, this.Sb.x);
    this.Tb.b(this);
    int i1 = 18;
    do
    {
      if (i1 < 3) {
        break;
      }
      if (bool) {
        break label102;
      }
      if (this.Qb[(Tree.p[i1] * 2 + 1)] != 0) {
        break;
      }
      i1--;
    } while (!bool);
    this.dc += 3 * (i1 + 1) + 5 + 5 + 4;
    label102:
    return i1;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = ZlibStream.v;
    a(paramInt1 - 257, 5);
    a(paramInt2 - 1, 5);
    a(paramInt3 - 4, 4);
    int i1 = 0;
    do
    {
      if (i1 >= paramInt3) {
        break;
      }
      a(this.Qb[(Tree.p[i1] * 2 + 1)], 3);
      i1++;
      if (bool) {
        return;
      }
    } while (!bool);
    c(this.Ob, paramInt1 - 1);
    c(this.Pb, paramInt2 - 1);
  }
  
  void c(short[] paramArrayOfShort, int paramInt)
  {
    boolean bool = ZlibStream.v;
    int i2 = -1;
    int i4 = paramArrayOfShort[1];
    int i5 = 0;
    int i6 = 7;
    int i7 = 4;
    if (!bool) {
      if (i4 == 0)
      {
        i6 = 138;
        i7 = 3;
      }
    }
    int i1 = 0;
    label128:
    label232:
    do
    {
      if (i1 > paramInt) {
        break;
      }
      int i3 = i4;
      i4 = paramArrayOfShort[((i1 + 1) * 2 + 1)];
      i5++;
      if (!bool) {
        if (i5 < i6)
        {
          if (!bool) {
            if (i3 == i4) {
              break label293;
            }
          }
        }
        else {
          if (bool) {
            break label128;
          }
        }
      }
      if (i5 < i7)
      {
        do
        {
          a(i3, this.Qb);
          i5--;
        } while (i5 != 0);
      }
      else
      {
        if (!bool) {
          if (i3 != 0)
          {
            if (i3 != i2)
            {
              a(i3, this.Qb);
              i5--;
            }
            a(16, this.Qb);
            a(i5 - 3, 2);
            if (!bool) {
              break label232;
            }
          }
        }
        if (i5 <= 10)
        {
          a(17, this.Qb);
          a(i5 - 3, 3);
          if (!bool) {}
        }
        else
        {
          a(18, this.Qb);
          a(i5 - 11, 7);
        }
      }
      i5 = 0;
      i2 = i3;
      if (!bool) {
        if (i4 == 0)
        {
          i6 = 138;
          i7 = 3;
          if (!bool) {
            break label293;
          }
        }
      }
      if (!bool)
      {
        if (i3 == i4)
        {
          i6 = 6;
          i7 = 3;
          if (!bool) {}
        }
        else
        {
          i6 = 7;
        }
      }
      else {
        i7 = 4;
      }
      i1++;
    } while (!bool);
    label293:
  }
  
  final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(paramArrayOfByte, paramInt1, this.gb, this.jb, paramInt2);
    this.jb += paramInt2;
  }
  
  final void a(byte paramByte)
  {
    this.gb[(this.jb++)] = paramByte;
  }
  
  final void a(int paramInt)
  {
    a((byte)paramInt);
    a((byte)(paramInt >>> 8));
  }
  
  final void b(int paramInt)
  {
    a((byte)(paramInt >> 8));
    a((byte)paramInt);
  }
  
  final void a(int paramInt, short[] paramArrayOfShort)
  {
    a(paramArrayOfShort[(paramInt * 2)] & 0xFFFF, paramArrayOfShort[(paramInt * 2 + 1)] & 0xFFFF);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    boolean bool = ZlibStream.v;
    int i1 = paramInt2;
    if (!bool)
    {
      if (this.ic > 16 - i1)
      {
        int i2 = paramInt1;
        this.hc = ((short)(this.hc | i2 << this.ic & 0xFFFF));
        a(this.hc);
        this.hc = ((short)(i2 >>> 16 - this.ic));
        this.ic += i1 - 16;
        if (!bool) {}
      }
      else
      {
        this.hc = ((short)(this.hc | paramInt1 << this.ic & 0xFFFF));
      }
    }
    else {
      this.ic += i1;
    }
  }
  
  void f()
  {
    a(2, 3);
    a(256, StaticTree.h);
    h();
    if (!ZlibStream.v)
    {
      if (1 + this.gc + 10 - this.ic < 9)
      {
        a(2, 3);
        a(256, StaticTree.h);
        h();
      }
      this.gc = 7;
    }
  }
  
  boolean b(int paramInt1, int paramInt2)
  {
    boolean bool = ZlibStream.v;
    this.gb[(this.cc + this.bc * 2)] = ((byte)(paramInt1 >>> 8));
    this.gb[(this.cc + this.bc * 2 + 1)] = ((byte)paramInt1);
    this.gb[(this.Zb + this.bc)] = ((byte)paramInt2);
    this.bc += 1;
    if (!bool)
    {
      if (paramInt1 == 0)
      {
        int tmp88_87 = (paramInt2 * 2);
        short[] tmp88_82 = this.Ob;
        tmp88_82[tmp88_87] = ((short)(tmp88_82[tmp88_87] + 1));
        if (!bool) {}
      }
      else
      {
        this.fc += 1;
        paramInt1--;
        int tmp129_128 = ((Tree.t[paramInt2] + 256 + 1) * 2);
        short[] tmp129_113 = this.Ob;
        tmp129_113[tmp129_128] = ((short)(tmp129_113[tmp129_128] + 1));
      }
    }
    else
    {
      int tmp145_144 = (Tree.a(paramInt1) * 2);
      short[] tmp145_136 = this.Pb;
      tmp145_136[tmp145_144] = ((short)(tmp145_136[tmp145_144] + 1));
    }
    if (!bool) {
      if ((this.bc & 0x1FFF) == 0)
      {
        if (bool) {
          break label301;
        }
        if (this.Kb > 2)
        {
          int i1 = this.bc * 8;
          int i2 = this.Eb - this.Ab;
          int i3 = 0;
          do
          {
            if (i3 >= 30) {
              break;
            }
            i1 = (int)(i1 + this.Pb[(i3 * 2)] * (5L + Tree.n[i3]));
            i3++;
            if (bool) {
              break label253;
            }
          } while (!bool);
          i1 >>>= 3;
          label253:
          if (bool) {
            break label301;
          }
          if (this.fc < this.bc / 2)
          {
            if (bool) {
              break label301;
            }
            if (i1 < i2 / 2) {
              return true;
            }
          }
        }
      }
    }
    if (!bool) {}
    label301:
    return this.bc == this.ac - 1;
  }
  
  void a(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    boolean bool = ZlibStream.v;
    int i3 = 0;
    if (!bool)
    {
      if (this.bc != 0) {
        do
        {
          int i1 = this.gb[(this.cc + i3 * 2)] << 8 & 0xFF00 | this.gb[(this.cc + i3 * 2 + 1)] & 0xFF;
          int i2 = this.gb[(this.Zb + i3)] & 0xFF;
          i3++;
          if (i1 == 0)
          {
            a(i2, paramArrayOfShort1);
            if (!bool) {}
          }
          else
          {
            int i4 = Tree.t[i2];
            a(i4 + 256 + 1, paramArrayOfShort1);
            int i5 = Tree.m[i4];
            if (!bool)
            {
              if (i5 != 0)
              {
                i2 -= Tree.u[i4];
                a(i2, i5);
              }
              i1--;
              i4 = Tree.a(i1);
              a(i4, paramArrayOfShort2);
              i5 = Tree.n[i4];
            }
            if (bool) {
              continue;
            }
            if (i5 != 0)
            {
              i1 -= Tree.v[i4];
              a(i1, i5);
            }
          }
        } while (i3 < this.bc);
      }
      a(256, paramArrayOfShort1);
    }
    this.gc = paramArrayOfShort1[513];
  }
  
  void g()
  {
    boolean bool = ZlibStream.v;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    do
    {
      if (i1 >= 7) {
        break;
      }
      i3 += this.Ob[(i1 * 2)];
      i1++;
      if (bool) {
        break label72;
      }
    } while (!bool);
    do
    {
      if (i1 >= 128) {
        break;
      }
      i2 += this.Ob[(i1 * 2)];
      i1++;
      if (bool) {
        break label103;
      }
    } while (!bool);
    label72:
    do
    {
      if (i1 >= 256) {
        break;
      }
      i3 += this.Ob[(i1 * 2)];
      i1++;
      if (bool) {
        return;
      }
    } while (!bool);
    label103:
    if (!bool) {}
    this.lb = ((byte)(i3 > i2 >>> 2 ? 0 : 1));
  }
  
  void h()
  {
    boolean bool = ZlibStream.v;
    if (!bool)
    {
      if (this.ic == 16)
      {
        a(this.hc);
        this.hc = 0;
        this.ic = 0;
        if (!bool) {
          return;
        }
      }
      if (bool) {}
    }
    else
    {
      if (this.ic < 8) {
        return;
      }
      a((byte)this.hc);
      this.hc = ((short)(this.hc >>> 8));
    }
    this.ic -= 8;
  }
  
  void i()
  {
    boolean bool = ZlibStream.v;
    if (!bool)
    {
      if (this.ic > 8)
      {
        a(this.hc);
        if (!bool) {}
      }
      else
      {
        if (bool) {
          break label55;
        }
      }
    }
    else if (this.ic > 0) {
      a((byte)this.hc);
    }
    this.hc = 0;
    label55:
    this.ic = 0;
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = 0;
    i();
    this.gc = 8;
    if (!ZlibStream.v)
    {
      if (paramBoolean)
      {
        a((short)paramInt2);
        a((short)(paramInt2 ^ 0xFFFFFFFF));
      }
      a(this.rb, paramInt1, paramInt2);
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (!ZlibStream.v) {}
    c(this.Ab >= 0 ? this.Ab : -1, this.Eb - this.Ab, paramBoolean);
    this.Ab = this.Eb;
    this.a.b();
  }
  
  int c(int paramInt)
  {
    boolean bool = ZlibStream.v;
    int i1 = 65535;
    if (!bool) {
      if (i1 > this.hb - 5) {
        i1 = this.hb - 5;
      }
    }
    label69:
    do
    {
      if (this.Gb <= 1)
      {
        j();
        if (!bool) {
          if (this.Gb == 0)
          {
            if (bool) {
              break label69;
            }
            if (paramInt == 0) {
              return 0;
            }
          }
        }
        if (!bool) {
          if (this.Gb == 0) {
            break;
          }
        }
      }
      else
      {
        this.Eb += this.Gb;
        this.Gb = 0;
      }
      int i2 = this.Ab + i1;
      do
      {
        if (!bool)
        {
          if (this.Eb != 0)
          {
            if (bool) {
              break label184;
            }
            if (this.Eb < i2) {}
          }
          else
          {
            this.Gb = (this.Eb - i2);
            this.Eb = i2;
            a(false);
          }
        }
        else
        {
          if (bool) {
            break label176;
          }
          if (this.a.availOut == 0) {
            return 0;
          }
        }
        if (this.Eb - this.Ab < this.ob - 262) {
          break;
        }
        a(false);
      } while (bool);
    } while ((!bool) && (this.a.availOut != 0));
    label176:
    label184:
    return 0;
    if (!bool) {}
    a(paramInt == 4);
    if (!bool) {
      if (this.a.availOut == 0)
      {
        if (!bool) {}
        return paramInt == 4 ? 2 : 0;
      }
    }
    if (!bool) {}
    return paramInt == 4 ? 3 : 1;
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!ZlibStream.v) {}
    a(0 + (paramBoolean ? 1 : 0), 3);
    a(paramInt1, paramInt2, true);
  }
  
  void c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = ZlibStream.v;
    int i3 = 0;
    int i2;
    if (!bool) {
      if (this.Kb > 0)
      {
        if (!bool)
        {
          if (this.lb == 2) {
            g();
          }
          this.Rb.b(this);
          this.Sb.b(this);
          i3 = e();
        }
        i1 = this.dc + 3 + 7 >>> 3;
        i2 = this.ec + 3 + 7 >>> 3;
        if (bool) {
          break label119;
        }
        if (i2 > i1) {
          break label114;
        }
        i1 = i2;
        if (!bool) {
          break label114;
        }
      }
    }
    int i1 = i2 = paramInt2 + 5;
    label114:
    label119:
    if (!bool) {
      if (paramInt2 + 4 <= i1)
      {
        if (bool) {
          break label153;
        }
        if (paramInt1 != -1)
        {
          b(paramInt1, paramInt2, paramBoolean);
          if (!bool) {
            break label251;
          }
        }
      }
    }
    if (i2 == i1)
    {
      label153:
      if (!bool) {}
      a(2 + (paramBoolean ? 1 : 0), 3);
      a(StaticTree.h, StaticTree.i);
      if (!bool) {}
    }
    else
    {
      if (!bool) {}
      a(4 + (paramBoolean ? 1 : 0), 3);
      a(this.Rb.x + 1, this.Sb.x + 1, i3 + 1);
      a(this.Ob, this.Pb);
    }
    label251:
    if (!bool)
    {
      d();
      if (!paramBoolean) {}
    }
    else
    {
      i();
    }
  }
  
  void j()
  {
    boolean bool = ZlibStream.v;
    int i4 = this.sb - this.Gb - this.Eb;
    if (i4 == 0)
    {
      if (bool) {
        break label63;
      }
      if (this.Eb == 0)
      {
        if (bool) {
          break label63;
        }
        if (this.Gb == 0)
        {
          i4 = this.ob;
          if (!bool) {
            break label287;
          }
        }
      }
    }
    label63:
    if (!bool) {
      if (i4 == -1)
      {
        i4--;
        if (!bool) {
          break label287;
        }
      }
    }
    label287:
    do
    {
      if (!bool) {
        if (this.Eb >= this.ob + this.ob - 262)
        {
          System.arraycopy(this.rb, this.ob, this.rb, 0, this.ob);
          this.Fb -= this.ob;
          this.Eb -= this.ob;
          this.Ab -= this.ob;
          i1 = this.wb;
          int i3 = i1;
          int i2 = this.ub[(--i3)] & 0xFFFF;
          this.ub[i3] = (i2 >= this.ob ? (short)(i2 - this.ob) : 0);
          i1--;
          do
          {
            if (i1 != 0) {
              break;
            }
            i1 = this.ob;
          } while (bool);
          i3 = i1;
          i2 = this.tb[(--i3)] & 0xFFFF;
          this.tb[i3] = (i2 >= this.ob ? (short)(i2 - this.ob) : 0);
          i1--;
          do
          {
            if (i1 != 0) {
              break;
            }
          } while (bool);
          i4 += this.ob;
        }
      }
      if (!bool) {
        if (this.a.availIn == 0) {
          return;
        }
      }
      int i1 = this.a.a(this.rb, this.Eb + this.Gb, i4);
      this.Gb += i1;
      if (!bool) {
        if (this.Gb >= 3)
        {
          this.vb = (this.rb[this.Eb] & 0xFF);
          this.vb = ((this.vb << this.zb ^ this.rb[(this.Eb + 1)] & 0xFF) & this.yb);
        }
      }
      if ((bool) || (this.Gb < 262)) {
        if (this.a.availIn != 0) {
          break;
        }
      }
    } while (bool);
  }
  
  int d(int paramInt)
  {
    boolean bool2 = ZlibStream.v;
    int i1 = 0;
    label51:
    label228:
    do
    {
      if (this.Gb < 262)
      {
        j();
        if (!bool2) {
          if (this.Gb < 262)
          {
            if (bool2) {
              break label51;
            }
            if (paramInt == 0) {
              return 0;
            }
          }
        }
        if ((!bool2) && (this.Gb == 0)) {
          break;
        }
      }
      do
      {
        if (!bool2) {
          if (this.Gb >= 3)
          {
            this.vb = ((this.vb << this.zb ^ this.rb[(this.Eb + 2)] & 0xFF) & this.yb);
            i1 = this.ub[this.vb] & 0xFFFF;
            this.tb[(this.Eb & this.qb)] = this.ub[this.vb];
            this.ub[this.vb] = ((short)this.Eb);
          }
        }
        if (!bool2) {
          if (i1 != 0L)
          {
            if (bool2) {
              break label228;
            }
            if ((this.Eb - i1 & 0xFFFF) <= this.ob - 262)
            {
              if (bool2) {
                break label228;
              }
              if (this.Lb != 2) {
                this.Bb = f(i1);
              }
            }
          }
        }
        if (!bool2) {
          if (this.Bb >= 3)
          {
            bool1 = b(this.Eb - this.Fb, this.Bb - 3);
            this.Gb -= this.Bb;
            if (!bool2)
            {
              if (this.Bb <= this.Jb)
              {
                if (bool2) {
                  break label467;
                }
                if (this.Gb >= 3)
                {
                  this.Bb -= 1;
                  do
                  {
                    while (--this.Bb != 0)
                    {
                      this.Eb += 1;
                      this.vb = ((this.vb << this.zb ^ this.rb[(this.Eb + 2)] & 0xFF) & this.yb);
                      i1 = this.ub[this.vb] & 0xFFFF;
                      this.tb[(this.Eb & this.qb)] = this.ub[this.vb];
                      this.ub[this.vb] = ((short)this.Eb);
                    }
                    this.Eb += 1;
                  } while (bool2);
                  if (!bool2) {
                    break label544;
                  }
                }
              }
              this.Eb += this.Bb;
              this.Bb = 0;
              this.vb = (this.rb[this.Eb] & 0xFF);
            }
            this.vb = ((this.vb << this.zb ^ this.rb[(this.Eb + 1)] & 0xFF) & this.yb);
            if (!bool2) {
              break label544;
            }
          }
        }
        boolean bool1 = b(0, this.rb[this.Eb] & 0xFF);
        this.Gb -= 1;
        this.Eb += 1;
        if (!bool1) {
          break;
        }
        a(false);
      } while (bool2);
    } while ((!bool2) && (this.a.availOut != 0));
    label467:
    return 0;
    label544:
    if (!bool2) {}
    a(paramInt == 4);
    if (!bool2) {
      if (this.a.availOut == 0)
      {
        if (!bool2) {
          if (paramInt == 4) {
            return 2;
          }
        }
        return 0;
      }
    }
    if (!bool2) {}
    return paramInt == 4 ? 3 : 1;
  }
  
  int e(int paramInt)
  {
    boolean bool2 = ZlibStream.v;
    int i1 = 0;
    label56:
    label77:
    boolean bool1;
    label186:
    label321:
    label331:
    label594:
    do
    {
      do
      {
        do
        {
          if (this.Gb < 262)
          {
            j();
            if (!bool2)
            {
              if (bool2) {
                break label77;
              }
              if (this.Gb < 262)
              {
                if (bool2) {
                  break label56;
                }
                if (paramInt == 0) {
                  return 0;
                }
              }
            }
            if ((!bool2) && (this.Gb == 0)) {
              break label699;
            }
          }
          else
          {
            if (bool2) {
              break label186;
            }
          }
          if (this.Gb >= 3)
          {
            this.vb = ((this.vb << this.zb ^ this.rb[(this.Eb + 2)] & 0xFF) & this.yb);
            i1 = this.ub[this.vb] & 0xFFFF;
            this.tb[(this.Eb & this.qb)] = this.ub[this.vb];
            this.ub[this.vb] = ((short)this.Eb);
          }
          this.Hb = this.Bb;
          this.Cb = this.Fb;
          this.Bb = 2;
          if (!bool2) {
            if (i1 != 0)
            {
              if (bool2) {
                break label331;
              }
              if (this.Hb < this.Jb)
              {
                if (bool2) {
                  break label331;
                }
                if ((this.Eb - i1 & 0xFFFF) <= this.ob - 262)
                {
                  if (!bool2) {
                    if (this.Lb != 2) {
                      this.Bb = f(i1);
                    }
                  }
                  if (bool2) {
                    break label331;
                  }
                  if (this.Bb <= 5)
                  {
                    if (!bool2) {
                      if (this.Lb != 1)
                      {
                        if (bool2) {
                          break label331;
                        }
                        if (this.Bb != 3) {
                          break label321;
                        }
                        if (bool2) {
                          break label331;
                        }
                        if (this.Eb - this.Fb <= 4096) {
                          break label321;
                        }
                      }
                    }
                    this.Bb = 2;
                  }
                }
              }
            }
          }
          if (bool2) {
            break label594;
          }
          if (this.Hb < 3) {
            break;
          }
          if (bool2) {
            break label594;
          }
          if (this.Bb > this.Hb) {
            break;
          }
          int i2 = this.Eb + this.Gb - 3;
          bool1 = b(this.Eb - 1 - this.Cb, this.Hb - 3);
          this.Gb -= this.Hb - 1;
          this.Hb -= 2;
          if (++this.Eb <= i2)
          {
            this.vb = ((this.vb << this.zb ^ this.rb[(this.Eb + 2)] & 0xFF) & this.yb);
            i1 = this.ub[this.vb] & 0xFFFF;
            this.tb[(this.Eb & this.qb)] = this.ub[this.vb];
            this.ub[this.vb] = ((short)this.Eb);
          }
          do
          {
            if (--this.Hb != 0) {
              break;
            }
            this.Db = 0;
            this.Bb = 2;
            this.Eb += 1;
          } while (bool2);
          if (!bool2)
          {
            if (bool1) {
              a(false);
            }
          }
          else if ((bool2) || (this.a.availOut == 0)) {
            return 0;
          }
        } while (!bool2);
        if (bool2) {
          break label685;
        }
        if (this.Db == 0) {
          break;
        }
        bool1 = b(0, this.rb[(this.Eb - 1)] & 0xFF);
        if (!bool2)
        {
          if (bool1) {
            a(false);
          }
          this.Eb += 1;
          this.Gb -= 1;
        }
      } while ((!bool2) && (this.a.availOut != 0));
      return 0;
      this.Db = 1;
      this.Eb += 1;
      this.Gb -= 1;
    } while (!bool2);
    label685:
    label699:
    if (!bool2) {
      if (this.Db != 0)
      {
        bool1 = b(0, this.rb[(this.Eb - 1)] & 0xFF);
        this.Db = 0;
      }
    }
    if (!bool2) {}
    a(paramInt == 4);
    if (!bool2) {
      if (this.a.availOut == 0)
      {
        if (!bool2) {
          if (paramInt == 4) {
            return 2;
          }
        }
        return 0;
      }
    }
    if (!bool2) {}
    return paramInt == 4 ? 3 : 1;
  }
  
  int f(int paramInt)
  {
    boolean bool = ZlibStream.v;
    int i1 = this.Ib;
    int i2 = this.Eb;
    int i5 = this.Hb;
    int i6 = (bool) || (this.Eb > this.ob - 262) ? this.Eb - (this.ob - 262) : 0;
    int i7 = this.Nb;
    int i8 = this.qb;
    int i9 = this.Eb + 258;
    int i10 = this.rb[(i2 + i5 - 1)];
    int i11 = this.rb[(i2 + i5)];
    if (!bool)
    {
      if (this.Hb >= this.Mb) {
        i1 >>= 2;
      }
      if (bool) {}
    }
    else if (i7 > this.Gb)
    {
      i7 = this.Gb;
    }
    int i3 = paramInt;
    if (this.rb[(i3 + i5)] == i11)
    {
      if (bool) {
        break label552;
      }
      if (this.rb[(i3 + i5 - 1)] == i10)
      {
        if (bool) {
          break label552;
        }
        if ((this.rb[i3] == this.rb[i2]) && (this.rb[(++i3)] == this.rb[(i2 + 1)]))
        {
          i2 += 2;
          i3++;
          int i4;
          do
          {
            do
            {
              if (this.rb[(++i2)] != this.rb[(++i3)]) {
                break;
              }
            } while ((!bool) && ((this.rb[(++i2)] == this.rb[(++i3)]) && ((!bool) && ((this.rb[(++i2)] == this.rb[(++i3)]) && ((!bool) && ((this.rb[(++i2)] == this.rb[(++i3)]) && ((!bool) && ((this.rb[(++i2)] == this.rb[(++i3)]) && ((!bool) && ((this.rb[(++i2)] == this.rb[(++i3)]) && ((!bool) && ((this.rb[(++i2)] == this.rb[(++i3)]) && ((!bool) && ((this.rb[(++i2)] == this.rb[(++i3)]) && (i2 < i9)))))))))))))));
            i4 = 258 - (i9 - i2);
            i2 = i9 - 258;
          } while (bool);
          if (bool) {
            break label552;
          }
          if (i4 > i5)
          {
            this.Fb = paramInt;
            i5 = i4;
            if (!bool)
            {
              if (i4 >= i7) {
                break label567;
              }
              i10 = this.rb[(i2 + i5 - 1)];
            }
            i11 = this.rb[(i2 + i5)];
          }
        }
      }
    }
    label552:
    label567:
    do
    {
      if (bool) {
        break label583;
      }
      if ((paramInt = this.tb[(paramInt & i8)] & 0xFFFF) > i6)
      {
        i1--;
        if (i1 != 0) {
          break;
        }
      }
      if (bool) {
        break label593;
      }
    } while (bool);
    if (i5 <= this.Gb) {
      label583:
      return i5;
    }
    label593:
    return this.Gb;
  }
  
  int a(ZlibStream paramZlibStream, int paramInt1, int paramInt2)
  {
    return a(paramZlibStream, paramInt1, 8, paramInt2, 8, 0);
  }
  
  int a(ZlibStream paramZlibStream, int paramInt)
  {
    return a(paramZlibStream, paramInt, 15);
  }
  
  int a(ZlibStream paramZlibStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = ZlibStream.v;
    int i1 = 0;
    paramZlibStream.msg = null;
    if (!bool) {
      if (paramInt1 == -1) {
        paramInt1 = 6;
      }
    }
    if (!bool) {
      if (paramInt3 < 0)
      {
        i1 = 1;
        paramInt3 = -paramInt3;
      }
    }
    if (!bool) {
      if (paramInt4 >= 1)
      {
        if (bool) {
          break label145;
        }
        if (paramInt4 <= 9)
        {
          if (bool) {
            break label145;
          }
          if (paramInt2 == 8)
          {
            if (bool) {
              break label145;
            }
            if (paramInt3 >= 9)
            {
              if (bool) {
                break label145;
              }
              if (paramInt3 <= 15)
              {
                if (bool) {
                  break label145;
                }
                if (paramInt1 >= 0)
                {
                  if (bool) {
                    break label145;
                  }
                  if (paramInt1 <= 9)
                  {
                    if (bool) {
                      break label145;
                    }
                    if (paramInt5 >= 0)
                    {
                      if (bool) {
                        break label333;
                      }
                      if (paramInt5 <= 2) {
                        break label146;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label145:
    return -2;
    label146:
    paramZlibStream.r = this;
    this.kb = i1;
    this.pb = paramInt3;
    this.ob = (1 << this.pb);
    this.qb = (this.ob - 1);
    this.xb = (paramInt4 + 7);
    this.wb = (1 << this.xb);
    this.yb = (this.wb - 1);
    this.zb = ((this.xb + 3 - 1) / 3);
    this.rb = new byte[this.ob * 2];
    this.tb = new short[this.ob];
    this.ub = new short[this.wb];
    this.ac = (1 << paramInt4 + 6);
    this.gb = new byte[this.ac * 4];
    this.hb = (this.ac * 4);
    this.cc = (this.ac / 2);
    this.Zb = (3 * this.ac);
    this.Kb = paramInt1;
    this.Lb = paramInt5;
    this.mb = ((byte)paramInt2);
    label333:
    return a(paramZlibStream);
  }
  
  int a(ZlibStream paramZlibStream)
  {
    boolean bool = ZlibStream.v;
    paramZlibStream.totalIn = (paramZlibStream.totalOut = 0L);
    paramZlibStream.msg = null;
    paramZlibStream.t = 2;
    this.jb = 0;
    this.ib = 0;
    if (!bool) {
      if (this.kb < 0) {
        this.kb = 0;
      }
    }
    if (!bool) {}
    this.fb = (this.kb != 0 ? 113 : 42);
    paramZlibStream.adler = paramZlibStream.u.a(0L, null, 0, 0);
    this.nb = 0;
    c();
    b();
    return 0;
  }
  
  int k()
  {
    boolean bool = ZlibStream.v;
    if (!bool)
    {
      if (this.fb != 42)
      {
        if (bool) {
          break label77;
        }
        if (this.fb != 113)
        {
          if (bool) {
            break label77;
          }
          if (this.fb != 666) {
            return -2;
          }
        }
      }
      this.gb = null;
      this.ub = null;
      this.tb = null;
      this.rb = null;
      if (bool) {
        break label82;
      }
    }
    label77:
    label82:
    return this.fb == 113 ? -3 : 0;
  }
  
  int b(ZlibStream paramZlibStream, int paramInt1, int paramInt2)
  {
    boolean bool = ZlibStream.v;
    int i1 = 0;
    if (!bool) {
      if (paramInt1 == -1) {
        paramInt1 = 6;
      }
    }
    if (!bool) {
      if (paramInt1 >= 0)
      {
        if (bool) {
          break label62;
        }
        if (paramInt1 <= 9)
        {
          if (bool) {
            break label62;
          }
          if (paramInt2 >= 0)
          {
            if (bool) {
              break label82;
            }
            if (paramInt2 <= 2) {
              break label63;
            }
          }
        }
      }
    }
    label62:
    return -2;
    label63:
    label82:
    if (!bool)
    {
      if (i[this.Kb].e != i[paramInt1].e)
      {
        if (bool) {
          break label115;
        }
        if (paramZlibStream.totalIn != 0L) {
          i1 = paramZlibStream.deflate(1);
        }
      }
      label115:
      if (bool) {}
    }
    else
    {
      if (this.Kb != paramInt1)
      {
        this.Kb = paramInt1;
        this.Jb = i[this.Kb].b;
        this.Mb = i[this.Kb].a;
        this.Nb = i[this.Kb].c;
        this.Ib = i[this.Kb].d;
      }
      this.Lb = paramInt2;
    }
    return i1;
  }
  
  int a(ZlibStream paramZlibStream, byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = ZlibStream.v;
    int i1 = paramInt;
    int i2 = 0;
    if (paramArrayOfByte != null)
    {
      if (bool) {
        break label53;
      }
      if (this.fb == 42) {}
    }
    else
    {
      return -2;
    }
    paramZlibStream.adler = paramZlibStream.u.a(paramZlibStream.adler, paramArrayOfByte, 0, paramInt);
    label53:
    if (!bool)
    {
      if (i1 < 3) {
        return 0;
      }
      if (bool) {}
    }
    else
    {
      if (i1 > this.ob - 262)
      {
        i1 = this.ob - 262;
        i2 = paramInt - i1;
      }
      System.arraycopy(paramArrayOfByte, i2, this.rb, 0, i1);
      this.Eb = i1;
      this.Ab = i1;
      this.vb = (this.rb[0] & 0xFF);
      this.vb = ((this.vb << this.zb ^ this.rb[1] & 0xFF) & this.yb);
    }
    int i3 = 0;
    do
    {
      if (i3 > i1 - 3) {
        break;
      }
      this.vb = ((this.vb << this.zb ^ this.rb[(i3 + 2)] & 0xFF) & this.yb);
      this.tb[(i3 & this.qb)] = this.ub[this.vb];
      this.ub[this.vb] = ((short)i3);
      i3++;
    } while (!bool);
    return 0;
  }
  
  int b(ZlibStream paramZlibStream, int paramInt)
  {
    boolean bool = ZlibStream.v;
    if ((bool) || ((paramInt > 4) || ((bool) || (paramInt < 0)))) {
      return -2;
    }
    if (!bool) {
      if (paramZlibStream.nextOut != null) {
        if ((bool) || (paramZlibStream.nextIn == null))
        {
          if (bool) {
            break label99;
          }
          if (paramZlibStream.availIn != 0) {}
        }
        else
        {
          if (bool) {
            break label104;
          }
          if (this.fb != 666) {
            break label100;
          }
          if (bool) {
            break label104;
          }
          if (paramInt == 4) {
            break label100;
          }
        }
      }
    }
    paramZlibStream.msg = j[4];
    label99:
    return -2;
    label100:
    label104:
    if (!bool)
    {
      if (paramZlibStream.availOut == 0)
      {
        paramZlibStream.msg = j[7];
        return -5;
      }
      this.a = paramZlibStream;
    }
    int i1 = this.nb;
    this.nb = paramInt;
    int i3;
    if (!bool) {
      if (this.fb == 42)
      {
        i2 = 8 + (this.pb - 8 << 4) << 8;
        i3 = (this.Kb - 1 & 0xFF) >> 1;
        if (!bool) {
          if (i3 > 3) {
            i3 = 3;
          }
        }
        i2 |= i3 << 6;
        if (!bool)
        {
          if (this.Eb != 0) {
            i2 |= 0x20;
          }
          i2 += 31 - i2 % 31;
          this.fb = 113;
          b(i2);
          if (bool) {}
        }
        else
        {
          if (this.Eb == 0) {
            break label290;
          }
          b((int)(paramZlibStream.adler >>> 16));
        }
        b((int)(paramZlibStream.adler & 0xFFFF));
        label290:
        paramZlibStream.adler = paramZlibStream.u.a(0L, null, 0, 0);
      }
    }
    if (!bool) {
      if (this.jb != 0)
      {
        paramZlibStream.b();
        if (bool) {
          break label389;
        }
        if (paramZlibStream.availOut != 0) {
          break label385;
        }
        this.nb = -1;
        return 0;
      }
    }
    if (!bool) {
      if (paramZlibStream.availIn == 0)
      {
        if (bool) {
          break label397;
        }
        if (paramInt <= i1)
        {
          if (bool) {
            break label397;
          }
          if (paramInt != 4)
          {
            paramZlibStream.msg = j[7];
            return -5;
          }
        }
      }
    }
    label385:
    label389:
    if (!bool) {
      if (this.fb == 666)
      {
        label397:
        if (bool) {
          break label429;
        }
        if (paramZlibStream.availIn != 0)
        {
          paramZlibStream.msg = j[7];
          return -5;
        }
      }
    }
    label429:
    if (!bool) {
      if (paramZlibStream.availIn == 0)
      {
        if (bool) {
          break label474;
        }
        if (this.Gb == 0)
        {
          if (bool) {
            break label727;
          }
          if (paramInt == 0) {
            break label726;
          }
          if (bool) {
            break label733;
          }
          if (this.fb == 666) {
            break label726;
          }
        }
      }
    }
    label474:
    int i2 = -1;
    if (!bool) {
      switch (i[this.Kb].e)
      {
      case 0: 
        i2 = c(paramInt);
        if (!bool) {
          break;
        }
      case 1: 
        i2 = d(paramInt);
        if (!bool) {
          break;
        }
      case 2: 
        i2 = e(paramInt);
        break;
      }
    }
    if (!bool)
    {
      if (i2 != 2) {
        if (bool) {
          break label585;
        }
      }
    }
    else {
      if (i2 != 3) {
        break label583;
      }
    }
    this.fb = 666;
    label583:
    label585:
    if (!bool) {
      if (i2 != 0)
      {
        if (bool) {
          break label626;
        }
        if (i2 != 2) {
          break label623;
        }
      }
    }
    if (!bool) {
      if (paramZlibStream.availOut == 0) {
        this.nb = -1;
      }
    }
    return 0;
    label623:
    label626:
    if (!bool)
    {
      if (i2 == 1)
      {
        if (!bool)
        {
          if (paramInt == 1)
          {
            f();
            if (!bool) {}
          }
          else
          {
            b(0, 0, false);
            if (bool) {
              break label711;
            }
          }
        }
        else if (paramInt == 3)
        {
          i3 = 0;
          do
          {
            if (i3 >= this.wb) {
              break;
            }
            this.ub[i3] = 0;
            i3++;
            if (bool) {
              break label707;
            }
          } while (!bool);
        }
        paramZlibStream.b();
        if (bool) {
          break label727;
        }
        if (paramZlibStream.availOut == 0)
        {
          this.nb = -1;
          return 0;
        }
      }
      if (bool) {}
    }
    else if (paramInt != 4)
    {
      return 0;
    }
    label707:
    label711:
    label726:
    label727:
    label733:
    if (!bool)
    {
      if (this.kb != 0) {
        return 1;
      }
      b((int)(paramZlibStream.adler >>> 16));
      b((int)(paramZlibStream.adler & 0xFFFF));
      paramZlibStream.b();
      this.kb = -1;
    }
    if (!bool) {}
    return this.jb != 0 ? 0 : 1;
  }
  
  static
  {
    break label144;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.compression.zlib.ZlibDeflater
 * JD-Core Version:    0.7.0.1
 */