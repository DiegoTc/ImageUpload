package com.jscape.inet.ssh.connection;

import com.jscape.inet.ssh.connection.channels.Channel;
import com.jscape.inet.ssh.connection.messages.ConnectionDispatchable;
import com.jscape.inet.ssh.connection.messages.ConnectionMessageDispatcher;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelOpen;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelOpenConfirmation;
import com.jscape.inet.ssh.connection.messages.SshMsgChannelOpenFailure;
import com.jscape.inet.ssh.connection.messages.SshMsgGlobalRequest;
import com.jscape.inet.ssh.connection.messages.SshMsgRequestFailure;
import com.jscape.inet.ssh.connection.messages.SshMsgRequestSuccess;
import com.jscape.inet.ssh.transport.Message;
import java.util.Map;

public class Connection$Dispatcher
  implements ConnectionMessageDispatcher
{
  final Connection a;
  
  protected Connection$Dispatcher(Connection paramConnection) {}
  
  public void dispatch(Message paramMessage)
  {
    if (Connection.a == 0) {
      if (!(paramMessage instanceof ConnectionDispatchable)) {
        return;
      }
    }
    ((ConnectionDispatchable)paramMessage).accept(this);
  }
  
  public void onSsgMsgRequestFailure(SshMsgRequestFailure paramSshMsgRequestFailure)
  {
    this.a.enqueueMessage(paramSshMsgRequestFailure);
  }
  
  public void onSshMsgRequestSuccess(SshMsgRequestSuccess paramSshMsgRequestSuccess)
  {
    this.a.enqueueMessage(paramSshMsgRequestSuccess);
  }
  
  public void onSshMsgChannelOpen(SshMsgChannelOpen paramSshMsgChannelOpen)
  {
    this.a.handleChannelRequest(paramSshMsgChannelOpen);
  }
  
  public void onSshMsgChannelOpenConfirmation(SshMsgChannelOpenConfirmation paramSshMsgChannelOpenConfirmation)
  {
    this.a.enqueueMessage(paramSshMsgChannelOpenConfirmation);
  }
  
  public void onSshMsgChannelOpenFailure(SshMsgChannelOpenFailure paramSshMsgChannelOpenFailure)
  {
    this.a.enqueueMessage(paramSshMsgChannelOpenFailure);
  }
  
  public void onSshMsgChannel(long paramLong, Message paramMessage)
  {
    Channel localChannel = (Channel)this.a.channels.get(Long.valueOf(paramLong));
    if ((Connection.a != 0) || (localChannel != null)) {
      localChannel.onMessage(paramMessage);
    }
  }
  
  public void onSshMsgGlobalRequest(SshMsgGlobalRequest paramSshMsgGlobalRequest)
  {
    this.a.handleGlobalRequest(paramSshMsgGlobalRequest);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.connection.Connection.Dispatcher
 * JD-Core Version:    0.7.0.1
 */