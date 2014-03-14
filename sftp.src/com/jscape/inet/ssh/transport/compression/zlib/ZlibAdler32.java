package com.jscape.inet.ssh.transport.compression.zlib;

final class ZlibAdler32
{
  private static final int a = 65521;
  private static final int b = 5552;
  
  long a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = ZlibStream.v;
    if (paramArrayOfByte == null) {
      return 1L;
    }
    long l1 = paramLong & 0xFFFF;
    long l2 = paramLong >> 16 & 0xFFFF;
    label509:
    do
    {
      if (paramInt2 <= 0) {
        break;
      }
      if (!bool) {}
      int i = paramInt2 < 5552 ? paramInt2 : 5552;
      paramInt2 -= i;
      do
      {
        if (i < 16) {
          break;
        }
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
        l2 += l1;
        i -= 16;
        if (bool) {
          break label530;
        }
      } while (!bool);
      if (!bool) {
        if (i == 0) {
          break label509;
        }
      }
      do
      {
        while (i != 0)
        {
          l1 += (paramArrayOfByte[(paramInt1++)] & 0xFF);
          l2 += l1;
          i--;
        }
        l1 %= 65521L;
        l2 %= 65521L;
      } while (bool);
    } while (!bool);
    label530:
    return l2 << 16 | l1;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.compression.zlib.ZlibAdler32
 * JD-Core Version:    0.7.0.1
 */