package com.jscape.inet.ssh.transport.compression.zlib;

import com.jscape.util.u;

final class Tree
{
  private static final int a = 15;
  private static final int b = 19;
  private static final int c = 30;
  private static final int d = 256;
  private static final int e = 29;
  private static final int f = 286;
  private static final int g = 573;
  static final int h = 7;
  static final int i = 256;
  static final int j = 16;
  static final int k = 17;
  static final int l = 18;
  static final int[] m = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0 };
  static final int[] n = { 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13 };
  static final int[] o = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 7 };
  static final byte[] p = { 16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15 };
  static final int q = 16;
  static final int r = 512;
  static final byte[] s = { 0, 1, 2, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0, 0, 16, 17, 18, 18, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29 };
  static final byte[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28 };
  static final int[] u = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 16, 20, 24, 28, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 0 };
  static final int[] v = { 0, 1, 2, 3, 4, 6, 8, 12, 16, 24, 32, 48, 64, 96, 128, 192, 256, 384, 512, 768, 1024, 1536, 2048, 3072, 4096, 6144, 8192, 12288, 16384, 24576 };
  short[] w;
  int x;
  StaticTree y;
  
  static int a(int paramInt)
  {
    if (!ZlibStream.v) {}
    return paramInt < 256 ? s[paramInt] : s[(256 + (paramInt >>> 7))];
  }
  
  void a(ZlibDeflater paramZlibDeflater)
  {
    boolean bool = ZlibStream.v;
    short[] arrayOfShort1 = this.w;
    short[] arrayOfShort2 = this.y.m;
    int[] arrayOfInt = this.y.n;
    int i1 = this.y.o;
    int i2 = this.y.q;
    int i9 = 0;
    int i6 = 0;
    do
    {
      if (i6 > 15) {
        break;
      }
      paramZlibDeflater.Ub[i6] = 0;
      i6++;
      if (bool) {
        break label95;
      }
    } while (!bool);
    arrayOfShort1[(paramZlibDeflater.Vb[paramZlibDeflater.Xb] * 2 + 1)] = 0;
    label95:
    int i3 = paramZlibDeflater.Xb + 1;
    int i4;
    label284:
    do
    {
      if (i3 >= 573) {
        break;
      }
      i4 = paramZlibDeflater.Vb[i3];
      i6 = arrayOfShort1[(arrayOfShort1[(i4 * 2 + 1)] * 2 + 1)] + 1;
      if (bool) {
        break label306;
      }
      if (!bool)
      {
        if (i6 > i2)
        {
          i6 = i2;
          i9++;
        }
        arrayOfShort1[(i4 * 2 + 1)] = ((short)i6);
        if (bool) {}
      }
      else
      {
        if (i4 > this.x) {
          break label284;
        }
        tmp196_194 = i6;
        tmp196_191 = paramZlibDeflater.Ub;
        tmp196_191[tmp196_194] = ((short)(tmp196_191[tmp196_194] + 1));
      }
      int i7 = 0;
      if (!bool) {
        if (i4 >= i1) {
          i7 = arrayOfInt[(i4 - i1)];
        }
      }
      int i8 = arrayOfShort1[(i4 * 2)];
      paramZlibDeflater.dc += i8 * (i6 + i7);
      if (!bool)
      {
        if (arrayOfShort2 != null) {
          paramZlibDeflater.ec += i8 * (arrayOfShort2[(i4 * 2 + 1)] + i7);
        }
        i3++;
      }
    } while (!bool);
    if (!bool) {
      if (i9 == 0) {
        return;
      }
    }
    label306:
    i6 = i2 - 1;
    label373:
    do
    {
      do
      {
        if (paramZlibDeflater.Ub[i6] != 0) {
          break;
        }
        i6--;
        if (bool) {
          break label373;
        }
      } while (!bool);
      tmp338_336 = i6;
      tmp338_333 = paramZlibDeflater.Ub;
      tmp338_333[tmp338_336] = ((short)(tmp338_333[tmp338_336] - 1));
      tmp352_351 = (i6 + 1);
      tmp352_345 = paramZlibDeflater.Ub;
      tmp352_345[tmp352_351] = ((short)(tmp352_345[tmp352_351] + 2));
      tmp364_362 = i2;
      tmp364_359 = paramZlibDeflater.Ub;
      tmp364_359[tmp364_362] = ((short)(tmp364_359[tmp364_362] - 1));
      i9 -= 2;
      if (i9 > 0) {
        break;
      }
    } while (bool);
    i6 = i2;
    label455:
    label509:
    do
    {
      if (i6 == 0) {
        break;
      }
      i4 = paramZlibDeflater.Ub[i6];
      do
      {
        int i5;
        do
        {
          if (i4 == 0) {
            break label509;
          }
          i5 = paramZlibDeflater.Vb[(--i3)];
          if (bool) {
            break;
          }
          if (bool) {
            break label455;
          }
        } while (i5 > this.x);
        if (!bool)
        {
          if (arrayOfShort1[(i5 * 2 + 1)] != i6)
          {
            tmp459_458 = paramZlibDeflater;
            tmp459_458.dc = ((int)(tmp459_458.dc + (i6 - arrayOfShort1[(i5 * 2 + 1)]) * arrayOfShort1[(i5 * 2)]));
          }
        }
        else {
          arrayOfShort1[(i5 * 2 + 1)] = ((short)i6);
        }
        i4--;
      } while (!bool);
      i6--;
    } while (!bool);
  }
  
  void b(ZlibDeflater paramZlibDeflater)
  {
    boolean bool = ZlibStream.v;
    short[] arrayOfShort1 = this.w;
    short[] arrayOfShort2 = this.y.m;
    int i1 = this.y.p;
    int i4 = -1;
    paramZlibDeflater.Wb = 0;
    paramZlibDeflater.Xb = 573;
    int i2 = 0;
    label128:
    do
    {
      if (i2 >= i1) {
        break;
      }
      if (!bool)
      {
        if (bool) {
          break label140;
        }
        if (arrayOfShort1[(i2 * 2)] != 0)
        {
          tmp88_86 = i2;
          i4 = tmp88_86;
          paramZlibDeflater.Vb[(++paramZlibDeflater.Wb)] = tmp88_86;
          paramZlibDeflater.Yb[i2] = 0;
          if (!bool) {
            break label128;
          }
          u.a = !u.a;
        }
      }
      arrayOfShort1[(i2 * 2 + 1)] = 0;
      i2++;
    } while (!bool);
    label140:
    do
    {
      do
      {
        if (paramZlibDeflater.Wb >= 2) {
          break;
        }
        if (!bool) {}
        i5 = paramZlibDeflater.Vb[(++paramZlibDeflater.Wb)] = i4 < 2 ? ++i4 : 0;
        arrayOfShort1[(i5 * 2)] = 1;
        paramZlibDeflater.Yb[i5] = 0;
        paramZlibDeflater.dc -= 1;
      } while (arrayOfShort2 == null);
      paramZlibDeflater.ec -= arrayOfShort2[(i5 * 2 + 1)];
      if (bool) {
        break label245;
      }
    } while (!bool);
    this.x = i4;
    label245:
    i2 = paramZlibDeflater.Wb / 2;
    do
    {
      if (i2 < 1) {
        break;
      }
      paramZlibDeflater.a(arrayOfShort1, i2);
      i2--;
    } while (!bool);
    int i5 = i1;
    do
    {
      while (paramZlibDeflater.Wb >= 2)
      {
        i2 = paramZlibDeflater.Vb[1];
        paramZlibDeflater.Vb[1] = paramZlibDeflater.Vb[(paramZlibDeflater.Wb--)];
        paramZlibDeflater.a(arrayOfShort1, 1);
        int i3 = paramZlibDeflater.Vb[1];
        paramZlibDeflater.Vb[(--paramZlibDeflater.Xb)] = i2;
        paramZlibDeflater.Vb[(--paramZlibDeflater.Xb)] = i3;
        arrayOfShort1[(i5 * 2)] = ((short)(arrayOfShort1[(i2 * 2)] + arrayOfShort1[(i3 * 2)]));
        paramZlibDeflater.Yb[i5] = ((byte)(Math.max(paramZlibDeflater.Yb[i2], paramZlibDeflater.Yb[i3]) + 1));
        short tmp422_421 = ((short)i5);
        arrayOfShort1[(i3 * 2 + 1)] = tmp422_421;
        arrayOfShort1[(i2 * 2 + 1)] = tmp422_421;
        paramZlibDeflater.Vb[1] = (i5++);
        paramZlibDeflater.a(arrayOfShort1, 1);
      }
      paramZlibDeflater.Vb[(--paramZlibDeflater.Xb)] = paramZlibDeflater.Vb[1];
      a(paramZlibDeflater);
      a(arrayOfShort1, i4, paramZlibDeflater.Ub);
    } while (bool);
  }
  
  static void a(short[] paramArrayOfShort1, int paramInt, short[] paramArrayOfShort2)
  {
    boolean bool = ZlibStream.v;
    short[] arrayOfShort = new short[16];
    int i1 = 0;
    int i2 = 1;
    do
    {
      if (i2 > 15) {
        break;
      }
      short tmp38_37 = ((short)(i1 + paramArrayOfShort2[(i2 - 1)] << 1));
      i1 = tmp38_37;
      arrayOfShort[i2] = tmp38_37;
      i2++;
    } while (!bool);
    int i3 = 0;
    do
    {
      if (i3 > paramInt) {
        break;
      }
      int i4 = paramArrayOfShort1[(i3 * 2 + 1)];
      if (i4 != 0)
      {
        int tmp85_83 = i4;
        short[] tmp85_82 = arrayOfShort;
        short tmp87_86 = tmp85_82[tmp85_83];
        tmp85_82[tmp85_83] = ((short)(tmp87_86 + 1));
        paramArrayOfShort1[(i3 * 2)] = ((short)a(tmp87_86, i4));
      }
      i3++;
    } while (!bool);
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    boolean bool = ZlibStream.v;
    int i1 = 0;
    i1 |= paramInt1 & 0x1;
    paramInt1 >>>= 1;
    i1 <<= 1;
    paramInt2--;
    do
    {
      if (paramInt2 > 0) {
        break;
      }
    } while (bool);
    return i1 >>> 1;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.compression.zlib.Tree
 * JD-Core Version:    0.7.0.1
 */