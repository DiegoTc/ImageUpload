package com.jscape.inet.scp.protocol.marshaling;

import com.jscape.inet.scp.protocol.messages.Message;
import com.jscape.inet.scp.protocol.messages.OkMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OkMessageCodec
  extends CodecBase
{
  public Message read(InputStream paramInputStream)
    throws IOException
  {
    return new OkMessage();
  }
  
  public void write(Message paramMessage, OutputStream paramOutputStream)
    throws IOException
  {}
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.marshaling.OkMessageCodec
 * JD-Core Version:    0.7.0.1
 */