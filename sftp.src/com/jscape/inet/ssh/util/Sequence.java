package com.jscape.inet.ssh.util;

public class Sequence
{
  public static final long MIN_VALUE = 0L;
  public static final long MAX_VALUE = 4294967295L;
  private long a = 0L;
  
  public synchronized long nextValue()
  {
    long l = this.a++;
    if (!SshParameters.h) {
      if (this.a == 4294967296L) {
        this.a = 0L;
      }
    }
    return l;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ssh.util.Sequence
 * JD-Core Version:    0.7.0.1
 */