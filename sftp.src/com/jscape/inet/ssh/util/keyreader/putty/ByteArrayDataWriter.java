package com.jscape.inet.ssh.util.keyreader.putty;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteArrayDataWriter
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final DataOutput b = new DataOutputStream(this.a);
  
  public void writeInt(int paramInt)
    throws IOException
  {
    this.b.writeInt(paramInt);
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = this.a.toByteArray();
    this.a.reset();
    return arrayOfByte;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.keyreader.putty.ByteArrayDataWriter
 * JD-Core Version:    0.7.0.1
 */