package com.jscape.util.f;

public abstract class hb<V>
{
  public static int a;
  
  public static <V> hb<V> a(hb<? super V> paramhb)
  {
    return new lb(paramhb);
  }
  
  public abstract boolean a(V paramV);
  
  public hb<V> a(hb<? super V>... paramVarArgs)
  {
    int k = a;
    Object localObject = this;
    hb<? super V>[] arrayOfhb = paramVarArgs;
    int i = arrayOfhb.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      hb<? super V> localhb = arrayOfhb[j];
      if (k != 0) {
        break label54;
      }
      localObject = new jb((hb)localObject, localhb);
      j++;
    } while (k == 0);
    label54:
    return localObject;
  }
  
  public hb<V> b(hb<? super V>... paramVarArgs)
  {
    int k = a;
    Object localObject = this;
    hb<? super V>[] arrayOfhb = paramVarArgs;
    int i = arrayOfhb.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      hb<? super V> localhb = arrayOfhb[j];
      if (k != 0) {
        break label54;
      }
      localObject = new mb((hb)localObject, localhb);
      j++;
    } while (k == 0);
    label54:
    return localObject;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.hb
 * JD-Core Version:    0.7.0.1
 */