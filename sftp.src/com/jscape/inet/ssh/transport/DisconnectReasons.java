package com.jscape.inet.ssh.transport;

public class DisconnectReasons
{
  public static final int HOST_NOT_ALLOWED_TO_CONNECT = 1;
  public static final int PROTOCOL_ERROR = 2;
  public static final int KEY_EXCHANGE_FAILED = 3;
  public static final int RESERVED = 4;
  public static final int MAC_ERROR = 5;
  public static final int COMPRESSION_ERROR = 6;
  public static final int SERVICE_NOT_AVAILABLE = 7;
  public static final int PROTOCOL_VERSION_NOT_SUPPORTED = 8;
  public static final int HOST_KEY_NOT_VERIFIABLE = 9;
  public static final int CONNECTION_LOST = 10;
  public static final int BY_APPLICATION = 11;
  public static final int TOO_MANY_CONNECTIONS = 12;
  public static final int AUTH_CANCELLED_BY_USER = 13;
  public static final int NO_MORE_AUTH_METHODS_AVAILABLE = 14;
  public static final int ILLEGAL_USER_NAME = 15;
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.transport.DisconnectReasons
 * JD-Core Version:    0.7.0.1
 */