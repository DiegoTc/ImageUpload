package com.jscape.inet.scp.protocol.marshaling;

import com.jscape.inet.scp.protocol.messages.Message;
import com.jscape.util.ec;
import com.jscape.util.g.hb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class CodecBase
  implements hb<Message>
{
  protected static final char EOL = '\n';
  protected static final String SPACE = " ";
  protected static final String CHARSET = -1;
  public static boolean a;
  
  protected String readLine(InputStream paramInputStream)
    throws IOException
  {
    boolean bool = a;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    do
    {
      int i;
      if ((eof(i = paramInputStream.read())) || (i == 10)) {
        break;
      }
      localByteArrayOutputStream.write(i);
    } while (!bool);
    return ec.a(localByteArrayOutputStream.toByteArray(), CHARSET);
  }
  
  protected boolean eof(int paramInt)
  {
    if (!a) {}
    return paramInt == -1;
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.marshaling.CodecBase
 * JD-Core Version:    0.7.0.1
 */