package com.jscape.inet.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;

public abstract interface FtpFileParser
{
  public abstract Enumeration parse(BufferedReader paramBufferedReader)
    throws IOException;
  
  public abstract Date getFileDate(String paramString)
    throws ParseException;
  
  public abstract Date getDateTime(FtpFile paramFtpFile)
    throws ParseException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.FtpFileParser
 * JD-Core Version:    0.7.0.1
 */