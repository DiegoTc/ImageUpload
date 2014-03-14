package com.jscape.util.f;

public abstract class m<F, S>
{
  public abstract void a(F paramF, S paramS);
  
  public m<F, S> a(m<? super F, ? super S> paramm)
  {
    return new n(this, paramm, null);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.m
 * JD-Core Version:    0.7.0.1
 */