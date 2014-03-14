package com.jscape.inet.scp.protocol.messages;

import com.jscape.util.j.a.fb;

public abstract class Command<H extends Command.HandlerBase>
{
  public static boolean a;
  
  public abstract void accept(H paramH, fb paramfb);
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.scp.protocol.messages.Command
 * JD-Core Version:    0.7.0.1
 */