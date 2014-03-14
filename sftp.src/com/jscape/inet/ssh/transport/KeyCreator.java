package com.jscape.inet.ssh.transport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class KeyCreator
{
  private static final char a = 'A';
  private static final char b = 'B';
  private static final char c = 'C';
  private static final char d = 'D';
  private static final char e = 'E';
  private static final char f = 'F';
  private final byte[] g;
  private final byte[] h;
  private final MessageDigest i;
  private volatile byte[] j = null;
  
  public KeyCreator(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, MessageDigest paramMessageDigest)
  {
    this.g = paramArrayOfByte1;
    this.h = paramArrayOfByte2;
    this.i = paramMessageDigest;
    this.j = this.h;
  }
  
  public void setSessionId(byte[] paramArrayOfByte)
  {
    this.j = ((byte[])paramArrayOfByte.clone());
  }
  
  public byte[] getExchangeHash()
  {
    return (byte[])this.h.clone();
  }
  
  public synchronized byte[] createClientServerIV(int paramInt)
    throws TransportException
  {
    return a('A', paramInt);
  }
  
  public synchronized byte[] createServerClientIV(int paramInt)
    throws TransportException
  {
    return a('B', paramInt);
  }
  
  public synchronized byte[] createClientServerCipherKey(int paramInt)
    throws TransportException
  {
    return a('C', paramInt);
  }
  
  public synchronized byte[] createServerClientCipherKey(int paramInt)
    throws TransportException
  {
    return a('D', paramInt);
  }
  
  public synchronized byte[] createClientServerMacKey(int paramInt)
    throws TransportException
  {
    return a('E', paramInt);
  }
  
  public synchronized byte[] createServerClientMacKey(int paramInt)
    throws TransportException
  {
    return a('F', paramInt);
  }
  
  private byte[] a(char paramChar, int paramInt)
    throws TransportException
  {
    this.i.reset();
    this.i.update(this.g);
    this.i.update(this.h);
    this.i.update((byte)paramChar);
    this.i.update(this.j);
    byte[] arrayOfByte1 = this.i.digest();
    if (Message.c == 0) {
      if (arrayOfByte1.length < paramInt) {
        arrayOfByte1 = a(arrayOfByte1, paramInt);
      }
    }
    byte[] arrayOfByte2 = new byte[paramInt];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    return arrayOfByte2;
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
    throws TransportException
  {
    int k = Message.c;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      localByteArrayOutputStream.write(paramArrayOfByte);
      do
      {
        if (localByteArrayOutputStream.size() >= paramInt) {
          break;
        }
        this.i.reset();
        this.i.update(this.g);
        this.i.update(this.h);
        this.i.update(localByteArrayOutputStream.toByteArray());
        if (k != 0) {
          break label88;
        }
        localByteArrayOutputStream.write(this.i.digest());
      } while (k == 0);
      label88:
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new TransportException(localIOException);
    }
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.KeyCreator
 * JD-Core Version:    0.7.0.1
 */