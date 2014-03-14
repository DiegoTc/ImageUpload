package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoRequest;
import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoRequest.Prompt;
import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoResponse;
import com.jscape.inet.ssh.transport.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuccessiveKBIRequest
  extends AbstractKBIRequest
{
  private final List h;
  private int i;
  
  public SuccessiveKBIRequest()
  {
    this.h = new ArrayList();
  }
  
  public SuccessiveKBIRequest(SuccessiveKBIRequest paramSuccessiveKBIRequest)
  {
    super(paramSuccessiveKBIRequest);
    this.h = new ArrayList(paramSuccessiveKBIRequest.h);
  }
  
  public void addResponse(String paramString)
  {
    this.h.add(paramString);
  }
  
  public void removeResponse(int paramInt)
  {
    this.h.remove(paramInt);
  }
  
  public void setResponse(String paramString, int paramInt)
  {
    this.h.set(paramInt, paramString);
  }
  
  public void clearResponses()
  {
    this.h.clear();
  }
  
  public Object clone()
  {
    return new SuccessiveKBIRequest(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.i = 0;
  }
  
  protected Message processServerRequest(SshMsgUserauthInfoRequest paramSshMsgUserauthInfoRequest)
    throws IOException
  {
    boolean bool = AbstractAuthenticationRequest.g;
    SshMsgUserauthInfoRequest.Prompt[] arrayOfPrompt = paramSshMsgUserauthInfoRequest.getPrompts();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    do
    {
      if (j >= arrayOfPrompt.length) {
        break;
      }
      String str = (String)this.h.get(this.i);
      localArrayList.add(str);
      j++;
      this.i += 1;
    } while (!bool);
    return new SshMsgUserauthInfoResponse((String[])localArrayList.toArray(new String[localArrayList.size()]));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.SuccessiveKBIRequest
 * JD-Core Version:    0.7.0.1
 */