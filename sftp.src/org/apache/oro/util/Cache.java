package org.apache.oro.util;

public abstract interface Cache
{
  public abstract void addElement(Object paramObject1, Object paramObject2);
  
  public abstract int capacity();
  
  public abstract Object getElement(Object paramObject);
  
  public abstract int size();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.util.Cache
 * JD-Core Version:    0.7.0.1
 */