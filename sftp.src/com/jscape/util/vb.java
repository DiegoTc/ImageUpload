package com.jscape.util;

public class vb
  implements kb
{
  public static final kb a = new vb();
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!bc.a) {}
    return paramArrayOfByte[paramInt] != 0;
  }
  
  public char b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (char)(paramArrayOfByte[paramInt] & 0xFF);
    i = (char)(i | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8);
    return i;
  }
  
  public short c(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (short)(paramArrayOfByte[paramInt] & 0xFF);
    i = (short)(i | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8);
    return i;
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt] & 0xFF;
    i |= (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8;
    i |= (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16;
    i |= (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
    return i;
  }
  
  public long e(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = bc.a;
    long l = paramArrayOfByte[paramInt] & 0xFF;
    l |= (paramArrayOfByte[(paramInt + 6)] & 0xFF) << 8;
    l |= (paramArrayOfByte[(paramInt + 5)] & 0xFF) << 16;
    l |= (paramArrayOfByte[(paramInt + 4)] & 0xFF) << 24;
    l |= (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 32;
    l |= (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 40;
    l |= (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 48;
    l |= (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56;
    if (bool) {
      u.a = !u.a;
    }
    return l;
  }
  
  public float f(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(d(paramArrayOfByte, paramInt));
  }
  
  public double g(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(e(paramArrayOfByte, paramInt));
  }
  
  public byte[] a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (!bc.a) {}
    paramArrayOfByte[paramInt] = ((byte)(paramBoolean ? 1 : 0));
    return paramArrayOfByte;
  }
  
  public byte[] a(char paramChar, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)paramChar);
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramChar >>> '\b'));
    return paramArrayOfByte;
  }
  
  public byte[] a(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)paramShort);
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort >>> 8));
    return paramArrayOfByte;
  }
  
  public byte[] a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)paramInt1);
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >>> 24));
    return paramArrayOfByte;
  }
  
  public byte[] a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)paramLong);
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >>> 16));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >>> 24));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >>> 32));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >>> 40));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >>> 48));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong >>> 56));
    return paramArrayOfByte;
  }
  
  public byte[] a(float paramFloat, byte[] paramArrayOfByte, int paramInt)
  {
    return a(Float.floatToIntBits(paramFloat), paramArrayOfByte, paramInt);
  }
  
  public byte[] a(double paramDouble, byte[] paramArrayOfByte, int paramInt)
  {
    return a(Double.doubleToLongBits(paramDouble), paramArrayOfByte, paramInt);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.vb
 * JD-Core Version:    0.7.0.1
 */