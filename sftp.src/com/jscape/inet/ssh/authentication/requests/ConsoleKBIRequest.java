package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoRequest;
import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoRequest.Prompt;
import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoResponse;
import com.jscape.inet.ssh.transport.Message;
import com.jscape.util.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ConsoleKBIRequest
  extends AbstractKBIRequest
{
  public ConsoleKBIRequest() {}
  
  public ConsoleKBIRequest(ConsoleKBIRequest paramConsoleKBIRequest)
  {
    super(paramConsoleKBIRequest);
  }
  
  public Object clone()
  {
    return new ConsoleKBIRequest(this);
  }
  
  protected Message processServerRequest(SshMsgUserauthInfoRequest paramSshMsgUserauthInfoRequest)
    throws IOException
  {
    boolean bool = AbstractAuthenticationRequest.g;
    System.out.println(paramSshMsgUserauthInfoRequest.getName());
    System.out.println(paramSshMsgUserauthInfoRequest.getInstruction());
    SshMsgUserauthInfoRequest.Prompt[] arrayOfPrompt = paramSshMsgUserauthInfoRequest.getPrompts();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < arrayOfPrompt.length)
    {
      System.out.print(arrayOfPrompt[i].getPromptString());
      localArrayList.add(localBufferedReader.readLine());
      i++;
      if (bool) {
        u.a = !u.a;
      }
    }
    return new SshMsgUserauthInfoResponse((String[])localArrayList.toArray(new String[localArrayList.size()]));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.ConsoleKBIRequest
 * JD-Core Version:    0.7.0.1
 */