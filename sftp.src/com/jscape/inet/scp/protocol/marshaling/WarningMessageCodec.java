package com.jscape.inet.scp.protocol.marshaling;

import com.jscape.inet.scp.protocol.messages.Message;
import com.jscape.inet.scp.protocol.messages.WarningMessage;
import com.jscape.util.ec;
import com.jscape.util.qb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WarningMessageCodec
  extends CodecBase
{
  private static final String z = -1;
  
  public Message read(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      String str = readLine(paramInputStream);
      return new WarningMessage(str);
    }
    catch (Exception localException)
    {
      throw qb.a(localException);
    }
  }
  
  public void write(Message paramMessage, OutputStream paramOutputStream)
    throws IOException
  {
    WarningMessage localWarningMessage = (WarningMessage)paramMessage;
    byte[] arrayOfByte = ec.b(localWarningMessage.message, z);
    paramOutputStream.write(arrayOfByte);
    paramOutputStream.write(10);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.marshaling.WarningMessageCodec
 * JD-Core Version:    0.7.0.1
 */