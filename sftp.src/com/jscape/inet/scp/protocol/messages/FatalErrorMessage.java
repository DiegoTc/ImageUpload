package com.jscape.inet.scp.protocol.messages;

import com.jscape.util.u;

public class FatalErrorMessage
  implements Message
{
  public final String message;
  private static final String z = -1;
  
  public FatalErrorMessage(String paramString)
  {
    u.a(paramString);
    this.message = paramString;
  }
  
  public String toString()
  {
    return z + this.message + '\'' + '}';
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.messages.FatalErrorMessage
 * JD-Core Version:    0.7.0.1
 */