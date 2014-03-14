package com.jscape.util.f;

public abstract class q
{
  public static final q a = new r();
  public static final q b = new s();
  
  public static q a(q paramq)
  {
    return new u(paramq);
  }
  
  public abstract boolean b();
  
  public q a(q... paramVarArgs)
  {
    int k = hb.a;
    Object localObject = this;
    q[] arrayOfq = paramVarArgs;
    int i = arrayOfq.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      q localq = arrayOfq[j];
      if (k != 0) {
        break label54;
      }
      localObject = new t((q)localObject, localq);
      j++;
    } while (k == 0);
    label54:
    if (com.jscape.util.u.a) {
      hb.a = ++k;
    }
    return localObject;
  }
  
  public q b(q... paramVarArgs)
  {
    int k = hb.a;
    Object localObject = this;
    q[] arrayOfq = paramVarArgs;
    int i = arrayOfq.length;
    int j = 0;
    while (j < i)
    {
      q localq = arrayOfq[j];
      if (k != 0) {
        break label68;
      }
      localObject = new v((q)localObject, localq);
      j++;
      if (k != 0) {
        com.jscape.util.u.a = !com.jscape.util.u.a;
      }
    }
    label68:
    return localObject;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.q
 * JD-Core Version:    0.7.0.1
 */