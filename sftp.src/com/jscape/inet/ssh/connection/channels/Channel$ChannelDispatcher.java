package com.jscape.inet.ssh.connection.channels;

import com.jscape.inet.ssh.connection.messages.ChannelDispatchable;
import com.jscape.inet.ssh.connection.messages.ChannelMessageDispatcher;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelClose;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelData;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelEof;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelExtendedData;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelFailure;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelRequest;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelSuccess;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelWindowAdjust;
import com.jscape.inet.ssh.transport.Message;
import java.io.IOException;

public class Channel$ChannelDispatcher
  implements ChannelMessageDispatcher
{
  final Channel a;
  private static final String z = -1;
  
  protected Channel$ChannelDispatcher(Channel paramChannel) {}
  
  public void onSshMsgChannelData(SshMsgChannelData paramSshMsgChannelData)
  {
    try
    {
      this.a.in.putData(paramSshMsgChannelData.getData());
    }
    catch (Exception localException)
    {
      this.a.close();
    }
  }
  
  public void onSshMsgChannelEof(SshMsgChannelEof paramSshMsgChannelEof)
  {
    this.a.in.close();
  }
  
  public void onSshMsgChannelExtendedData(SshMsgChannelExtendedData paramSshMsgChannelExtendedData)
  {
    this.a.extendedIn.putData(paramSshMsgChannelExtendedData.getDataTypeCode(), paramSshMsgChannelExtendedData.getData());
  }
  
  public void onSshMsgChannelRequest(SshMsgChannelRequest paramSshMsgChannelRequest)
  {
    if (z.equals(paramSshMsgChannelRequest.getRequestType())) {
      try
      {
        this.a.sendMessage(new SshMsgChannelFailure(Channel.Parameters.a(this.a.parameters)));
      }
      catch (IOException localIOException) {}
    }
  }
  
  public void onSshMsgChannelFailure(SshMsgChannelFailure paramSshMsgChannelFailure)
  {
    this.a.queueMessage(paramSshMsgChannelFailure);
  }
  
  public void onSshMsgChannelSuccess(SshMsgChannelSuccess paramSshMsgChannelSuccess)
  {
    this.a.queueMessage(paramSshMsgChannelSuccess);
  }
  
  public void onSshMsgChannelWindowAdjust(SshMsgChannelWindowAdjust paramSshMsgChannelWindowAdjust)
  {
    this.a.out.adjustWindow(paramSshMsgChannelWindowAdjust.getBytesToAdd());
  }
  
  public void onSshMsgChannelClose(SshMsgChannelClose paramSshMsgChannelClose)
  {
    this.a.queueMessage(paramSshMsgChannelClose);
    this.a.close();
  }
  
  public void dispatch(Message paramMessage)
  {
    if (!Channel.b) {
      if (!(paramMessage instanceof ChannelDispatchable)) {
        return;
      }
    }
    ((ChannelDispatchable)paramMessage).accept(this);
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.channels.Channel.ChannelDispatcher
 * JD-Core Version:    0.7.0.1
 */