package com.jscape.inet.scp.protocol.marshaling;

import com.jscape.inet.scp.protocol.messages.DirectoryMessage;
import com.jscape.inet.scp.protocol.messages.EndDirectoryMessage;
import com.jscape.inet.scp.protocol.messages.FatalErrorMessage;
import com.jscape.inet.scp.protocol.messages.FileMessage;
import com.jscape.inet.scp.protocol.messages.OkMessage;
import com.jscape.inet.scp.protocol.messages.TimeMessage;
import com.jscape.inet.scp.protocol.messages.WarningMessage;

public class ProtocolMessages
{
  private static final MessageCodec.Entry[] a = { new MessageCodec.Entry(0, OkMessage.class, new OkMessageCodec()), new MessageCodec.Entry(1, WarningMessage.class, new WarningMessageCodec()), new MessageCodec.Entry(2, FatalErrorMessage.class, new FatalErrorMessageCodec()), new MessageCodec.Entry(67, FileMessage.class, new FileMessageCodec()), new MessageCodec.Entry(68, DirectoryMessage.class, new DirectoryMessageCodec()), new MessageCodec.Entry(69, EndDirectoryMessage.class, new EndDirectoryMessageCodec()), new MessageCodec.Entry(84, TimeMessage.class, new TimeMessageCodec()) };
  
  public static MessageCodec init(MessageCodec paramMessageCodec)
  {
    return paramMessageCodec.set(a);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.marshaling.ProtocolMessages
 * JD-Core Version:    0.7.0.1
 */