package com.jscape.inet.scp.protocol.marshaling;

import com.jscape.inet.scp.protocol.messages.EndDirectoryMessage;
import com.jscape.inet.scp.protocol.messages.Message;
import com.jscape.util.g.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EndDirectoryMessageCodec
  extends CodecBase
{
  private static final String z = -1;
  
  public Message read(InputStream paramInputStream)
    throws IOException
  {
    int i = b.a(paramInputStream) & 0xFF;
    if (i != 10) {
      throw new IOException(z);
    }
    return new EndDirectoryMessage();
  }
  
  public void write(Message paramMessage, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(10);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.marshaling.EndDirectoryMessageCodec
 * JD-Core Version:    0.7.0.1
 */