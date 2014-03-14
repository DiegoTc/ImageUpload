package com.jscape.util.i;

import com.jscape.util.u;
import java.security.AccessController;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import sun.security.action.GetPropertyAction;

public class b
  extends Formatter
{
  private String a = (String)AccessController.doPrivileged(new GetPropertyAction(z));
  private static final String z = -1;
  
  public String format(LogRecord paramLogRecord)
  {
    int i = SimpleFormatter.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(formatMessage(paramLogRecord));
    localStringBuilder.append(this.a);
    if (u.a) {
      SimpleFormatter.a = ++i;
    }
    return localStringBuilder.toString();
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.i.b
 * JD-Core Version:    0.7.0.1
 */