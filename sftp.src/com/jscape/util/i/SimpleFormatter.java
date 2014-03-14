package com.jscape.util.i;

import com.jscape.util.fc;
import com.jscape.util.lb;
import com.jscape.util.u;
import java.util.Calendar;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

@fc
public class SimpleFormatter
  extends Formatter
{
  private static final String TEMPLATE = -1;
  public static int a;
  
  public String format(LogRecord paramLogRecord)
  {
    int i = a;
    if (i != 0) {
      u.a = !u.a;
    }
    return String.format(TEMPLATE, new Object[] { Calendar.getInstance(), paramLogRecord.getLevel().getLocalizedName(), formatMessage(paramLogRecord), (i != 0) || (paramLogRecord.getThrown() != null) ? lb.a(paramLogRecord.getThrown()) : "" });
  }
  
  static
  {
    break label13;
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.i.SimpleFormatter
 * JD-Core Version:    0.7.0.1
 */