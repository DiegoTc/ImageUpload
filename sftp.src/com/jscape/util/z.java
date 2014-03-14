package com.jscape.util;

public class z
{
  private byte[] a;
  private int b;
  
  public z(int paramInt)
  {
    this.a = new byte[paramInt];
    this.b = 0;
  }
  
  public byte[] b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.a.length;
  }
  
  public void a(int paramInt)
  {
    if (!bc.a) {
      if (this.a.length < paramInt) {
        b(paramInt - this.b);
      }
    }
    this.b = paramInt;
  }
  
  public int e()
  {
    return this.a.length - this.b;
  }
  
  public void b(int paramInt)
  {
    if (!bc.a) {
      if (e() > paramInt) {
        return;
      }
    }
    int i = paramInt - e();
    byte[] arrayOfByte = new byte[(int)((this.a.length + i) * 1.5D)];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    this.a = arrayOfByte;
  }
  
  public void a(byte paramByte)
  {
    b(1);
    this.a[this.b] = paramByte;
    this.b += 1;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b += paramInt2;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt1 + paramInt3;
    int j = this.b - paramInt1;
    int k = paramInt3 + j;
    b(paramInt1 + k - this.b);
    System.arraycopy(this.a, paramInt1, this.a, i, j);
    System.arraycopy(paramArrayOfByte, paramInt2, this.a, paramInt1, paramInt3);
  }
  
  public byte c(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public void a(byte paramByte, int paramInt)
  {
    if (paramInt < this.b)
    {
      this.a[paramInt] = paramByte;
      if (!bc.a) {}
    }
    else
    {
      a(paramByte);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - (this.b - paramInt3);
    if (!bc.a)
    {
      if (i > 0) {
        b(i);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, paramInt3, paramInt2);
      this.b = (paramInt3 + paramInt2);
    }
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    boolean bool = bc.a;
    if (!bool) {
      if (c() < paramArrayOfByte.length) {
        return false;
      }
    }
    int i = 0;
    do
    {
      if (i >= paramArrayOfByte.length) {
        break;
      }
      if (bool) {
        break label56;
      }
      if ((bool) || (paramArrayOfByte[i] != c(i))) {
        return false;
      }
      i++;
    } while (!bool);
    label56:
    return true;
  }
  
  public boolean c(byte[] paramArrayOfByte)
  {
    boolean bool = bc.a;
    if (!bool) {
      if (c() < paramArrayOfByte.length) {
        return false;
      }
    }
    int i = 0;
    int j = c() - paramArrayOfByte.length;
    do
    {
      if (i >= paramArrayOfByte.length) {
        break;
      }
      if (bool) {
        break label72;
      }
      if ((bool) || (paramArrayOfByte[i] != c(j))) {
        return false;
      }
      i++;
      j++;
    } while (!bool);
    label72:
    return true;
  }
  
  public int b(byte paramByte)
  {
    boolean bool = bc.a;
    int i = 0;
    do
    {
      if (i >= this.a.length) {
        break;
      }
      if (bool) {
        break label43;
      }
      if ((bool) || (paramByte == this.a[i])) {
        return i;
      }
      i++;
    } while (!bool);
    label43:
    return -1;
  }
  
  public int c(byte paramByte)
  {
    boolean bool = bc.a;
    int i = this.a.length - 1;
    int j = i;
    do
    {
      if (j < i) {
        break;
      }
      if (bool) {
        break label51;
      }
      if ((bool) || (paramByte == this.a[j])) {
        return j;
      }
      j--;
    } while (!bool);
    label51:
    return -1;
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    System.arraycopy(this.a, paramInt2, this.a, paramInt1, this.b - paramInt2);
    this.b -= paramInt2 - paramInt1;
  }
  
  public void f()
  {
    boolean bool = bc.a;
    int i = 0;
    int j = this.b - 1;
    do
    {
      if (i >= j) {
        break;
      }
      int k = this.a[i];
      this.a[i] = this.a[j];
      this.a[j] = k;
      i++;
      j--;
    } while (!bool);
  }
  
  public void g()
  {
    this.b = 0;
  }
  
  public byte[] b(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(this.a, paramInt1, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] h()
  {
    return b(0, this.b);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    return ec.a(this.a, paramInt1, paramInt2, paramString);
  }
  
  public String a(int paramInt, String paramString)
  {
    return a(paramInt, c() - paramInt, paramString);
  }
  
  public String a(String paramString)
  {
    return a(0, c(), paramString);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.z
 * JD-Core Version:    0.7.0.1
 */