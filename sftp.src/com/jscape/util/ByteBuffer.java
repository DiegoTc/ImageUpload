package com.jscape.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class ByteBuffer
{
  private static final int DEFAULT_BUFFER_SIZE = 8096;
  private byte[] buffer;
  private int bytes;
  
  public ByteBuffer()
  {
    this(8096);
  }
  
  public ByteBuffer(int paramInt)
  {
    this.buffer = new byte[paramInt];
    this.bytes = 0;
  }
  
  public ByteBuffer(byte[] paramArrayOfByte)
  {
    this.buffer = paramArrayOfByte;
    this.bytes += paramArrayOfByte.length;
  }
  
  public void append(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.toByteArray();
    append(arrayOfByte);
  }
  
  public void append(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = bc.a;
    if (paramArrayOfByte != null)
    {
      expand(this.bytes + paramInt2);
      int i = 0;
      do
      {
        if (i >= paramInt2) {
          break;
        }
        this.buffer[(this.bytes++)] = paramArrayOfByte[(paramInt1 + i)];
        i++;
      } while (!bool);
    }
  }
  
  public void append(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      append(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public void append(byte paramByte)
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = paramByte;
    append(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void append(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    boolean bool = bc.a;
    byte[] arrayOfByte = null;
    if ((bool) || (paramString1 != null))
    {
      if (!bool) {
        if (paramString2 != null)
        {
          arrayOfByte = paramString1.getBytes(paramString2);
          break label42;
        }
      }
      arrayOfByte = paramString1.getBytes(Charset.defaultCharset());
      label42:
      append(arrayOfByte);
    }
  }
  
  public void append(char[] paramArrayOfChar)
  {
    boolean bool = bc.a;
    int i = 0;
    do
    {
      if (i >= paramArrayOfChar.length) {
        break;
      }
      append(paramArrayOfChar[i]);
      i++;
    } while (!bool);
  }
  
  public void append(char paramChar)
  {
    byte b = (byte)paramChar;
    append(b);
  }
  
  private void expand(int paramInt)
  {
    if ((bc.a) || (paramInt > this.buffer.length))
    {
      byte[] arrayOfByte = new byte[(int)(paramInt * 1.1D)];
      System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.bytes);
      this.buffer = arrayOfByte;
    }
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[this.bytes];
    System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.bytes);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return new String(this.buffer, 0, this.bytes, Charset.defaultCharset());
  }
  
  public String toString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(this.buffer, 0, this.bytes, paramString);
  }
  
  public int length()
  {
    return this.bytes;
  }
  
  public ByteBuffer getBuffer(int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    try
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, paramInt1, arrayOfByte, 0, i);
      return new ByteBuffer(arrayOfByte);
    }
    catch (Exception localException) {}
    return new ByteBuffer();
  }
  
  public ByteBuffer getBuffer(int paramInt)
  {
    return getBuffer(paramInt, this.bytes);
  }
  
  public int indexOf(byte paramByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = paramByte;
    return indexOf(arrayOfByte, paramInt);
  }
  
  public int indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0);
  }
  
  public synchronized int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = bc.a;
    int i = -1;
    int j = 0;
    int k = paramInt;
    label88:
    do
    {
      if (k >= this.bytes) {
        break;
      }
      int m = this.buffer[k];
      if (bool) {
        break label122;
      }
      if (!bool) {
        if (paramArrayOfByte[j] == m)
        {
          j++;
          if (!bool) {
            break label88;
          }
        }
      }
      if (!bool) {
        if (j != 0) {
          j = 0;
        }
      }
      if (!bool) {
        if (paramArrayOfByte[j] == m) {
          j++;
        }
      }
      if ((bool) || (j == paramArrayOfByte.length))
      {
        i = k - paramArrayOfByte.length + 1;
        if (!bool) {
          break;
        }
      }
      k++;
    } while (!bool);
    label122:
    return i;
  }
  
  public int indexOf(byte[] paramArrayOfByte)
  {
    return indexOf(paramArrayOfByte, 0);
  }
  
  public int indexOf(String paramString1, String paramString2, int paramInt)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = paramString1.getBytes(paramString2);
    return indexOf(arrayOfByte, paramInt);
  }
  
  public boolean contains(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    boolean bool2 = bc.a;
    boolean bool1 = false;
    if (!bool2) {
      if (paramBoolean)
      {
        if (!bool2) {}
        bool1 = indexOf(paramArrayOfByte) != -1;
        if (!bool2) {
          return bool1;
        }
      }
    }
    int i = 0;
    do
    {
      if (i >= paramArrayOfByte.length) {
        break;
      }
      if (bool2) {
        break label89;
      }
      if ((bool2) || (indexOf(paramArrayOfByte[i]) != -1))
      {
        bool1 = true;
        if (!bool2) {
          break;
        }
      }
      i++;
    } while (!bool2);
    label89:
    return bool1;
  }
  
  public boolean contains(byte[] paramArrayOfByte)
  {
    return contains(paramArrayOfByte, false);
  }
  
  public int indexOf(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return indexOf(paramString1, paramString2, 0);
  }
  
  public boolean startsWith(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    String str = toString(paramString2);
    return str.startsWith(paramString1);
  }
  
  public boolean endsWith(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    String str = toString(paramString2);
    return str.endsWith(paramString1);
  }
  
  public boolean equals(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    String str = toString(paramString2);
    return str.equals(paramString1);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = bc.a;
    if (!bool) {
      if (this == paramObject) {
        return true;
      }
    }
    if (paramObject != null)
    {
      if (bool) {
        break label37;
      }
      if (getClass() == paramObject.getClass()) {}
    }
    else
    {
      return false;
    }
    label37:
    ByteBuffer localByteBuffer = (ByteBuffer)paramObject;
    if (!bool) {
      if (this.bytes != localByteBuffer.bytes) {
        return false;
      }
    }
    if (!bool) {
      if (!Arrays.equals(this.buffer, localByteBuffer.buffer)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = Arrays.hashCode(this.buffer);
    i = 31 * i + this.bytes;
    return i;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.ByteBuffer
 * JD-Core Version:    0.7.0.1
 */