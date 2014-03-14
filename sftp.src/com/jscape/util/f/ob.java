package com.jscape.util.f;

public abstract class ob<V>
{
  public abstract void a(V paramV);
  
  public ob<V> a(ob<? super V> paramob)
  {
    return new pb(this, paramob, null);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.ob
 * JD-Core Version:    0.7.0.1
 */