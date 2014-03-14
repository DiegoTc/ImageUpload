package com.jscape.inet.ssh.authentication.messages;

import com.jscape.inet.ssh.types.SshBoolean;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SshMsgUserauthInfoRequest$Prompt
{
  private final String a;
  private final boolean b;
  public static boolean c;
  private static final String z = -1;
  
  public static Prompt readFrom(InputStream paramInputStream)
    throws IOException
  {
    u.a(paramInputStream);
    String str = new String(SshString.readValue(paramInputStream), z);
    boolean bool = SshBoolean.readBooleanFrom(paramInputStream);
    return new Prompt(str, bool);
  }
  
  public SshMsgUserauthInfoRequest$Prompt(String paramString, boolean paramBoolean)
  {
    u.a(paramString);
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public String getPromptString()
  {
    return this.a;
  }
  
  public boolean echo()
  {
    return this.b;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramOutputStream);
    SshString.writeValue(this.a.getBytes(z), paramOutputStream);
    SshBoolean.writeBooleanTo(this.b, paramOutputStream);
  }
  
  public String toString()
  {
    return this.a;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoRequest.Prompt
 * JD-Core Version:    0.7.0.1
 */