package com.jscape.inet.ssh.authentication.requests;

import com.jscape.inet.ssh.authentication.AuthenticationException;
import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoRequest;
import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoRequest.Prompt;
import com.jscape.inet.ssh.authentication.messages.SshMsgUserauthInfoResponse;
import com.jscape.inet.ssh.transport.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegexKBIRequest
  extends AbstractKBIRequest
{
  private final List h;
  private static final String z = -1;
  
  public RegexKBIRequest()
  {
    this.h = new ArrayList();
  }
  
  public RegexKBIRequest(RegexKBIRequest paramRegexKBIRequest)
  {
    super(paramRegexKBIRequest);
    this.h = new ArrayList(paramRegexKBIRequest.h);
  }
  
  public RegexKBIRequest addResponse(String paramString1, String paramString2)
  {
    this.h.add(new RegexKBIRequest.RegexResponse(paramString1, paramString2));
    return this;
  }
  
  public RegexKBIRequest clearResponse(String paramString)
  {
    this.h.remove(new RegexKBIRequest.RegexResponse(paramString, ""));
    return this;
  }
  
  public RegexKBIRequest clearResponses()
  {
    this.h.clear();
    return this;
  }
  
  public Object clone()
  {
    return new RegexKBIRequest(this);
  }
  
  protected Message processServerRequest(SshMsgUserauthInfoRequest paramSshMsgUserauthInfoRequest)
    throws IOException
  {
    boolean bool = AbstractAuthenticationRequest.g;
    SshMsgUserauthInfoRequest.Prompt[] arrayOfPrompt = paramSshMsgUserauthInfoRequest.getPrompts();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    do
    {
      if (i >= arrayOfPrompt.length) {
        break;
      }
      String str1 = arrayOfPrompt[i].getPromptString();
      String str2 = a(str1);
      if (!bool)
      {
        if (str2 == null) {
          throw new AuthenticationException(z + str1);
        }
        localArrayList.add(str2);
        i++;
      }
    } while (!bool);
    return new SshMsgUserauthInfoResponse((String[])localArrayList.toArray(new String[localArrayList.size()]));
  }
  
  private String a(String paramString)
  {
    boolean bool = AbstractAuthenticationRequest.g;
    int i = 0;
    int j = this.h.size();
    do
    {
      if (i >= j) {
        break;
      }
      RegexKBIRequest.RegexResponse localRegexResponse = (RegexKBIRequest.RegexResponse)this.h.get(i);
      if (!bool)
      {
        if (localRegexResponse.matches(paramString)) {
          return localRegexResponse.getResponse();
        }
        i++;
      }
    } while (!bool);
    return null;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.authentication.requests.RegexKBIRequest
 * JD-Core Version:    0.7.0.1
 */