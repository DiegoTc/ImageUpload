package com.jscape.inet.ssh.transport;

import com.jscape.inet.ssh.SshReader;
import com.jscape.inet.ssh.SshWriter;
import com.jscape.inet.ssh.types.SshByte;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Message
{
  private static final String a = -1;
  private static final Class[] b;
  protected final int type;
  protected long id = 0L;
  public static int c;
  
  public static Message readFrom(InputStream paramInputStream, Class paramClass)
    throws TransportException
  {
    try
    {
      Method localMethod = paramClass.getMethod(a, b);
      return (Message)localMethod.invoke(null, new Object[] { paramInputStream });
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getTargetException();
      throw new TransportException((localThrowable instanceof Exception) ? (Exception)localThrowable : localInvocationTargetException);
    }
    catch (Exception localException)
    {
      throw new TransportException(localException);
    }
  }
  
  public static Message readFrom(SshReader paramSshReader, Class paramClass)
    throws TransportException
  {
    try
    {
      Method localMethod = paramClass.getMethod(a, b);
      return (Message)localMethod.invoke(null, new Object[] { paramSshReader });
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getTargetException();
      throw new TransportException((localThrowable instanceof Exception) ? (Exception)localThrowable : localInvocationTargetException);
    }
    catch (Exception localException)
    {
      throw new TransportException(localException);
    }
  }
  
  protected Message(int paramInt)
  {
    this.type = paramInt;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramOutputStream);
    SshByte.writeIntTo(this.type, paramOutputStream);
  }
  
  public void writeTo(SshWriter paramSshWriter)
    throws IOException
  {
    u.a(paramSshWriter);
    paramSshWriter.writeByte(this.type);
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.Message
 * JD-Core Version:    0.7.0.1
 */