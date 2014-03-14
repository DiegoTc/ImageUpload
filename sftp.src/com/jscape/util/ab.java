package com.jscape.util;

public class ab
{
  private static final int a = -1;
  private static final int b = 10;
  private byte[] c;
  private int d;
  private int e;
  
  public ab(byte[] paramArrayOfByte)
  {
    u.a(paramArrayOfByte);
    this.c = ((byte[])paramArrayOfByte.clone());
    this.e = this.c.length;
  }
  
  public ab(int paramInt)
  {
    this.c = new byte[paramInt];
  }
  
  public ab()
  {
    this(10);
  }
  
  public synchronized int b()
  {
    return this.e - this.d;
  }
  
  public synchronized void a(int paramInt)
  {
    b(1);
    this.c[(this.e++)] = ((byte)(paramInt & 0xFF));
  }
  
  public synchronized void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    u.a(paramArrayOfByte, paramInt1, paramInt2);
    b(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.c, this.e, paramInt2);
    this.e += paramInt2;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public synchronized int c()
  {
    if (!bc.a) {
      if (b() == 0) {
        return -1;
      }
    }
    return this.c[(this.d++)] & 0xFF;
  }
  
  public synchronized int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = bc.a;
    u.a(paramArrayOfByte, paramInt1, paramInt2);
    if (!bool)
    {
      if (b() == 0) {
        return -1;
      }
      if (bool) {
        break label43;
      }
    }
    label43:
    int i = b() > paramInt2 ? paramInt2 : b();
    System.arraycopy(this.c, this.d, paramArrayOfByte, paramInt1, i);
    this.d += i;
    return i;
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void b(int paramInt)
  {
    boolean bool = bc.a;
    int i = this.c.length - this.e;
    if (!bool) {
      if (i >= paramInt) {
        return;
      }
    }
    int j = b() + paramInt;
    if (!bool) {}
    int k = this.c.length > 0 ? this.c.length : 10;
    do
    {
      if (k >= j) {
        break;
      }
      if (bool) {
        break label83;
      }
      k *= 2;
    } while (!bool);
    label83:
    byte[] arrayOfByte = new byte[k];
    System.arraycopy(this.c, this.d, arrayOfByte, 0, b());
    int m = b();
    this.c = arrayOfByte;
    this.d = 0;
    this.e = m;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.ab
 * JD-Core Version:    0.7.0.1
 */