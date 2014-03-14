package com.jscape.util.f;

public abstract class e<F, S>
{
  public static <F, S> e<F, S> a(e<? super F, ? super S> parame)
  {
    return new h(parame);
  }
  
  public abstract boolean a(F paramF, S paramS);
  
  public e<F, S> a(e<? super F, ? super S>... paramVarArgs)
  {
    int k = hb.a;
    Object localObject = this;
    e<? super F, ? super S>[] arrayOfe = paramVarArgs;
    int i = arrayOfe.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      e<? super F, ? super S> locale = arrayOfe[j];
      if (k != 0) {
        break label54;
      }
      localObject = new f((e)localObject, locale);
      j++;
    } while (k == 0);
    label54:
    return localObject;
  }
  
  public e<F, S> b(e<? super F, ? super S>... paramVarArgs)
  {
    int k = hb.a;
    Object localObject = this;
    e<? super F, ? super S>[] arrayOfe = paramVarArgs;
    int i = arrayOfe.length;
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      e<? super F, ? super S> locale = arrayOfe[j];
      if (k != 0) {
        break label54;
      }
      localObject = new i((e)localObject, locale);
      j++;
    } while (k == 0);
    label54:
    return localObject;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.f.e
 * JD-Core Version:    0.7.0.1
 */