package com.jscape.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class LineReader
  extends FilterInputStream
{
  private char[] delim = { '\r', '\n' };
  private boolean hasDelimiter = false;
  private boolean endOfStream = false;
  
  public LineReader(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public LineReader(InputStream paramInputStream, char[] paramArrayOfChar)
  {
    this(paramInputStream);
    this.delim = paramArrayOfChar;
  }
  
  public boolean hasDelimiter()
  {
    return this.hasDelimiter;
  }
  
  public String readLine(String paramString)
    throws IOException
  {
    boolean bool = bc.a;
    this.hasDelimiter = false;
    ByteBuffer localByteBuffer = new ByteBuffer();
    int i = 0;
    if (!bool) {
      if (this.endOfStream) {
        return null;
      }
    }
    label135:
    do
    {
      if (this.endOfStream) {
        break;
      }
      int j = this.in.read();
      if (!bool)
      {
        if (j == -1)
        {
          this.endOfStream = true;
          if (!bool) {
            break;
          }
        }
        localByteBuffer.append((byte)j);
        if (bool) {}
      }
      else if (this.delim[i] == j)
      {
        i++;
        if (!bool) {
          break label135;
        }
      }
      if (!bool) {
        if (i != 0) {
          i = 0;
        }
      }
      if (!bool) {
        if (this.delim[i] == j) {
          i++;
        }
      }
      if (i == this.delim.length)
      {
        this.hasDelimiter = true;
        if (!bool) {
          break;
        }
      }
    } while (!bool);
    byte[] arrayOfByte = null;
    if (!bool) {
      if (this.hasDelimiter)
      {
        if (!bool) {
          if (this.endOfStream)
          {
            if (bool) {
              break label214;
            }
            if (localByteBuffer.length() == this.delim.length) {
              return null;
            }
          }
        }
        label214:
        arrayOfByte = new byte[localByteBuffer.length() - this.delim.length];
        break label230;
      }
    }
    arrayOfByte = new byte[localByteBuffer.length()];
    label230:
    System.arraycopy(localByteBuffer.toByteArray(), 0, arrayOfByte, 0, arrayOfByte.length);
    if (!bool) {
      if (paramString != null) {
        return new String(arrayOfByte, paramString);
      }
    }
    return new String(arrayOfByte, Charset.defaultCharset());
  }
  
  public String readLine()
    throws IOException
  {
    return readLine(null);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.LineReader
 * JD-Core Version:    0.7.0.1
 */