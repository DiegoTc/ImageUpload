package com.jscape.inet.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract interface m
{
  public abstract Socket a(String paramString, int paramInt)
    throws IOException, UnknownHostException;
  
  public abstract InputStream a(Socket paramSocket)
    throws IOException;
  
  public abstract OutputStream b(Socket paramSocket)
    throws IOException;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.util.m
 * JD-Core Version:    0.7.0.1
 */